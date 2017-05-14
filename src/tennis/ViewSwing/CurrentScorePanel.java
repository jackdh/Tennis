package tennis.ViewSwing;


import tennis.include.Colors;
import tennis.include.Fonts;
import tennis.include.Strings;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CurrentScorePanel extends SharedView {
    private JPanel view;
    private ArrayList<JLabel> list;

    // THe current point section is limited to 6 labels. 3 for (Sets, Games & Points) * 2 = 6
    private int p1Points = 2; // Index of label which relates to Points for player one.
    private int p2Points = 5; // Index of label which relates to Points for player one.


    public CurrentScorePanel(ArrayList<JLabel> currentScore) {
        this.list = currentScore;
        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(Colors.GREEN);

        main.add(setMatchLabels(), BorderLayout.NORTH);
        main.add(theCurrentScore(), BorderLayout.CENTER);
        main.add(getBorderLayoutTopBottom(), BorderLayout.SOUTH);

        this.view = main;
    }

    /**
     * Creates the middle part of the scores section.
     * @return JPanel The label section of the current set score.
     * */
    private JPanel theCurrentScore() {
        JPanel main = getGridLayout(1,2);
        main.add(setsAndGames());
        main.add(points());
        return main;
    }

    /**
     * Create the Blank Panels with 0's.
     * This will create the panels for the Sets and Games only.
     * It skips index 2 and 5 as these are the Points panels.
     * @return a JPanel holding 4 other JPanels for sets and games.
     * */
    private JPanel setsAndGames() {
        JPanel panel = getGridLayout(2,2);
        for (int i = 0; i < list.size(); i++) {
            if (i != p1Points && i != p2Points) {
                panel.add(makePanel(i));
            }
        }
        return panel;
    }

    /**
     * Creates the panels for points. these require a different layout to the Sets and Games panels
     * @return JPanel a grid panel holding just two Jpanels.
     * */
    private JPanel points() {
        JPanel panel = getGridLayout(2,0);
        panel.add(makePanel(p1Points));
        panel.add(makePanel(p2Points));
        return panel;
    }

    /**
     * Creates a new Panel with a Label within it showing the points. These are formatted to the correct size
     * and background.
     * @param index the index of the label a panel is being formatted for
     * @return JPanel The single Jpanel formatted with the required label.
     * */
    private JPanel makePanel(int index) {
        JPanel panel = formatLabel(Strings.ZERO, Fonts.POINT_SIZE, Color.black, list.get(index));
        panel.setBorder(BorderFactory.createLineBorder(Colors.GREEN));
        return panel;
    }
    /**
     * Sets the labels: Sets, Games & Points
     * in the North section of the BorderLayout
     * @post Returns a Gridlayout JPanel with sets, games points labels.
     * */
    private JPanel setMatchLabels() {
        JPanel wrap = titlePanelWrap();

        JPanel main = getGridLayout(1,2);
        JPanel setsGames = getGridLayout(1,2);
        JPanel points = getGridLayout(1,1);

        setsGames.add(formatTitleLabel(Strings.SETS, Fonts.TITLE_SIZE, Colors.GREEN));
        setsGames.add(formatTitleLabel(Strings.GAMES, Fonts.TITLE_SIZE, Colors.GREEN));
        points.add(formatTitleLabel(Strings.POINTS, Fonts.TITLE_SIZE, Colors.GREEN));

        main.add(setsGames);
        main.add(points);

        wrap.add(main, BorderLayout.CENTER);
        return wrap;
    }

    /**
     * Returns the created view.
     * */
    public JPanel getView() {
        return view;
    }
}

