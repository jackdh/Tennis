package tennis.ViewJavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tennis.Controller.TennisController;
import tennis.Modal.Modal;
import tennis.ViewSwing.View;
import tennis.include.MyDims;
import tennis.include.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * The main FX view.
 * */
public class FXView extends Application implements Observer {
    private TennisController controller;
    private Modal modal;

    private PreviousSetsPane previousSetsPane; // Holds the previous sets
    private NamesPane namesPane; // Holds the names pane
    private CurrentScorePane currentScorePane; // Holds the current score pane
    private buttonsPane buttonsPane; // Holds the add point pane

    private String playerOneName, playerTwoName; // Names of the two players.

    /**
     * Assigns the observer and controller.
     * @param controller The controller
     * @param modal The modal
     * */
    public FXView(TennisController controller, Modal modal) {
        this.controller = controller;
        this.modal = modal;
        controller.setView(this);
        modal.addObserver(this);
        playerOneName = modal.getMatch().getPlayerOne().getName();
        playerTwoName = modal.getMatch().getPlayerTwo().getName();

    }

    /**
     * FX start override. This will create the main frame split into four each with a individual BorderLayout within.
     * */
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();

        // Initialise the Panes.
        previousSetsPane = new PreviousSetsPane();
        namesPane = new NamesPane(playerOneName, playerTwoName);
        currentScorePane = new CurrentScorePane();
        buttonsPane = new buttonsPane();

        // Add the panes to the Frame in the correct position.
        root.add(previousSetsPane.getPane(),0,0);
        root.add(namesPane.getPane(),1,0);
        root.add(currentScorePane.getPane(),2,0);
        root.add(buttonsPane.getPane(), 3,0);

        // Create the Scene
        Scene scene = new Scene(root, MyDims.FRAME_WIDTH, MyDims.HEIGHT_FX);

        // Create Action Listener for Player one 'win point'
        buttonsPane.getPlayerOne().setOnAction((event) -> {
            controller.addPoint(playerOneName);
        });

        // Create Action Listener for Player two 'win point'
        buttonsPane.getPlayerTwo().setOnAction((event) -> {
            controller.addPoint(playerTwoName);
        });

        // Set the Title and launch the stage.
        primaryStage.setTitle(Strings.TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * Implementation of Observer interface.
     * @post The View will be updated by querying the modal.
     * */
    @Override
    public void update(Observable o, Object arg) {
        updateCurrentSetLabels(0, playerOneName);
        updateCurrentSetLabels(3, playerTwoName);
        if (modal.getWinner() == null) {
            updatePreviousSets();
        }
    }

    /**
     * Updates the current set labels. It will grab all the labels (6) and update them with the
     * right information from the modal. Due to there always being 6 labels 0 and 3 will be Sets for
     * the players, 1 & 4 are the Games, 2&5 are the points.
     * @param i the start index of a new players labels.
     * @param playerName The name of the player
     * @post The current set labels are updated with information pulled from the modal.
     * */
    private void updateCurrentSetLabels(int i, String playerName) {
        ArrayList<Label> currentSetLabels = currentScorePane.getLabelsShared();
        currentSetLabels.get(i).setText(modal.getSets(playerName));
        currentSetLabels.get(i+1).setText(modal.getGames(playerName));
        currentSetLabels.get(i+2).setText(modal.getPoints(playerName));
    }

    /**
     * Updates the previous set labels. It will grab all the labels (8) and update them with the
     * right information from the modal. Due to there always being 8 labels 0 and 4 will be Sets for
     * the players, 1 & 4 are the Games, 2&5 are the points.
     * @post The previous set labels are updated with information pulled from the modal.
     * */
    private void updatePreviousSets() {
        ArrayList<HashMap<String, String>> prevSets = modal.getPreviousSets();
        for (int i = 0; i < prevSets.size(); i++) {
            HashMap<String, String> map = prevSets.get(i);
            previousSetsPane.getLabelsShared().get(i).setText(map.get(playerOneName ));
            previousSetsPane.getLabelsShared().get(i+ View.PREV_SETS).setText(map.get(playerTwoName ));
        }
    }

    /**
     * Fires the disable method from the Shared class all panes extend from.
     * @post Yellow text is turned to grey.
     * */
    public void finish() {
        previousSetsPane.disable();
        namesPane.disable();
        currentScorePane.disable();
        buttonsPane.disable();
    }

    /**
     * Highlights the winner by changing there text colour back to yellow.
     * @post The name of the winner will be set to yellow.
     * */
    public void setWinner(String winner) {
        if (winner.equals(playerOneName)) {
            namesPane.setPlayerOneWinner();
        } else {
            namesPane.setPlayerTwoWinner();
        }
    }


}
