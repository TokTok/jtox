package im.tox.jtox.events;

import im.tox.jtox.ToxState;
import im.tox.jtox.forms.ConnectionController;
import im.tox.tox4j.core.callbacks.ToxCoreEventAdapter;
import im.tox.tox4j.core.callbacks.ToxCoreEventListener;
import im.tox.tox4j.core.enums.ToxConnection;

public class GuiEventListener extends ToxCoreEventAdapter<ToxState> {
    private final ConnectionController connectionController;

    public GuiEventListener(ConnectionController connectionController) {
        this.connectionController = connectionController;
    }

    @Override
    public ToxState selfConnectionStatus(ToxConnection connectionStatus, ToxState toxState) {
        return super.selfConnectionStatus(connectionStatus, toxState);
    }

    @Override
    public ToxState friendConnectionStatus(int friendNumber, ToxConnection connectionStatus, ToxState toxState) {
        return super.friendConnectionStatus(friendNumber, connectionStatus, toxState);
    }
}
