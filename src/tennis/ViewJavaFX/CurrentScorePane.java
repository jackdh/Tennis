package tennis.ViewJavaFX;


import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import tennis.include.MyDims;
import tennis.include.Strings;

/**
 * Created the BorderPane which will show the current sets score
 * */
public class CurrentScorePane extends Shared {
    private BorderPane pane;

    public CurrentScorePane() {
        pane = new BorderPane();
        pane.setTop( getTop() );
        pane.setCenter( getCenter() );
        pane.setBottom( getHBox() );
    }

    /**
     * Creates the center part of the BorderPane. This section shows the exact points
     *  each player has this set as well as the number of won sets.
     *  @return GridPane A Gridpane with 6 labels for Sets, Games & Points for each player.
     * */
    private GridPane getCenter() {
        Label tempLabel;
        GridPane currentSet = new GridPane();
        int columns;
        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 3; b++) {
                columns =  ( b == 2 ) ? MyDims.COLUMN_TWO : MyDims.COLUMN_FOUR;
                tempLabel = new MyLabel("0", columns);
                addLabel(tempLabel);
                currentSet.add(tempLabel, b, a);
            }
        }
        return currentSet;
    }

    /**
     * Returns the top section of the BorderPane
     * @return A GridPane holding 3 labels, Sets, Games & Points.
     * */
    private GridPane getTop() {
        GridPane setGamesLabel = new GridPane();
        setGamesLabel.add(getHBox(Strings.SETS, MyDims.WIDTH_FX_QUARTER), 0,0);
        setGamesLabel.add(getHBox(Strings.GAMES, MyDims.WIDTH_FX_QUARTER), 1,0);
        setGamesLabel.add(getHBox(Strings.POINTS, MyDims.WIDTH_FX_HALF), 2,0);

        return setGamesLabel;
    }

    /**
     * @return GridPane holding the view.
     * */
    public BorderPane getPane() {
        return pane;
    }


}
