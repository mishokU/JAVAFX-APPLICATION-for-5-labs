package sample;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import static sample.utils.isInteger;

public class GreatestCommonDivisor {

    private int max = 0;
    private Text showMaxText = new Text();

    private Text getText() {
        Text previewText = new Text("Welcome to first task!" + "\n" + "Please input your numbers from two to N");
        previewText.setTextAlignment(TextAlignment.CENTER);
        previewText.setTranslateX(120);
        previewText.setTranslateY(100);
        previewText.setStyle("-fx-font-size: 20px; -fx-color: yellow;");
        previewText.setFont(Font.font("Arial"));
        return previewText;
    }

    private TextField getTextField(){
        TextField fieldForNumbers = new TextField();
        fieldForNumbers.setTranslateX(230);
        fieldForNumbers.setTranslateY(150);
        fieldForNumbers.setStyle("-fx-border-style: solid; -fx-border-color: gold; -fx-border-width: 5px;");
        fieldForNumbers.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER && fieldForNumbers.getCharacters().length() != 0){
                countGCD(fieldForNumbers.getCharacters());
            }
        });
        return fieldForNumbers;
    }

    private int gcd(int first, int second) {
        if(second == 0) {
            return Math.abs(first);
        }
        return gcd(second, first % second);
    }

    private void countGCD(CharSequence charSequence){

        showMaxText.setTranslateX(130);
        showMaxText.setTranslateY(250);
        showMaxText.setStyle("-fx-font-size: 24;");

        String[] str = charSequence.toString().trim().split("\\s+");
        boolean isInt = true;

        for(String s : str){
            if(!isInteger(s)){
                isInt = false;
            }
        }

        if(isInt) {
            max = Integer.parseInt(str[0]);
            for (int i = 1; i < str.length; i++) {
                max = gcd(max, Integer.parseInt(str[i]));
            }
            showMaxText.setText("Max greatest common divider is: " + max);
        }else {
            showMaxText.setText("Maybe you fill correct?");
        }
    }

    public Node[] getAllElements(){
        Node[] nodes = new Node[]{getTextField(),getText(),showMaxText};
        return nodes;
    }
}
