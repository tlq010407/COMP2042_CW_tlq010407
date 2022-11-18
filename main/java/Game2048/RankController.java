package Game2048;

import java.awt.event.ActionEvent;

public class RankController extends Rank{
    public RankController(String userName) {
        super(userName);
    }

    public void showrank(ActionEvent event){
        combine(RankController.getUserName(),getScore());
    }

}
