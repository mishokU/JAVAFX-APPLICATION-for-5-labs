package sample;

import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class MainButtons {

    MainButtons() {
        setButtons();
    }

    private Button textGCD = new Button("Greatest Common Divisor");
    private Button textIT  = new Button("Inherintance Task");
    private Button textTN  = new Button("Thread Numbers");
    private Button textTW  = new Button("Thread Workers");

    private Button[] buttons = new Button[]{textGCD,textIT,textTN,textTW};

    public void setButtons() {
        for (int i = 0; i < buttons.length; i++) {
            //Parameters for all buttons
            buttons[i].setFont(Font.getDefault());
            buttons[i].setMinWidth(320);
            buttons[i].setMinHeight(200);
            buttons[i].setTextAlignment(TextAlignment.CENTER);
            buttons[i].setShape(new Rectangle(320,200));
        }
        textGCD.setTranslateX(320);
        textGCD.setTranslateY(0);
        textGCD.setStyle("-fx-background-color: cyan; -fx-font-size: 24px");

        textIT.setTranslateX(0);
        textIT.setTranslateY(0);
        textIT.setStyle("-fx-background-color: orange; -fx-font-size: 24px;");

        textTN.setTranslateX(0);
        textTN.setTranslateY(200);
        textTN.setStyle("-fx-background-color: #4D97DB; -fx-font-size: 24px;");

        textTW.setTranslateY(200);
        textTW.setTranslateX(320);
        textTW.setStyle("-fx-background-color: #F2F091; -fx-font-size: 24px;");
    }

    public Button[] getBookTitles(){
        return buttons;
    }
}
