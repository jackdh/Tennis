package tennis.ViewJavaFX;


import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import tennis.include.Colors;
import tennis.include.MyDims;
import tennis.include.Strings;

/**
 * Creates the BorderPane which will show the buttons to add a point to each player
 * */
public class buttonsPane extends Shared {
    private GridPane pane;
    private Button playerOne, playerTwo;

    public buttonsPane() {
        pane = new GridPane();

        playerOne = buttonStyle(buttonLayout());
        playerTwo = buttonStyle(buttonLayout());

        pane.add(playerOne, 0,0);
        pane.add(playerTwo, 0,1);

    }

    /**
     * Styles the dimensions of the button.
     * @return Button with required height and width.
     * */
    public Button buttonLayout() {
        Button button = new Button(Strings.WIN_POINT);
        button.setPrefWidth(MyDims.WIDTH_FX);
        button.setMinHeight(MyDims.HEIGHT_FX/2);
        return button;
    }

    /**
     * Styles the look of the button.
     * @param button a Fresh Java FX Button
     * @return Button with required look (Color, Border).
     * */
    public Button buttonStyle(Button button) {
        button.setStyle("-fx-background-radius: 0 0 0 0;" +
                " -fx-border-color: white;" +
                "-fx-border-width: 1px 1px 1px 1px;");
        addGreenBackground(button);
        button.setTextFill(Color.web(Colors.YELLOW_HEX));
        button.setCursor(Cursor.HAND);
        return button;
    }

    /**
     * @return GridPane the Gridpane holding the buttons.
     * */
    public GridPane getPane() {
        return pane;
    }

    /**
     * Returns the playerOne button so an ActionListener can be placed on it.
     * */
    public Button getPlayerOne() {
        return playerOne;
    }

    /**
     * Returns the playerTwo button so an ActionListener can be placed on it.
     * */
    public Button getPlayerTwo() {
        return playerTwo;
    }

    /**
     * Overrides the disable method in Shared class.
     * This is due to the use different requirements of a button compared to a label.
     * */
    @Override
    public void disable() {
        disableButton(playerOne);
        disableButton(playerTwo);
    }

    /**
     * Disables a button by disabling the click, setting the background to green due to
     * default style changing the colour. It will then set the text to grey.
     * @param button A win point button.
     * @post Given button correctly styled and disabled.
     * */
    public void disableButton(Button button) {
        button.setDisable(true);
        addGreenBackground(button);
        setTextColorGray(button);
    }
}
