package tennis.ViewJavaFX;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import tennis.include.Colors;
import tennis.include.Fonts;
import tennis.include.MyDims;

/**
 * Decorator pattern. Extending the Label to add extra behaviour on create of the class.
 * */
public class MyLabel extends Label {

    public MyLabel(String var1) {
        super(var1);
    }

    /**
     * Creates a label with the supplied column width.
     * @param columns The number of columns to span
     * @param text The text of the label
     * @post A Label is created with the custom width.
     * */
    public MyLabel(String text, int columns) {
        super(text);
        setStyleCurrentSet(columns);
    }

    /**
     * Builds the style for the label. If the width is 1 (Meaning 1 column) it will give it a smaller text as well as
     * not giving it a green border.
     * @param width The number of columns to span.
     * @post Label is created with required width and text size.
     * */
    public void setStyleCurrentSet(int width) {
        String style = "-fx-font-size: ";
        style += (width==1) ? Fonts.NAME_SIZE + "px;": Fonts.POINT_SIZE + "px;" + Colors.GREEN_BORDER;
        this.setStyle(style);
        addBlackBackGround(this);

        this.setTextFill(Color.web(Colors.YELLOW_HEX));
        this.setPrefWidth((MyDims.WIDTH_FX) / width);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * Adds a black background to labels (Middle section labels).
     * @param node The node to change the background of.
     * @post the Label has a black background with a 4 px margin to highlight each label.
     * */
    public void addBlackBackGround(Node node) {
        String greenBackGround = "-fx-padding: 0 4px 0 4px;"+ Colors.BLACK_BORDER;
        node.setStyle(node.getStyle()+greenBackGround);
    }


}
