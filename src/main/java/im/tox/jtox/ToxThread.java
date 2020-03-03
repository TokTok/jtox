package im.tox.jtox;

import im.tox.jtox.events.CallbackEventListener;
import im.tox.jtox.events.ComposedEventListener;
import im.tox.jtox.events.LoggingEventListener;
import im.tox.jtox.model.State;
import im.tox.tox4j.av.ToxAv;
import im.tox.tox4j.core.ToxCore;
import im.tox.tox4j.core.options.ToxOptions;
import im.tox.tox4j.crypto.ToxCrypto;
import im.tox.tox4j.impl.jni.ToxAvImpl;
import im.tox.tox4j.impl.jni.ToxCoreImpl;
import im.tox.tox4j.impl.jni.ToxCryptoImpl$;
import org.jetbrains.annotations.NotNull;

public class ToxThread {
    private static ToxThread tox;
    public static final CallbackEventListener<State> events = new CallbackEventListener<>();

    private final ToxCrypto crypto;
    private final ToxCore core;
    private final ToxAv av;
    private final Thread thread;
    private boolean running = true;
    private State state = new State();

    private ToxThread(ToxOptions options) {
        ToxCoreImpl core = new ToxCoreImpl(options);
        this.crypto = ToxCryptoImpl$.MODULE$;
        this.core = core;
        this.av = new ToxAvImpl(core);

        this.thread = new Thread(() -> {
            ComposedEventListener<State> eventListener = new ComposedEventListener<>(
                    events, new LoggingEventListener<>());
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

    public static void start(@NotNull ToxOptions options) {
        try {
            stop();
        } catch (InterruptedException e) {
            // ignore
        }
        tox = new ToxThread(options);
    }

    public static void stop() throws InterruptedException {
        if (tox == null) return;
        tox.running = false;
        tox.thread.join();
        tox = null;
    }
}
