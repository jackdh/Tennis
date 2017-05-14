package tennis.Modal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;


/**
 *  Modal respresents the state of the Tennis game. It provides method to add a point
 *  to a player. It also provides access to information for the view of the Tennis game.
 * @Author Jack Dalrymple Hamilton 12023277
 */
public class Modal extends Observable {
    public Match match;

    /**
     * Class constructor.
     *
     * @param playerOne Name of the first player.
     * @param playerTwo Name of the second player.
     * @post. Game state is created.
     * @post. Game is ready to play.
     * */
    public Modal(String playerOne, String playerTwo) {
        match = new Match(playerOne, playerTwo);
    }

    /**
     * Adds one point to the player matching that name. Notifies the Observers.
     *
     * @param name Should be the name of a player added on create of class.
     * @pre. Match should not be finished.
     * @post. One point is added to the player.
     *
     * */
    public void addPoint(String name) {
        /* Assert that the name is one of the two players names. */
        assert ( (match.getPlayerOne().getName().equals(name) || match.getPlayerTwo().getName().equals(name))) : "Name: " + name + " should be one of the two chosen players.";

        Player winner = match.getPlayer(name);
        if (!match.isWinner()) { // If the match is not finished.
            winner.incrementPoint();

            if (match.wonGame(winner)) { // Game Won.
                increaseGame(winner);
            }
            setChanged();
            notifyObservers();
        }
    }

    /**
     * Increments a Players game total by 1. Checks if the winner has enough games to win a set.
     *
     * @param winner The Player Object of winner of the game.
     * @pre. Player has enough points to win the game.
     * @post. Increment winners game total by 1.
     * */
    private void increaseGame(Player winner) {
        /* Assert that the this has only been called when the player has a win game condition */
        assert (match.wonGame(winner)) : "Winner must pass the game win condition";

        winner.incrementGame();
        if (match.wonSet(winner)) { // Set Won
            match.addToPreviousSet();
            increaseSet(winner);
        }

        match.resetPoints();

    }

    /**
     * Increases the amount of sets a player has.
     * @param winner Player Object of the winner which set is to be increased.
     * @post. Both players games are reset to 0.
     * @post. Winners Sets increased by one.
     * @post. If the player has wont he Match. Set him as the winner and set game to finished.
     *
     * */
    private void increaseSet(Player winner) {
        /* Assert that the this has only been called when the player has a win set condition */
        assert (match.wonSet(winner)) : "Winner must pass the set win condition";


        winner.incrementSet();
        if (match.wonMatch(winner)) {
            match.setWinner(winner);
        }
        if(!matchFinished()) {
            match.resetGames();
        }
    }

    /**
     * Returns the points of the player in human readable format.
     *@param name Name of the player to get the points String for.
     *@return String Conversation of point to human readable score
     * */
    public String getPoints(String name) {
        Player player = match.getPlayer(name);
        int pointsWinner = player.getPoints();
        int winnerOpponent = match.getOpponent(player).getPoints();
        /* Due to Duece points can keep rising indefinitely, But they should never be less than 0.*/
        assert(pointsWinner >=0 && winnerOpponent >=0 ) : "Players points should be above 0";

        String toBeReturned;
        if (match.isTieBreakGame()) {
            toBeReturned = Integer.toString(pointsWinner);
        } else {
            switch (pointsWinner) {
                case 0:
                    toBeReturned =  "0";
                    break;
                case 1:
                    toBeReturned =  "15";
                    break;
                case 2:
                    toBeReturned =  "30";
                    break;
                default:
                    if (pointsWinner == winnerOpponent) {
                        toBeReturned =  "D";
                    } else if (pointsWinner > winnerOpponent && winnerOpponent >  2) {
                        toBeReturned =  "A";
                    } else {
                        toBeReturned =  "40";
                    }
                    break;
            }
        }
        return toBeReturned;
    }

    /**
     * Returns the games a player has.
     * @param name Name of the player to get the games for.
     * @pre Number of points is an integer
     * @return
     * */
    public String getGames(String name) {
        return Integer.toString(match.getPlayer(name).getGames());
    }

    /**
     * Returns the sets a player has.
     * @param name Name of the player to get the sets for.
     * @pre. Number of points is an integer
     * */
    public String getSets(String name) {
        return Integer.toString(match.getPlayer(name).getSets());
    }

    /**
     * Returns previous sets.
     * Returns a list of sets stored in a hashmap so that they can be extracted by name.
     *
     * @return A HashMap in a Arraylist containing a keys of the winners name and Values of there Scores.
     * */
    public ArrayList<HashMap<String, String>> getPreviousSets() {
        return match.getPreviousSets();
    }

    /**
     * Used for printout of command line scoreboard.
     * Used for testing.
     * */
    public Match getMatch() {
        return match;
    }

    public String getWinner() {
        return match.getWinner();
    }

    public Boolean matchFinished() {
        return match.getWinner() != null;
    }
}




