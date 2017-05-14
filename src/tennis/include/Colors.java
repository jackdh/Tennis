package tennis.include;

import java.awt.*;


public class Colors {

    public static final Color GREEN = new Color(50, 101, 0);
    public static final String GREEN_HEX = "#"+Integer.toHexString(GREEN.getRGB()).substring(2);
    public static final String GREEN_BORDER = "-fx-border-color: " + Colors.GREEN_HEX + ";";

    public static final Color YELLOW = new Color(254, 254, 0);
    public static final String YELLOW_HEX = "#"+Integer.toHexString(YELLOW.getRGB()).substring(2);

    public static final Color GRAY = Color.gray;
    public static final String GRAY_HEX = "#"+Integer.toHexString(Color.GRAY.getRGB()).substring(2);

    public static final String BLACK_HEX = "#"+Integer.toHexString(Color.BLACK.getRGB()).substring(2);
    public static final String BLACK_BORDER = "-fx-background-color:" + Colors.BLACK_HEX + ";";

}
