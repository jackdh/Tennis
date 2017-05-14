package tennis.ViewSwing;

import tennis.include.Colors;
import tennis.include.Fonts;
import tennis.include.Strings;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Creates the panel which holds the Previous sets.
 * */
public class PreviousSetsPanel extends SharedView {
    private JPanel main;
    private ArrayList<JLabel> previousSets;

    /**
     * @param previousSets A list of JLabels which will be added to the center section
     * */
    public PreviousSetsPanel(ArrayList<JLabel> previousSets) {
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        main.setBackground(Colors.GREEN);
        this.previousSets = previousSets;

        main.add(previousSets(), BorderLayout.CENTER);
        main.add(previousSetsTitle(), BorderLayout.NORTH);
        main.add(getBorderLayoutTopBottom(), BorderLayout.SOUTH);
        main.add(leftMargin(), BorderLayout.WEST);

        this.main = main;
    }

    /**
     * Returns the view
     * */
    public JPanel getView() {
        return main;
    }

    /**
     * Creates the left spacer margin to the left of previous sets.
     * @return JPanel A spacing JPanel
     * */
    private JPanel leftMargin() {
        JPanel panel = new JPanel();
        panel.setBackground(Colors.GREEN);
        return panel;
    }

    /**
     * Creates a JPanel with the "PREVIOUS SETS" text
     * @return JPanel a JPanel holding "PREVIOUS SETS"
     * */
    private JPanel previousSetsTitle() {
        JPanel wrap = titlePanelWrap();

        wrap.add(formatTitleLabel(Strings.PREVIOUS_SETS, Fonts.TITLE_SIZE, Colors.GREEN), BorderLayout.CENTER);
        wrap.add(leftMargin(), BorderLayout.WEST);
        return wrap;
    }

    /**
     * Creates the previous sets Labels.
     * @return JPanel The central Labels.
     * */
    private JPanel previousSets() {
        JPanel panel = getGridLayout(2,View.PREV_SETS);
        JPanel temp;
        for (JLabel previousSet : previousSets) {
            temp = formatLabel("", Fonts.POINT_SIZE, Color.BLACK, previousSet);
            temp.setBorder(BorderFactory.createLineBorder(Colors.GREEN));
            panel.add(temp);
        }

        return panel;
    }

}
