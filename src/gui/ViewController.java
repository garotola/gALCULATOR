package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ViewController implements Initializable{
    
    
    @FXML private Button buttonDigit1;
    @FXML private Button buttonDigit2;
    @FXML private Button buttonDigit3;
    @FXML private Button buttonDigit4;
    @FXML private Button buttonDigit5;
    @FXML private Button buttonDigit6;
    @FXML private Button buttonDigit7;
    @FXML private Button buttonDigit8;
    @FXML private Button buttonDigit9;
    @FXML private Button buttonDigit0;
    @FXML private Button buttonSoma;
    @FXML private Button buttonSub;
    @FXML private Button buttonMul;
    @FXML private Button buttonDiv;

    @FXML
    private Button buttonResult;
    @FXML
    private Label labelResult;

    @FXML
    private void onActionButtonResult(){
        String expression = labelResult.getText();
        String[] split = expression.split(" ");
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonDigit1.setOnAction(setOnAction(buttonDigit1));
        buttonDigit2.setOnAction(setOnAction(buttonDigit2));
        buttonDigit3.setOnAction(setOnAction(buttonDigit3));
        buttonDigit4.setOnAction(setOnAction(buttonDigit4));
        buttonDigit5.setOnAction(setOnAction(buttonDigit5));
        buttonDigit6.setOnAction(setOnAction(buttonDigit6));
        buttonDigit7.setOnAction(setOnAction(buttonDigit7));
        buttonDigit8.setOnAction(setOnAction(buttonDigit8));
        buttonDigit9.setOnAction(setOnAction(buttonDigit9));
        buttonDigit0.setOnAction(setOnAction(buttonDigit0));
        buttonSoma.setOnAction(setOnAction(buttonSoma));
        buttonSub.setOnAction(setOnAction(buttonSub));
        buttonMul.setOnAction(setOnAction(buttonMul));
        buttonDiv.setOnAction(setOnAction(buttonDiv));
        
    }

    private EventHandler<ActionEvent> setOnAction(Button button){
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                setTextResult(button);
            }
        };
    }

    private void setTextResult(Button buttonDigit){
        if(labelResult.getText().equals("0")) labelResult.setText(buttonDigit.getText());
        else labelResult.setText(labelResult.getText() + buttonDigit.getText());
    }

    //Apagar tudo
    //Apagar um digito
}
