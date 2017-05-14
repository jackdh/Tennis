package tennis;

import tennis.Modal.Match;
import tennis.Modal.Modal;
import tennis.Modal.Player;

import java.util.HashMap;

/**
 * Method to be able to print out a score board to the console.
 */
public class CmdScoreboard {

    public static String getPointsScore(Modal modal) {
        Match match = modal.getMatch();
        Player playerOne = match.getPlayerOne();
        Player playerTwo = match.getPlayerTwo();
        String p1p = modal.getPoints(playerOne.getName());
        String p2p = modal.getPoints(playerTwo.getName());
        String p1g = playerOne.getGames() +"";
        String p2g = playerTwo.getGames() +"";


        String p1 = playerOne.getName();
        String p2 = playerTwo.getName();

        String lineOne = "Previous Sets   name    Sets    Games   Points\n";
        String lineTwo = getPreviousSets(match, p1)+":  "+ p1 +":   "+ playerOne.getSets()+":   "+p1g+":      "+p1p+"\n";
        String lineThree = getPreviousSets(match, p2)+":  "+ p2 +":    "+ playerTwo.getSets()+":   "+p2g+":      "+p2p+"\n";
        return (lineOne+lineTwo+lineThree);
    }

    private static String getPreviousSets(Match match, String player) {
        String etc = "";
        for (HashMap<String, String> map : match.previousSets) {
            etc = etc + map.get(player) + "  ";
        }
        while (etc.length() < 13) {
            etc += " ";
        }
        return etc;
    }

}
