package sample;
import dictionary.DictionaryCommandline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import dictionary.Word;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Genuine Coder
 */
public class Scene2Controller implements Initializable {
    @FXML
    DictionaryCommandline dictionaryCommandline2 = new DictionaryCommandline();
    @FXML
    public AnchorPane children;
    @FXML
    private TextField display;
    @FXML
    public TextField InputTarget;
    @FXML
    public TextField InputExplain;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void transferMessage(String message) {
        display.setText(message);
    }

    @FXML
    public void buttonBoardBack(ActionEvent actionEvent) throws Exception {
        Pane rootNew = FXMLLoader.load(getClass().getResource("sample.fxml"));
        children.getChildren().setAll(rootNew);

    }


    public void mouseSave(javafx.scene.input.MouseEvent event) {
        String target = InputTarget.getText().trim();
        String explain = InputExplain.getText().trim();
        Word addword = new Word(target, explain);
        dictionaryCommandline2.result.add(addword);
    }
}