package tennis.ViewSwing;

import tennis.include.Colors;
import tennis.include.Fonts;
import tennis.include.Strings;

import javax.swing.*;
import java.awt.*;

public class NamesPanel extends SharedView {
    private JPanel view;

    /**
     * Generates the Jpanel which holds the Playername vs Playername in the middle.
     * It requires labels to be passed to it so the parent can modify the names (Such as change there colour).
     * @param playerOne Plain label with player one's name.
     * @param playerTwo Plain label with player two's name.
     *
     * */
    public NamesPanel(JLabel playerOne, JLabel playerTwo) {

        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(Colors.GREEN);

        JPanel panel = getGridLayout(3,0);
        panel.setBorder(BorderFactory.createLineBorder(Colors.GREEN));
        panel.setBackground(Colors.GREEN);

        panel.add(formatLabel(playerOne, Fonts.NAME_SIZE, Color.BLACK));
        panel.add(formatLabel(new JLabel(Strings.VS), Fonts.NAME_SIZE, Color.BLACK));
        panel.add(formatLabel(playerTwo, Fonts.NAME_SIZE, Color.BLACK));


        main.add(getBorderLayoutTopBottom(), BorderLayout.NORTH);
        main.add(panel, BorderLayout.CENTER);
        main.add(getBorderLayoutTopBottom(), BorderLayout.SOUTH);


        this.view = main;
    }

    /**
     * Return the view generated in the constructor.
     * */
    public JPanel getView() {
        return view;
    }

}
