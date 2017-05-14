package tennis.ViewSwing;

import tennis.Modal.Modal;
import tennis.Controller.TennisController;
import tennis.include.Colors;
import tennis.include.MyDims;
import tennis.include.Strings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;


public class View implements Observer, ActionListener {

    private Modal modal;
    private TennisController controller;

    private ArrayList<JLabel> currentScores, previousSets;
    private JLabel playerOneLabel, playerTwoLabel;
    private JButton addPointOne, addPointTwo;

    private NamesPanel names;
    private PreviousSetsPanel prevSets;
    private CurrentScorePanel currentGame;
    private buttonsPanel controls;

    public static final int PREV_SETS = 4; // Number of previous sets to create.
    private static final int CURR_LABELS = 6; // Number of Labels required for current points section

    public View(TennisController controller, Modal modal) {
        this.controller = controller;
        controller.setView(this);

        currentScores = createJLabels(CURR_LABELS); // 6 Labels to hold current scores
        previousSets = createJLabels(PREV_SETS*2); // 8 Labels to hold previous sets

        addPointOne = new JButton();
        addPointTwo = new JButton();

        this.modal = modal;
        modal.addObserver(this);
        playerOneLabel = new JLabel(modal.getMatch().getPlayerOne().getName());
        playerTwoLabel = new JLabel(modal.getMatch().getPlayerTwo().getName());
        createFrame();
    }

    /**
     * Helper method to create new JLabels.
     * @return ArrayList<JLabel> An arraylist of JLabels
     * */
    private ArrayList<JLabel> createJLabels(int amount) {
        ArrayList<JLabel> temp = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            temp.add(new JLabel());
        }
        return temp;
    }


    /**
     * Creates the overall frame for the tennis scoreboard
     * @post The main widow frame is created and displayed to the user
     * */
    private void createFrame() {
        JFrame frame = new JFrame(Strings.TITLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(MyDims.FRAME_WIDTH, MyDims.FRAME_HEIGHT));
        Container mainFrame = frame.getContentPane();

        mainFrame.setLayout(new GridLayout(1,4));
        mainFrame.setBackground(Colors.GREEN);

        // Previous Sets
        prevSets = new PreviousSetsPanel(previousSets);
        mainFrame.add(prevSets.getView());

        // Name Vs Name
        names = new NamesPanel(playerOneLabel, playerTwoLabel);
        mainFrame.add(names.getView());

        // Match Match Scores
        currentGame = new CurrentScorePanel(currentScores);
        mainFrame.add(currentGame.getView());

        // Win Point
        controls = new buttonsPanel(addPointOne, addPointTwo);
        mainFrame.add(controls.getView());

        // Add Action Listeners
        addPointOne.addActionListener(this);
        addPointTwo.addActionListener(this);

        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Listens for clicks on the win point buttons.
     * On click it will send a request to the controller to update the modal.
     * @post The controller is notified of an update for a specific player.
     * */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addPointOne) {
            controller.addPoint(playerOneLabel.getText());
        } else if (e.getSource() == addPointTwo) {
            controller.addPoint(playerTwoLabel.getText());
        }
    }

    /**
     * Listens for updates form the modal.
     * On update it will call methods to update the view.
     * */
    @Override
    public void update(Observable obs, Object obj) {
        updateCurrentPoints();
        if (modal.getWinner() == null) {
            updatePreviousSets();
        }
    }

    /**
     * This will pass the index of the start of the players 3 JLabels (Games, Sets, Points).
     * It will then give that index and the player name to updateLabels().
     * @post The Current set will be updated.
     * */
    private void updateCurrentPoints() {
        int playerOneStartLabel = 0;
        int playerTwoStartLabel = 3;
        updateLabels(playerOneStartLabel, playerOneLabel.getText()); // Update Player one Current points
        updateLabels(playerTwoStartLabel, playerTwoLabel.getText()); // Update Player two Current points
    }

    /**
     * Given an index and a player name.
     * The ViewSwing will query the Modal to update each players scores (Games, Sets, Points).
     * @post The Current set will be updated.
     * */
    private void updateLabels(int i, String playerName) {
        currentScores.get(i).setText(modal.getSets(playerName));
        currentScores.get(i+1).setText(modal.getGames(playerName));
        currentScores.get(i+2).setText(modal.getPoints(playerName));
    }

    /**
     * This will update the previous sets section of the View
     * @post The previous sets will be updated.
     * */
    private void updatePreviousSets() {
        ArrayList<HashMap<String, String>> prevSets = modal.getPreviousSets();
        for (int i = 0; i < prevSets.size(); i++) {
            previousSets.get(i).setText(prevSets.get(i).get(playerOneLabel.getText() ));
            previousSets.get(i+View.PREV_SETS).setText(prevSets.get(i).get(playerTwoLabel.getText() ));
        }
    }

    /**
     * This will disable the buttons on the GUI.
     * This will also set the colour of the buttons text to grey.
     * @post the buttons of the view will be disabled
     * */
    public void disableButtons() {
        addPointOne.setEnabled(false);
        addPointTwo.setEnabled(false);
    }

    /**
     * Fires the disable method from the Shared class all panes extend from.
     * @post Yellow text is turned to grey.
     * */
    public void changeFontColour() {
        currentGame.disable();
        prevSets.disable();
        names.disable();
        controls.disable();
    }

    /**
     * Highlights the winner by changing there text colour back to yellow.
     * @post The name of the winner will be set to yellow.
     * */
    public void setWinner(String winner) {
        if (winner.equals(playerOneLabel.getText())) {
            playerOneLabel.setForeground(Colors.YELLOW);
        } else {
            playerTwoLabel.setForeground(Colors.YELLOW);
        }
    }
}

