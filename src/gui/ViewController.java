package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
        double result = 0; String expression; 
        String[] ops = {"*", "/", "+", "-"};
        expression = labelResult.getText();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(expression.split(" ")));
        
        for (int i = 0; i < ops.length; i+=2) {
            String op1 = ops[i];
            String op2 = ops[i + 1];
            while(list.contains(op1) || list.contains(op2)){
                int index; String op;
                int indexOp1 = list.indexOf(op1);
                int indexOp2 = list.indexOf(op2);
                if((list.contains(op1) && list.contains(op2) && indexOp1 < indexOp2) || !list.contains(op2)){
                    op = op1;
                    index = indexOp1;
                }else{
                    op = op2;
                    index = indexOp2;
                }
                result = operation(op, list.get(index - 1),list.get(index + 1));
                //System.out.println(result);
                list.set(index, String.valueOf(result));
                list.remove(index - 1);
                list.remove(index);
            }
        }

        labelResult.setText("0");
        setTextResult(String.valueOf(result));
    }

    private double operation(String op, String str1, String str2){
        double num1 = Double.parseDouble(str1);
        double num2 = Double.parseDouble(str2);


        return switch(op){
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };
        
    }

    @FXML
    private void onActionButtonCe(){
        if(labelResult.getText().length() > 0)
            labelResult.setText(labelResult.getText().substring(0, labelResult.getText().length() - 1));
    }

    @FXML
    private void onActionButtonC(){
        labelResult.setText("0");
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
                setTextResult(button.getText());
            }
        };
    }

    private void setTextResult(String text){
        if(labelResult.getText().equals("0.0") || labelResult.getText().equals("0")) labelResult.setText(text);
        else labelResult.setText(labelResult.getText() + text);
    }

    //Apagar tudo
    //Apagar um digito
}
