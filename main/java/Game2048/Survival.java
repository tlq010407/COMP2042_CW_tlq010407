package Game2048;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.util.Duration;


/**
 * This class is used to store the countdown timer for survival class.
 */
public class Survival{
    private final static int distanceBetweenCells = 20;
    public static int seconds = distanceBetweenCells;

    public static void doTime(Text text){
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seconds--;
                text.setText("CountDown: "+seconds);
                if (seconds<=0){
                    time.stop();
                }
            }
        });
        time.getKeyFrames().add(frame);
        time.playFromStart();
    }

}
