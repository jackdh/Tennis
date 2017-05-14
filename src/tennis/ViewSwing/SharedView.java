package tennis.ViewSwing;

import tennis.include.Colors;
import tennis.include.Fonts;
import tennis.include.MyDims;
import tennis.include.Strings;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class SharedView {
    private ArrayList<JLabel> labels = new ArrayList<>();

    /**
     * This will loop through all labels in a BorderPane and make them all grey.
     * It will also add the title labels to it.
     * @post All Labels will have gray text.
     * */
    public void disable() {
        for (JLabel label : labels) {
            label.setForeground(Colors.GRAY);
        }
    }

    /**
     * Due to the need to split the top section of Previous Sets and Sets, Points & Games into Two.
     * It requires a Border layout with the label in the bottom.
     * @return JPanel A JPanel with a BorderLayout
     * */
    public JPanel titlePanelWrap() {
        JPanel wrap = new JPanel(new BorderLayout());

        JPanel top = new JPanel();
        top.setPreferredSize(new Dimension(MyDims.WIDTH, MyDims.HEIGHT/2));
        top.setBackground(Colors.GREEN);
        wrap.add(top, BorderLayout.NORTH);
        return wrap;
    }

    /**
     * Used to create the labels for top sections
     * IE: Previous Sets, Sets, Games & Points
     * */
    public JPanel formatTitleLabel(String text, int size, Color color) {
        JPanel jPanel = formatLabel(new JLabel(text), size, color);
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPanel.setPreferredSize(new Dimension(MyDims.WIDTH, MyDims.HEIGHT/2));
        return jPanel;
    }

    /**
     * Used to create labels for Sets, Games & Points
     * */
    public JPanel formatLabel(String text, int size, Color color, JLabel label) {
        label.setText(text);
        return formatLabel(label, size, color);
    }

    /**
     * Used to create the label for names.
     * ie: A. Murray, R. Nadal
     * */
    public JPanel formatLabel(JLabel label, int size, Color color) {
        JPanel main = new JPanel();
        main.setBackground(color);

        label.setFont(new Font(Fonts.FONT_STYLE, Font.PLAIN, size));
        label.setForeground(Colors.YELLOW);
        main.add(label);
        labels.add(label);
        return main;
    }


    /**
     * Used to create make the bottom section of BorderLayout.
     * It helps to keep it aligned.
     * @return JPanel A panel spaced correctly for above or below the BorderLayout
     * */
    public JPanel getBorderLayoutTopBottom() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(MyDims.WIDTH, MyDims.HEIGHT));
        panel.setBackground(Colors.GREEN);
        return panel;
    }

    /**
     * Creates a new Grid Layout with the specifed rows and columns as well as setting the background to grern.
     * @param rows The number of rows
     * @param cols The number of columns
     * */
    public JPanel getGridLayout(int rows, int cols) {
        JPanel panel = new JPanel(new GridLayout(rows, cols));
        panel.setBackground(Colors.GREEN);
        return panel;
    }
}
