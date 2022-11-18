package Game2048;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static Game2048.Main.HEIGHT;
import static Game2048.Main.WIDTH;

/**
 * Controller for menu.fxml.
 */
public class MenuController extends Record{
    private Stage primaryStage;
    private Scene scene;
    private Parent root;
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
    public void switchToGame(ActionEvent event) throws IOException {
        root = gameRoot;
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = gameScene;
        primaryStage.setScene(scene);
        primaryStage.show();
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));
        GameScene game = new GameScene();
        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);
    }

    /**
     * When the change background color button is clicked,
     * pop up a choice dialog window and choose the color to change.
     * @param e
     */
    public void changecolor(ActionEvent e){
        String color[] = { "Green", "Pink", "Blue",
                "Whitesmoke", "violet", "Default" };
        ChoiceDialog c = new ChoiceDialog(color[5], color);
        c.setHeaderText("Choose the background color");
        c.setContentText("please select the color");
        c.showAndWait();
        if (c.getSelectedItem()=="Green"){
            gameScene.setFill(Color.GREEN);
        } else if (c.getSelectedItem()=="Pink") {
            gameScene.setFill(Color.PINK);
        } else if (c.getSelectedItem()=="Blue") {
            gameScene.setFill(Color.LIGHTBLUE);
        } else if (c.getSelectedItem()=="Whitesmoke") {
            gameScene.setFill(Color.WHITESMOKE);
        } else if (c.getSelectedItem()=="violet") {
            gameScene.setFill(Color.VIOLET);
        }else {
            gameScene.setFill(Color.rgb(189, 177, 92));
        }
    }

    /**
     * When Rule button is clicked, pop up a window to show the game rule.
     * @param help
     */
    public void help (ActionEvent help){
        Stage showrule = new Stage();
        showrule.initModality(Modality.APPLICATION_MODAL);
        showrule.setTitle("Rule: ");
        Label rule = new Label("By clicking the up, down, left, right buttons\n in keyboard to merge the cells \nwith same number to get scores.");
        rule.setFont(Font.font(12));
        Button button1 = new Button("Close");
        button1.setOnAction(e -> showrule.close());
        VBox layout= new VBox(20);
        layout.getChildren().addAll(rule, button1);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout, 240, 160);
        showrule.setScene(scene1);
        showrule.showAndWait();
    }

    /**
     * Show the highest score and record keeper.
     * @param event
     * @throws IOException
     */
    public void ShowRecord(ActionEvent event) throws IOException{
        Stage showscore = new Stage();
        showscore.initModality(Modality.APPLICATION_MODAL);
        showscore.setTitle("Record");
        Label finalscore = new Label("Record Keeper: "+getHighscorename()+"\n\nRecord Score: "+getHighscore());
        finalscore.setFont(Font.font(20));
        Button button1 = new Button("Close");
        button1.setOnAction(e -> showscore.close());
        VBox layout= new VBox(20);
        layout.getChildren().addAll(finalscore, button1);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout, 300, 250);
        showscore.setScene(scene1);
        showscore.showAndWait();
    }
    /**
     * When quit button is clicked,
     * exit the game.
     * @param quit
     */
    public void quit(ActionEvent quit){
        System.exit(0);
    }

}

