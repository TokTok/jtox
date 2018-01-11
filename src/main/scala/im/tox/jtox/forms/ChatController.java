package im.tox.jtox.forms;

import im.tox.jtox.ToxThread;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    public ListView<String> lstChatLog;
    public TextField txtInput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToxThread.events.friendMessage.add((friendNumber, messageType, timeDelta, message, state) -> {
            lstChatLog.getItems().add(String.format("%d: %s", friendNumber, new String(message)));
            return state;
        });
    }
}
