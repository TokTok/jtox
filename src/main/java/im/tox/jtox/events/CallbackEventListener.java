package im.tox.jtox.events;

import im.tox.tox4j.core.callbacks.*;
import im.tox.tox4j.core.enums.ToxConnection;
import im.tox.tox4j.core.enums.ToxFileControl;
import im.tox.tox4j.core.enums.ToxMessageType;
import im.tox.tox4j.core.enums.ToxUserStatus;

public class CallbackEventListener<S> implements ToxCoreEventListener<S> {
    public final Callbacks<SelfConnectionStatusCallback<S>> selfConnectionStatus = new Callbacks<>();
    @Override
    public S selfConnectionStatus(ToxConnection connectionStatus, S toxState) {
        for (SelfConnectionStatusCallback<S> child : selfConnectionStatus.callbacks.values()) {
            toxState = child.selfConnectionStatus(connectionStatus, toxState);
        }
        return toxState;
    }

    public final Callbacks<FileRecvControlCallback<S>> fileRecvControl = new Callbacks<>();
    @Override
    public S fileRecvControl(int friendNumber, int fileNumber, ToxFileControl control, S toxState) {
        for (FileRecvControlCallback<S> child : fileRecvControl.callbacks.values()) {
            toxState = child.fileRecvControl(friendNumber, fileNumber, control, toxState);
        }
        return toxState;
    }

    public final Callbacks<FileRecvCallback<S>> fileRecv = new Callbacks<>();
    @Override
    public S fileRecv(int friendNumber, int fileNumber, int kind, long fileSize, byte[] filename, S toxState) {
        for (FileRecvCallback<S> child : fileRecv.callbacks.values()) {
            toxState = child.fileRecv(friendNumber, fileNumber, kind, fileSize, filename, toxState);
        }
        return toxState;
    }

    public final Callbacks<FileRecvChunkCallback<S>> fileRecvChunk = new Callbacks<>();
    @Override
    public S fileRecvChunk(int friendNumber, int fileNumber, long position, byte[] data, S toxState) {
        for (FileRecvChunkCallback<S> child : fileRecvChunk.callbacks.values()) {
            toxState = child.fileRecvChunk(friendNumber, fileNumber, position, data, toxState);
        }
        return toxState;
    }

    public final Callbacks<FileChunkRequestCallback<S>> fileChunkRequest = new Callbacks<>();
    @Override
    public S fileChunkRequest(int friendNumber, int fileNumber, long position, int length, S toxState) {
        for (FileChunkRequestCallback<S> child : fileChunkRequest.callbacks.values()) {
            toxState = child.fileChunkRequest(friendNumber, fileNumber, position, length, toxState);
        }
        return toxState;
    }

    public final Callbacks<FriendConnectionStatusCallback<S>> friendConnectionStatus = new Callbacks<>();
    @Override
    public S friendConnectionStatus(int friendNumber, ToxConnection connectionStatus, S toxState) {
        for (FriendConnectionStatusCallback<S> child : friendConnectionStatus.callbacks.values()) {
            toxState = child.friendConnectionStatus(friendNumber, connectionStatus, toxState);
        }
        return toxState;
    }

    public final Callbacks<FriendMessageCallback<S>> friendMessage = new Callbacks<>();
    @Override
    public S friendMessage(int friendNumber, ToxMessageType messageType, int timeDelta, byte[] message, S toxState) {
        for (FriendMessageCallback<S> child : friendMessage.callbacks.values()) {
            toxState = child.friendMessage(friendNumber, messageType, timeDelta, message, toxState);
        }
        return toxState;
    }

    public final Callbacks<FriendNameCallback<S>> friendName = new Callbacks<>();
    @Override
    public S friendName(int friendNumber, byte[] name, S toxState) {
        for (FriendNameCallback<S> child : friendName.callbacks.values()) {
            toxState = child.friendName(friendNumber, name, toxState);
        }
        return toxState;
    }

    public final Callbacks<FriendRequestCallback<S>> friendRequest = new Callbacks<>();
    @Override
    public S friendRequest(byte[] publicKey, int timeDelta, byte[] message, S toxState) {
        for (FriendRequestCallback<S> child : friendRequest.callbacks.values()) {
            toxState = child.friendRequest(publicKey, timeDelta, message, toxState);
        }
        return toxState;
    }

    public final Callbacks<FriendStatusCallback<S>> friendStatus = new Callbacks<>();
    @Override
    public S friendStatus(int friendNumber, ToxUserStatus status, S toxState) {
        for (FriendStatusCallback<S> child : friendStatus.callbacks.values()) {
            toxState = child.friendStatus(friendNumber, status, toxState);
        }
        return toxState;
    }

    public final Callbacks<FriendStatusMessageCallback<S>> friendStatusMessage = new Callbacks<>();
    @Override
    public S friendStatusMessage(int friendNumber, byte[] message, S toxState) {
        for (FriendStatusMessageCallback<S> child : friendStatusMessage.callbacks.values()) {
            toxState = child.friendStatusMessage(friendNumber, message, toxState);
        }
        return toxState;
    }

    public final Callbacks<FriendTypingCallback<S>> friendTyping = new Callbacks<>();
    @Override
    public S friendTyping(int friendNumber, boolean isTyping, S toxState) {
        for (FriendTypingCallback<S> child : friendTyping.callbacks.values()) {
            toxState = child.friendTyping(friendNumber, isTyping, toxState);
        }
        return toxState;
    }

    public final Callbacks<FriendLosslessPacketCallback<S>> friendLosslessPacket = new Callbacks<>();
    @Override
    public S friendLosslessPacket(int friendNumber, byte[] data, S toxState) {
        for (FriendLosslessPacketCallback<S> child : friendLosslessPacket.callbacks.values()) {
            toxState = child.friendLosslessPacket(friendNumber, data, toxState);
        }
        return toxState;
    }

    public final Callbacks<FriendLossyPacketCallback<S>> friendLossyPacket = new Callbacks<>();
    @Override
    public S friendLossyPacket(int friendNumber, byte[] data, S toxState) {
        for (FriendLossyPacketCallback<S> child : friendLossyPacket.callbacks.values()) {
            toxState = child.friendLossyPacket(friendNumber, data, toxState);
        }
        return toxState;
    }

    public final Callbacks<FriendReadReceiptCallback<S>> friendReadReceipt = new Callbacks<>();
    @Override
    public S friendReadReceipt(int friendNumber, int messageId, S toxState) {
        for (FriendReadReceiptCallback<S> child : friendReadReceipt.callbacks.values()) {
            toxState = child.friendReadReceipt(friendNumber, messageId, toxState);
        }
        return toxState;
    }
}
