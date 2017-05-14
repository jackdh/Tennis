package tennis.ViewJavaFX;


import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import tennis.include.Colors;
import tennis.include.MyDims;

import java.util.ArrayList;

/**
 * A Shared class which is extended by each pane. This Class contains helper methods to format
 * text as well as design Nodes.
 * */
public class Shared {
    // Holds all the labels within a class.
    private ArrayList<Label> labels =  new ArrayList<>();

    // Holds all the title labels, Previous Sets, Sets, Games, Points
    private ArrayList<Label> titleLabels =  new ArrayList<>();

    /**
     * This will loop through all labels in a BorderPane and make them all grey.
     * It will also add the title labels to it.
     * @post All Labels will have gray text.
     * */
    public void disable() {
        ArrayList<Label> allLabels = new ArrayList<>(labels);
        allLabels.addAll(titleLabels);
        for (Label label : allLabels) {
            label.setTextFill(Color.web(Colors.GRAY_HEX));
        }
    }

    /**
     * Used to add any created labels to the labels.
     * @param labels Can take any number of labels at once and add them all to the ArrayList.
     * */
    public void addLabel(Label ... labels) {
        for (Label l : labels) {
            this.labels.add(l);
        }
    }

    /**
     * Returns all the labels in the BorderPane.
     * */
    public ArrayList<Label> getLabelsShared() {
        return labels;
    }

    /**
     * @param label The label to have a green background applied.
     * @post A green background is applied to the node.
     * */
    public void addGreenBackground(Node label) {
        addBackGround(label, Colors.GREEN_HEX);
    }

    /**
     * @param label The label to have a black background applied.
     * @post A black background is applied to the node.
     * */
    public void addBlackBackground(Node label) {
        addBackGround(label, Colors.BLACK_HEX);
    }

    /**
     * @param label The label to have a background applied.
     * @param colour A Hexidecimal colour
     * @post A background with required colour is applied to the node.
     * */
    private void addBackGround(Node label, String colour) {
        String greenBackGround = "-fx-padding: 0 0 0 0; -fx-background-color:" + colour +"; -fx-opacity: 1;";
        label.setStyle(label.getStyle()+greenBackGround);
    }

    /**
     * @param label The label to have a yellow text applied to
     * @post The label will have yellow text applied to it.
     * */
    public void setTextColorYellow(Label label) {
        label.setTextFill(Color.web(Colors.YELLOW_HEX));
    }

    /**
     * The button to have a gray text applied to
     * @post The button will have gray text applied to it.
     * */
    public void setTextColorGray(Button button) {
        button.setTextFill(Color.web(Colors.GRAY_HEX));
    }

    /**
     * Used for name panes. IE: A. Murray
     * @return HBox creates a new HBox with standard column width.
     * */
    public HBox getHBox() {
        return getHBox(MyDims.WIDTH_FX);
    }

    /**
     *@param width The width of the box in PX
     * @return HBox creates a new HBox with custom column width.
     * */
    public HBox getHBox(int width) {
        return getHBox(width, MyDims.HEIGHT);
    }
    /**
     * Create the main HBox with required width and height.
     * @param height A Integer of pixel height
     * @param width The width of the box in PX
     * @return HBox creates a new HBox with standard column width & Height.
     * */
    public HBox getHBox(int width, int height) {
        HBox temp = new HBox();
        temp.setPrefHeight(height);
        temp.setPrefWidth(width);
        addGreenBackground(temp);
        return temp;
    }

    /**
     * Used for create label boxes. IE: Sets, Games, Points
     * @param text The text to be displayed in the HBox
     * @param width The width of the box in PX
     * @return HBox creates a new HBox with supplied Text and width.
     * */
    public HBox getHBox(String text, int width) {
        HBox hBox = getHBox(width);
        Label label = new Label(text);
        setTextColorYellow(label);
        hBox.getChildren().addAll(label);
        hBox.setAlignment(Pos.BOTTOM_LEFT);
        titleLabels.add(label);
        return hBox;
    }

}
