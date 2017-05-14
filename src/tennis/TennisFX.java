package tennis;

import javafx.application.Application;
import javafx.stage.Stage;
import tennis.Controller.TennisController;
import tennis.Modal.Modal;
import tennis.ViewJavaFX.FXView;

/**
 * Created by jack on 06/12/2016.
 */
public class TennisFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        String murrey = "A. Murray";
        String nadal = "R. Nadal";

        Modal modal = new Modal(murrey, nadal);
        TennisController controller = new TennisController(modal);
        FXView view = new FXView(controller, modal);

        view.start(stage);
    }
}
