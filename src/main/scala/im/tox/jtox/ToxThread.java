package im.tox.jtox;

import im.tox.tox4j.av.ToxAv;
import im.tox.tox4j.core.ToxCore;
import im.tox.tox4j.core.callbacks.ToxCoreEventListener;
import im.tox.tox4j.core.options.ToxOptions;
import im.tox.tox4j.crypto.ToxCrypto;
import im.tox.tox4j.impl.jni.ToxAvImpl;
import im.tox.tox4j.impl.jni.ToxCoreImpl;
import im.tox.tox4j.impl.jni.ToxCryptoImpl;
import im.tox.tox4j.impl.jni.ToxCryptoImpl$;
import org.jetbrains.annotations.NotNull;

public class ToxThread {
    private static ToxThread tox;

    private final ToxCrypto crypto;
    private final ToxCore core;
    private final ToxAv av;
    private final Thread thread;
    private boolean running = true;
    private ToxState state = new ToxState();

    private ToxThread(ToxOptions options, ToxCoreEventListener<ToxState> eventListener) {
        ToxCoreImpl core = new ToxCoreImpl(options);
        this.crypto = ToxCryptoImpl$.MODULE$;
        this.core = core;
        this.av = new ToxAvImpl(core);

        this.thread = new Thread(() -> {
            try (ToxCore localCore = this.core) {
                while (running) {
                    try {
                        Thread.sleep(localCore.iterationInterval());
                    } catch (InterruptedException e) {
                        return;
                    }
                    state = localCore.iterate(eventListener, state);
                }
            }
        });
        this.thread.start();
    }

    @NotNull
    public static ToxCrypto crypto() {
        if (tox == null) {
            throw new RuntimeException("ToxThread was not started");
        }
        return tox.crypto;
    }

    @NotNull
    public static ToxCore core() {
        if (tox == null) {
            throw new RuntimeException("ToxThread was not started");
        }
        return tox.core;
    }

    @NotNull
    public static ToxAv av() {
        if (tox == null) {
            throw new RuntimeException("ToxThread was not started");
        }
        return tox.av;
    }

    public static void start(@NotNull ToxOptions options, @NotNull ToxCoreEventListener<ToxState> eventListener) {
        if (tox != null) {
            try {
                stop();
            } catch (InterruptedException e) {
                // ignore
            }
        }
        tox = new ToxThread(options, eventListener);
    }

    public static void stop() throws InterruptedException {
        tox.running = false;
        tox.thread.join();
        tox = null;
    }
}
