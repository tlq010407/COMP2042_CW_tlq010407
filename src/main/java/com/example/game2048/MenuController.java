package com.example.game2048;

import com.example.game2048.Component.Buttons;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Optional;

import static com.example.game2048.Main.HEIGHT;
import static com.example.game2048.Main.WIDTH;
import static java.lang.System.exit;

/**
 * Controller for menu.fxml.
 */
public class MenuController extends RankScene {
    public static String Mode; //new parameter for mode control.
    private final Group gameRoot = new Group();
    private final Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
    public static Color color = Color.rgb(189, 177, 92);
    public static int cellNum;
    public final static int distanceBetweenCells = 10;
    public static double LENGTH = 0;

    /**
     * This function is used to switch the current scene to game scene.
     */
    public void switchToGame(ActionEvent event) {
        chooseMode();
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(gameScene);
        primaryStage.show();
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, color);
        GameScene game = new GameScene();
        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot, color);
    }

    /**
     * Choose the game mode.
     */
    public void chooseMode() {
        String[] mode = {"Classic", "Hard", "Own Mode", "Survival"};
        ChoiceDialog<? extends String> c = new ChoiceDialog<>(mode[0], mode);
        c.setHeaderText("Choose the Game Mode You Want");
        c.setContentText("please select the mode");
        c.showAndWait();
        double height = 700;
        if (c.getSelectedItem() == "Classic") {
            Mode = "Classic";
            cellNum = 4;
            LENGTH = (height - ((cellNum + 1) * distanceBetweenCells)) / (double) cellNum;
        } else if (c.getSelectedItem() == "Hard") {
            Mode = "Hard";
            cellNum = 4;
            LENGTH = (height - ((cellNum + 1) * distanceBetweenCells)) / (double) cellNum;
        } else if (c.getSelectedItem() == "Survival") {
            Mode = "Survival";
            cellNum = 4;
            LENGTH = (height - ((cellNum + 1) * distanceBetweenCells)) / (double) cellNum;
        } else if (c.getSelectedItem() == "Own Mode") {
            TextInputDialog num = new TextInputDialog();
            num.setTitle("Own Mode");
            num.setHeaderText("Enter the Number of Rows and Columns U Want:");
            num.showAndWait();
            cellNum = Integer.parseInt(num.getEditor().getText());
            LENGTH = (height - ((cellNum + 1) * distanceBetweenCells)) / (double) cellNum;
            Mode = "Own Mode";
        }
    }

    /**
     * When the change background color button is clicked,
     * pop up a choice dialog window and choose the color to change.
     */
    @FXML
    private Pane myPane;
    public void changecolor() {
        String[] colors = {"Green", "Pink", "Blue",
                "Whitesmoke", "violet", "Default"};
        ChoiceDialog<? extends String> c = new ChoiceDialog<>(colors[5], colors);
        c.setHeaderText("Choose the background color");
        c.setContentText("please select the color");
        c.showAndWait();
        if (c.getSelectedItem() == "Green") {
            color = Color.GREEN;
        } else if (c.getSelectedItem() == "Pink") {
            color = Color.PINK;
        } else if (c.getSelectedItem() == "Blue") {
            color = Color.LIGHTBLUE;
        } else if (c.getSelectedItem() == "Whitesmoke") {
            color = Color.WHITESMOKE;
        } else if (c.getSelectedItem() == "violet") {
            color = Color.VIOLET;
        } else {
            color = Color.rgb(189, 177, 92);
        }
        myPane.setBackground(new Background(new BackgroundFill(color, null, null))); //change the background color on menu.fxml.
    }

    /**
     * When Rule button is clicked, pop up a window to show the game rule.
     */
    public void help() {
        Stage showrule = new Stage();
        showrule.initModality(Modality.APPLICATION_MODAL);
        showrule.setTitle("Rule: ");
        Label rule = new Label("""
                Your Goal is to create 2048 tile by clicking the up, down, left, right buttons
                 in keyboard to merge the cells with same number to get scores.
                    
                For Classic Mode: You have no chance to undo your last move,\s
                     and only generate the random number between 2 and 4.
                    
                Fot Hard Mode: You have no chance to undo your last move,
                      and generate the random number among 2, 4, 8 and 16.
                                
                For 5*5 Mode: You will have 5*5 columns and rows in the game scene.
                                
                For 'Own' Mode: Enter The number of Columns and Rows You want to have Your special 2048 Game.
                    
                For Survival Mode: You have to gain as much scores as you can in limits time(20s).""");

        rule.setFont(Font.font(20));
        Button button1 = new Button("Close");
        button1.setOnAction(e -> showrule.close());
        VBox layout = new VBox(40);
        layout.getChildren().addAll(rule, button1);
        layout.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(layout, 900, 450, Color.PINK);
        showrule.setScene(scene1);
        showrule.showAndWait();
    }
    /**
     * Show the highest score and record keeper.
     */
    public void ShowRecord(ActionEvent event){
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Buttons.goRank(primaryStage);
    }
    /**
     * When quit button is clicked,
     * exit the game.
     */
    public void quit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit Dialog");
        alert.setHeaderText("Quit from this page");
        alert.setContentText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            exit(0);
        }
    }
}
