package sample;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

import static sample.utils.isInteger;

public class InheritanceTask {

    private List<Creep> listOfCreatures = new ArrayList<Creep>();
    private TextArea textMethods = new TextArea();

    private Text getText(){
        Text previewText = new Text("Enter the number of iterations!");
        previewText.setTranslateY(50);
        previewText.setTranslateX(80);
        previewText.setStyle("-fx-font-size: 20px; -fx-color: #C676C6;");
        return previewText;
    }

    private TextField getTextField(){
        TextField numberField = new TextField();
        numberField.setTranslateY(30);
        numberField.setTranslateX(360);
        numberField.setMaxWidth(35);
        numberField.setOnKeyPressed(keyEvent ->  {
            textMethods.clear();
            listOfCreatures.clear();
            if(keyEvent.getCode() == KeyCode.ENTER) {
                setListOfCreatures(numberField.getCharacters());
                setTextArea();
            }
        });
        return numberField;
    }

    private void setListOfCreatures(CharSequence charSequence){
        String[] str = charSequence.toString().trim().split("\\s+");
        if(isInteger(str[0])) {
            for (int i = 0; i < Integer.parseInt(str[0]); i++) {
                if (i % 2 == 0) {
                    listOfCreatures.add(new Dog());
                } else {
                    listOfCreatures.add(new Snake());
                }
            }
        }
    }

    private void setTextArea(){
        StringBuilder strB = new StringBuilder();
        for(Creep list : listOfCreatures){
            strB.append(list.whoIAm() + "\n");
            if(list.creep() != null) {
                strB.append(list.creep() + "\n");
            }
            if(list.wriggle() != null){
                strB.append(list.wriggle() + "\n");
            }
        }
        textMethods.setText(strB.toString());
    }

    public TextArea getTextArea(){
        textMethods.setTranslateY(80);
        textMethods.setTranslateX(80);
        textMethods.setMaxHeight(250);
        textMethods.setMaxWidth(250);
        textMethods.setEditable(false);
        textMethods.setStyle("-fx-font-size: 24px");
        return textMethods;
    }

    public Node[] getAllElements(){
        Node[] nodes = new Node[]{getText(),getTextField(),getTextArea()};
        return nodes;
    }
}
