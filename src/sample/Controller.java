package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    TextArea textArea;

    @FXML
    TextField textField;


    public void sentMsg() {
        if (!textField.getText().trim().isEmpty()) {
            textArea.appendText("Вы: " + textField.getText().trim() + "\n");
            textField.clear();
            textField.requestFocus();
        }
    }

    public void textFieldSelectAll() {
        textField.selectAll();
    }

    public void textFieldClear() {
        textField.clear();
    }

}
