package im.tox.jtox.events;

import java.util.Map;
import java.util.TreeMap;

public final class Callbacks<T> {
    final Map<Integer, T> callbacks = new TreeMap<>();
    private int lastId = 0;

    public CallbackKey<T> add(T callback) {
        Integer id = lastId++;
        callbacks.put(id, callback);
        return new CallbackKey<>(this, id);
    }
}
