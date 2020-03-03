package im.tox.jtox.events;

public final class CallbackKey<T> {
    private final Callbacks<T> callbacks;
    private final Integer key;

    CallbackKey(Callbacks<T> callbacks, Integer key) {
        this.callbacks = callbacks;
        this.key = key;
    }

    public void delete() {
        callbacks.callbacks.remove(key);
    }
}
