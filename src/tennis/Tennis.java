package tennis;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import tennis.Controller.TennisController;
import tennis.Modal.Modal;
import tennis.ViewJavaFX.FXView;
import tennis.ViewSwing.View;

/**
 * Contains the main method for the application.
 * @Author Jack Dalrymple Hamilton 12023277
 */
public class Tennis {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String murrey = "A. Murray";
        String nadal = "R. Nadal";

        Modal modal = new Modal(murrey, nadal);
        TennisController controller = new TennisController(modal);
        View view = new View(controller, modal);

    }



}
