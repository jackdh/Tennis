package tennis.ViewJavaFX;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import tennis.include.Colors;
import tennis.include.MyDims;
import tennis.include.Strings;

/**
 * Creates the pane holding the Playernames. IE: A. Murray vs R. Nadal
 * */
public class NamesPane extends Shared {
    private BorderPane bPane;
    private Label playerOneLabel;
    private Label playerTwoLabel;

    /**
     * Creates the panes and applies them to the correct position within the border pane.
     * @param playerOne The name of the first player
     * @param playerTwo The name of the second player
     * */
    public NamesPane(String playerOne, String playerTwo) {
        bPane = new BorderPane();
        GridPane center = getCenter(playerOne, playerTwo);

        bPane.setTop(getHBox());
        bPane.setCenter(center);
        bPane.setBottom(getHBox());
    }

    /**
     * Creates the name section of the GUI. It will create three labels one for each player
     * and one for the "VS.". It will then added them to a GridPane in the right section.
     * @param playerOne The name of the first player
     * @param playerTwo The name of the second player
     * @return GridPane The Central grid pane showing player one vs player two.
     * */
    private GridPane getCenter(String playerOne, String playerTwo) {
        GridPane center = new GridPane();
        // Create the labels
        playerOneLabel = new MyLabel(playerOne, MyDims.COLUMN_ONE);
        MyLabel vs = new MyLabel(Strings.VS, MyDims.COLUMN_ONE);
        playerTwoLabel = new MyLabel(playerTwo, MyDims.COLUMN_ONE);

        String greenBackGround = Colors.GREEN_BORDER;

        // Set the heights of the labels.
        playerOneLabel.setPrefHeight(MyDims.HEIGHT);
        vs.setPrefHeight(MyDims.HEIGHT);
        playerTwoLabel.setPrefHeight(MyDims.HEIGHT);

        // Add the labels to Shared label array list.
        addLabel(playerOneLabel, playerTwoLabel, vs);

        // Add the panes to the gridpane
        center.add(playerOneLabel, 0 , 1);
        center.add(vs, 0 , 2);
        center.add(playerTwoLabel, 0 , 3);

        // Style the central area.
        center.setStyle(Colors.GREEN_BORDER);
        addBlackBackground(center);
        return center;
    }

    /**
     * @return BorderPane central border pane showing Player One vs Player Two
     * */
    public BorderPane getPane() {
        return bPane;
    }

    /**
     * @post Player one's label is set to yellow
     * */
    public void setPlayerOneWinner() {
        setTextColorYellow(playerOneLabel);
    }

    /**
     * @post Player two's label is set to yellow
     * */
    public void setPlayerTwoWinner() {
        setTextColorYellow(playerTwoLabel);
    }
}
