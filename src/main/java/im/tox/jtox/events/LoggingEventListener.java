package im.tox.jtox.events;

import im.tox.tox4j.core.callbacks.ToxCoreEventListener;
import im.tox.tox4j.core.enums.ToxConnection;
import im.tox.tox4j.core.enums.ToxFileControl;
import im.tox.tox4j.core.enums.ToxMessageType;
import im.tox.tox4j.core.enums.ToxUserStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingEventListener<S> implements ToxCoreEventListener<S> {
    private static final Logger logger = LoggerFactory.getLogger(LoggingEventListener.class);

    @Override
    public S selfConnectionStatus(ToxConnection connectionStatus, S toxState) {
        logger.debug("selfConnectionStatus({})", connectionStatus);
        return toxState;
    }

    @Override
    public S fileRecvControl(int friendNumber, int fileNumber, ToxFileControl control, S toxState) {
        logger.debug("fileRecvControl(friendNumber: {}, fileNumber: {}, control: {})", friendNumber, fileNumber, control);
        return toxState;
    }

    @Override
    public S fileRecv(int friendNumber, int fileNumber, int kind, long fileSize, byte[] filename, S toxState) {
        logger.debug("fileRecv(friendNumber: {}, fileNumber: {}, kind: {}, fileSize: {}, filename: {})", friendNumber, fileNumber, kind, fileSize, filename);
        return toxState;
    }

    @Override
    public S fileRecvChunk(int friendNumber, int fileNumber, long position, byte[] data, S toxState) {
        logger.debug("fileRecvChunk(friendNumber: {}, fileNumber: {}, position: {}, data: {})", friendNumber, fileNumber, position, data);
        return toxState;
    }

    @Override
    public S fileChunkRequest(int friendNumber, int fileNumber, long position, int length, S toxState) {
        logger.debug("fileChunkRequest(friendNumber: {}, fileNumber: {}, position: {}, length: {})", friendNumber, fileNumber, position, length);
        return toxState;
    }

    @Override
    public S friendConnectionStatus(int friendNumber, ToxConnection connectionStatus, S toxState) {
        logger.debug("friendConnectionStatus(friendNumber: {}, connectionStatus: {})", friendNumber, connectionStatus);
        return toxState;
    }

    @Override
    public S friendMessage(int friendNumber, ToxMessageType messageType, int timeDelta, byte[] message, S toxState) {
        logger.debug("friendMessage(friendNumber: {}, messageType: {}, timeDelta: {}, message: {})", friendNumber, messageType, timeDelta, message);
        return toxState;
    }

    @Override
    public S friendName(int friendNumber, byte[] name, S toxState) {
        logger.debug("friendName(friendNumber: {}, name: {})", friendNumber, name);
        return toxState;
    }

    @Override
    public S friendRequest(byte[] publicKey, int timeDelta, byte[] message, S toxState) {
        logger.debug("friendRequest(publicKey: {}, timeDelta: {}, message: {})", publicKey, timeDelta, message);
        return toxState;
    }

    @Override
    public S friendStatus(int friendNumber, ToxUserStatus status, S toxState) {
        logger.debug("friendStatus(friendNumber: {}, status: {})", friendNumber, status);
        return toxState;
    }

    @Override
    public S friendStatusMessage(int friendNumber, byte[] message, S toxState) {
        logger.debug("friendStatusMessage(friendNumber: {}, message: {})", friendNumber, message);
        return toxState;
    }

    @Override
    public S friendTyping(int friendNumber, boolean isTyping, S toxState) {
        logger.debug("friendTyping(friendNumber: {}, isTyping: {})", friendNumber, isTyping);
        return toxState;
    }

    @Override
    public S friendLosslessPacket(int friendNumber, byte[] data, S toxState) {
        logger.debug("friendLosslessPacket(friendNumber: {}, data: {})", friendNumber, data);
        return toxState;
    }

    @Override
    public S friendLossyPacket(int friendNumber, byte[] data, S toxState) {
        logger.debug("friendLossyPacket(friendNumber: {}, data: {})", friendNumber, data);
        return toxState;
    }

    @Override
    public S friendReadReceipt(int friendNumber, int messageId, S toxState) {
        logger.debug("friendReadReceipt(friendNumber: {}, messageId: {})", friendNumber, messageId);
        return toxState;
    }
}
