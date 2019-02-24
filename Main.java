package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Scanner;

public class Main extends Application {

    public Scene mainScene,gcdScene,inheritanceScene,threadNumberScene,threadWorkersScene;

    @Override
    public void start(Stage primaryStage) {

        MainButtons buttons = new MainButtons();
        GreatestCommonDivisor GCD = new GreatestCommonDivisor();
        InheritanceTask inheritanceTask = new InheritanceTask();

        //Set Actions to each button
        buttons.getBookTitles()[0].setOnAction(e -> primaryStage.setScene(gcdScene));
        buttons.getBookTitles()[1].setOnAction(e -> primaryStage.setScene(inheritanceScene));
        buttons.getBookTitles()[2].setOnAction(e -> primaryStage.setScene(threadNumberScene));
        buttons.getBookTitles()[3].setOnAction(e -> primaryStage.setScene(threadWorkersScene));

        //Create groups and scenes for tasks
        Group gcdGroup = new Group(GCD.getAllElements());
        gcdScene = new Scene(gcdGroup,200,200, Color.AQUA);

        Group inhGroup = new Group(inheritanceTask.getAllElements());
        inheritanceScene = new Scene(inhGroup,200,200,Color.BISQUE);

        Group numberLayout = new Group();
        threadNumberScene = new Scene(numberLayout,200,200);

        Group workersLayout = new Group();
        threadWorkersScene = new Scene(workersLayout,200,200);

        //Create mass of groups for define the same param's to all group
        Group[] groups = new Group[]{gcdGroup,inhGroup,numberLayout,workersLayout};

        for(Group g : groups){
            Button backToMain = new Button("Back to main");
            backToMain.setOnAction(e -> primaryStage.setScene(mainScene));
            backToMain.setTranslateX(540);
            backToMain.setTranslateY(10);
            g.getChildren().add(backToMain);
        }

        //Main scene for app
        Group mainGroup = new Group(buttons.getBookTitles());
        mainScene = new Scene(mainGroup);

        primaryStage.setTitle("Politech Java Labs");
        primaryStage.setScene(mainScene);
        primaryStage.setHeight(441);
        primaryStage.setWidth(658);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        try {

            launch(args);

            System.out.println("Chose number of task from 1 to 3: ");
            Scanner in = new Scanner(System.in);
            int choseTask = in.nextInt();

            if (choseTask < 1 || choseTask > 3) {
                throw new IndexOutOfBoundsException("Index out of bounds from 1 to 3");
            }

            switch (choseTask) {
                case 3: {
                    ActionsForThreads actions = new ActionsForThreads(5);
                    WritingThread write = new WritingThread(actions);
                    GetNumberFromThread read = new GetNumberFromThread(actions);
                    new Thread(write).start();
                    new Thread(read).start();
                    break;
                }
                case 4: {

                }
                default: {
                    System.out.println("You chose incorrect task!");
                }
            }
        } catch (NumberFormatException notInteger) {
            System.out.println("Your input is not integer!");

        }
    }
}
