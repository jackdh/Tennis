package tennis.ViewJavaFX;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import tennis.include.MyDims;
import tennis.include.Strings;

/**
 * Creates the BorderPane which will show the buttons to add a point to each player
 * */
public class PreviousSetsPane extends Shared {
    private BorderPane pane;

    public PreviousSetsPane() {
        pane = new BorderPane();

        pane.setTop(getHBox(Strings.PREVIOUS_SETS, MyDims.WIDTH_FX));
        pane.setCenter(getCenter());
        pane.setBottom(getHBox());
    }

    /**
     * Creates the center pane which holds the previous sets. The double loop creates 8 total labels.
     * 4 for player one and 4 for player two. It works out the template position from the number created.
     * IE the first label is (0,0) second (0,1),(0,2),(0,3) & (1,0) etc. It will also add them to
     * the label set so that they can be disabled once the match has finished.
     * @return GridPane With 8 labels to hold the previous set.
     * */
    private GridPane getCenter() {
        GridPane previousSetsPane = new GridPane();
        Label tempLabel;
        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 4; b++) {
                tempLabel = new MyLabel("", MyDims.COLUMN_FOUR);
                addLabel(tempLabel);
                previousSetsPane.add(tempLabel, b, a);
            }
        }
        return previousSetsPane;
    }

    /**
     * Returns the BorderPane containing previous sets.
     * */
    public BorderPane getPane() {
        return pane;
    }

}
