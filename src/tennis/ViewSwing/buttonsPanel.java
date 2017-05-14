package tennis.ViewSwing;


import tennis.include.Colors;
import tennis.include.Fonts;
import tennis.include.Strings;

import javax.swing.*;
import java.awt.*;


/**
 * Created the BorderPane which will show the buttons to add a point to each player
 * */
public class buttonsPanel extends SharedView  {
    private JPanel view;

    /**
     * @param addPointOne The button to add a point to player one.
     * @param addPointTwo The button to add a point to player two.
     * */
    public buttonsPanel(JButton addPointOne, JButton addPointTwo) {
        JPanel main = getGridLayout(2,1);
        main.add(createWinButton(addPointOne));
        main.add(createWinButton(addPointTwo));
        view = main;
    }
    /**
     * Returns the panel containing buttons to add points.
     * @return JPanel The panel containing the full view containing the buttons to add points.
     * */
    public JPanel getView() {
        return view;
    }

    /**
     * Given a fresh JButton it will be styled correctly to be placed in the Add Point section.
     * @param button a Fresh JB button.
     * @return JButton Returns a formatted win button.
     * */
    private JButton createWinButton(JButton button) {
        button.setText(Strings.WIN_POINT);

        button.setFont(new Font(Fonts.FONT_STYLE, Font.PLAIN, Fonts.BUTTON_SIZE));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBackground(Colors.GREEN);
        button.setForeground(Colors.YELLOW);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        return button;
    }

}
