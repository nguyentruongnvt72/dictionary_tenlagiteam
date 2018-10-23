package sample;

import dictionary.DictionaryCommandline;
import dictionary.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;


public class Controller {
    @FXML
    public TextField InputTarget;
    @FXML
    public TextField InputExplain;
    @FXML
    public TextField Input;
    @FXML
    public ListView<String> listView;
    @FXML
    public ObservableList<String> list = FXCollections.observableArrayList();
    @FXML
    public WebView webViewExplain;
    @FXML
    public  WebView webViewExplainSearch;
    @FXML
    private Pane rootPane;
    @FXML
    DictionaryCommandline dictionaryCommandline= new DictionaryCommandline();
    @FXML
    public Button button;

    @FXML
    public void handleClickListViewMou(MouseEvent event) {
        String value = listView.getSelectionModel().getSelectedItem();
        //DictionaryManagement dictionaryManagement = new DictionaryManagement();
        webViewExplain.getEngine().loadContent(dictionaryCommandline.dictionaryLookup(value), "text/html");
    }
    @FXML
    public void handleClickListViewKey(KeyEvent event) {
        String value = listView.getSelectionModel().getSelectedItem();
        //DictionaryManagement dictionaryManagement = new DictionaryManagement();
        webViewExplain.getEngine().loadContent(dictionaryCommandline.dictionaryLookup(value), "text/html");
    }
    @FXML
    public void handleClickListViewBinarySearcher(MouseEvent event) {
        String value = listView.getSelectionModel().getSelectedItem();
        //DictionaryManagement dictionaryManagement = new DictionaryManagement();
        webViewExplain.getEngine().loadContent(dictionaryCommandline.dictionaryLookup(value), "text/html");
    }
    @FXML
    public void handleClickListViewSearch(MouseEvent event){
        String input = Input.getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String value ;
        value = dictionaryCommandline.dictionarySearcher(input).get(0);
        webViewExplain.getEngine().loadContent(dictionaryCommandline.dictionaryLookup(value), "text/html");
    }
    @FXML
    public  void update(KeyEvent event){
        listView.getItems().setAll(dictionaryCommandline.dictionarySearcher(Input.getText()));
    }
    @FXML
     public void handle(ActionEvent event) throws Exception{
//        Parent rootNew = FXMLLoader.load(getClass().getResource("addWord.fxml"));
//        Stage primaryStageNew = new Stage();
//        primaryStageNew.setTitle("ADD WORD");
//        primaryStageNew.setScene(new Scene(rootNew, 909, 675));
//        primaryStageNew.show();
        Pane rootnew = FXMLLoader.load(getClass().getResource("addWord.fxml"));
        rootPane.getChildren().setAll(rootnew);
    }
    @FXML
    public void mouseSave(MouseEvent event){
        String target = InputTarget.getText();
        String explain = InputExplain.getText();
        Word addword = new Word(target, explain);
        dictionaryCommandline.insertFromCommandline(target,explain);
    }

}