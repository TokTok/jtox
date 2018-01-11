package im.tox.jtox.forms;

import im.tox.jtox.Keys;
import im.tox.jtox.ToxThread;
import im.tox.jtox.events.ComposedEventListener;
import im.tox.jtox.events.GuiEventListener;
import im.tox.jtox.events.LoggingEventListener;
import im.tox.tox4j.core.ToxCoreConstants;
import im.tox.tox4j.core.exceptions.ToxBootstrapException;
import im.tox.tox4j.core.exceptions.ToxFriendAddException;
import im.tox.tox4j.core.options.ProxyOptions;
import im.tox.tox4j.core.options.SaveDataOptions;
import im.tox.tox4j.core.options.ToxOptions;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ConnectionController implements Initializable {
    public CheckBox chkEnableIpv6;
    public CheckBox chkEnableUdp;
    public CheckBox chkEnableLanDiscovery;
    public RadioButton btnProxyNone;
    public RadioButton btnProxyHttp;
    public RadioButton btnProxySocks;
    public Button btnInitialise;
    public Button btnBootstrap;
    public Button btnAddFriend;
    public ToggleGroup proxyType;
    public TextField txtProxyHost;
    public TextField txtProxyPort;
    public TextField txtBootstrapHost;
    public TextField txtBootstrapPort;
    public TextField txtBootstrapKey;
    public TextField txtFriendAddress;
    public TextField txtFriendMessage;
    public TextField txtAddress;

    private interface ProxyType {
        ProxyOptions create();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnProxyNone.setUserData((ProxyType) () -> ProxyOptions.None$.MODULE$);
        btnProxyHttp.setUserData((ProxyType) () ->
                new ProxyOptions.Http(txtProxyHost.getText(), Integer.parseInt(txtProxyPort.getText())));
        btnProxySocks.setUserData((ProxyType) () ->
                new ProxyOptions.Socks5(txtProxyHost.getText(), Integer.parseInt(txtProxyPort.getText())));
    }

    public void btnInitialiseClicked(ActionEvent actionEvent) {
        ToxThread.start(new ToxOptions(
                chkEnableIpv6.isSelected(),
                chkEnableUdp.isSelected(),
                chkEnableLanDiscovery.isSelected(),
                ((ProxyType) proxyType.getSelectedToggle().getUserData()).create(),
                ToxCoreConstants.DefaultStartPort(),
                ToxCoreConstants.DefaultEndPort(),
                ToxCoreConstants.DefaultTcpPort(),
                SaveDataOptions.None$.MODULE$,
                true
        ), new ComposedEventListener<>(
                new GuiEventListener(this),
                new LoggingEventListener<>())
        );

        txtAddress.setText(Keys.readablePublicKey(ToxThread.core().getAddress()));

        btnBootstrap.setDisable(false);
        btnAddFriend.setDisable(false);
    }

    public void btnBootstrapClicked(ActionEvent actionEvent) throws ToxBootstrapException {
        ToxThread.core().bootstrap(
                txtBootstrapHost.getText(),
                Integer.parseInt(txtBootstrapPort.getText()),
                Keys.parsePublicKey(txtBootstrapKey.getText())
        );
    }

    public void btnAddFriendClicked(ActionEvent actionEvent) throws ToxFriendAddException {
        ToxThread.core().addFriend(
                Keys.parsePublicKey(txtFriendAddress.getText()),
                txtFriendMessage.getText().getBytes()
        );
    }
}
