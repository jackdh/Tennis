package tennis.Controller;

import tennis.Modal.Modal;
import tennis.ViewJavaFX.FXView;
import tennis.ViewSwing.View;


public class TennisController {
    private Modal modal;
    private View view;
    private FXView FXView;
    private  String viewType = ""; // The type of view. Swing or FX.

    public TennisController(Modal modal) {
        this.modal = modal;
    }

    public void setView(View view) {
        this.view = view;
        this.viewType = "Swing";
    }

    public void setView(FXView view) {
        this.FXView = view;
        this.viewType = "FX";
    }

    public void addPoint(String playerOne) {
        // If the match is not finished.
        modal.addPoint(playerOne);

        if (modal.matchFinished()) {
            if (viewType.equals("Swing")) {
                // The match has finished
                // Disable Buttons
                view.disableButtons();
                // Set the Yellow Text To Grey
                view.changeFontColour();
                // Set the Winner to Yellow
                view.setWinner(modal.getWinner());
            } else {
                // The match has finished
                // Set the Yellow Text To Grey and disable the buttons
                FXView.finish();
                // Set the Winner to Yellow
                FXView.setWinner(modal.getWinner());
            }

        }



    }

}
