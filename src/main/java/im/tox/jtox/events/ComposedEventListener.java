package im.tox.jtox.events;

import im.tox.tox4j.core.callbacks.ToxCoreEventListener;
import im.tox.tox4j.core.enums.ToxConnection;
import im.tox.tox4j.core.enums.ToxFileControl;
import im.tox.tox4j.core.enums.ToxMessageType;
import im.tox.tox4j.core.enums.ToxUserStatus;

import java.util.Arrays;

public class ComposedEventListener<S> implements ToxCoreEventListener<S> {
    private final Iterable<ToxCoreEventListener<S>> children;

    private ComposedEventListener(Iterable<ToxCoreEventListener<S>> children) {
        this.children = children;
    }

    public ComposedEventListener(ToxCoreEventListener<S> child1, ToxCoreEventListener<S> child2) {
        this(Arrays.asList(child1, child2));
    }

    @Override
    public S selfConnectionStatus(ToxConnection connectionStatus, S toxState) {
        for (ToxCoreEventListener<S> child : children) {
            toxState = child.selfConnectionStatus(connectionStatus, toxState);
        }
        return toxState;
    }

    @Override
    public S fileRecvControl(int friendNumber, int fileNumber, ToxFileControl control, S toxState) {
        for (ToxCoreEventListener<S> child : children) {
            toxState = child.fileRecvControl(friendNumber, fileNumber, control, toxState);
        }
        return toxState;
    }

    @Override
    public S fileRecv(int friendNumber, int fileNumber, int kind, long fileSize, byte[] filename, S toxState) {
        for (ToxCoreEventListener<S> child : children) {
            toxState = child.fileRecv(friendNumber, fileNumber, kind, fileSize, filename, toxState);
        }
        return toxState;
    }

    @Override
    public S fileRecvChunk(int friendNumber, int fileNumber, long position, byte[] data, S toxState) {
        for (ToxCoreEventListener<S> child : children) {
            toxState = child.fileRecvChunk(friendNumber, fileNumber, position, data, toxState);
        }
        return toxState;
    }

    @Override
    public S fileChunkRequest(int friendNumber, int fileNumber, long position, int length, S toxState) {
        for (ToxCoreEventListener<S> child : children) {
            toxState = child.fileChunkRequest(friendNumber, fileNumber, position, length, toxState);
        }
        return toxState;
    }

    @Override
    public S friendConnectionStatus(int friendNumber, ToxConnection connectionStatus, S toxState) {
        for (ToxCoreEventListener<S> child : children) {
            toxState = child.friendConnectionStatus(friendNumber, connectionStatus, toxState);
        }
        return toxState;
    }

    @Override
    public S friendMessage(int friendNumber, ToxMessageType messageType, int timeDelta, byte[] message, S toxState) {
        for (ToxCoreEventListener<S> child : children) {
            toxState = child.friendMessage(friendNumber, messageType, timeDelta, message, toxState);
        }
        return toxState;
    }

    @Override
    public S friendName(int friendNumber, byte[] name, S toxState) {
        for (ToxCoreEventListener<S> child : children) {
            toxState = child.friendName(friendNumber, name, toxState);
        }
        return toxState;
    }

    @Override
    public S friendRequest(byte[] publicKey, int timeDelta, byte[] message, S toxState) {
        for (ToxCoreEventListener<S> child : children) {
            toxState = child.friendRequest(publicKey, timeDelta, message, toxState);
        }
        return toxState;
    }

    @Override
    public S friendStatus(int friendNumber, ToxUserStatus status, S toxState) {
        for (ToxCoreEventListener<S> child : children) {
            toxState = child.friendStatus(friendNumber, status, toxState);
        }
        return toxState;
    }

    @Override
    public S friendStatusMessage(int friendNumber, byte[] message, S toxState) {
        for (ToxCoreEventListener<S> child : children) {
            toxState = child.friendStatusMessage(friendNumber, message, toxState);
        }
        return toxState;
    }

    @Override
    public S friendTyping(int friendNumber, boolean isTyping, S toxState) {
        for (ToxCoreEventListener<S> child : children) {
            toxState = child.friendTyping(friendNumber, isTyping, toxState);
        }
        return toxState;
    }

    @Override
    public S friendLosslessPacket(int friendNumber, byte[] data, S toxState) {
        for (ToxCoreEventListener<S> child : children) {
            toxState = child.friendLosslessPacket(friendNumber, data, toxState);
        }
        return toxState;
    }

    @Override
    public S friendLossyPacket(int friendNumber, byte[] data, S toxState) {
        for (ToxCoreEventListener<S> child : children) {
            toxState = child.friendLossyPacket(friendNumber, data, toxState);
        }
        return toxState;
    }

    @Override
    public S friendReadReceipt(int friendNumber, int messageId, S toxState) {
        for (ToxCoreEventListener<S> child : children) {
            toxState = child.friendReadReceipt(friendNumber, messageId, toxState);
        }
        return toxState;
    }
}
