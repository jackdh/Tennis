package tennis.Modal;

/**
 * Implemented by the Match Class. Provides method for defining how a Tennis game is won.
 * @Author Jack Dalrymple Hamilton 12023277
 */
public interface Rules {
    /**
     *  Checks if the winner has won the game.
     *  @param winner Object of the player who won he point.
     *  @return boolean True if the player has won the game. False if not.
     * */
    Boolean wonGame(Player winner);

    /**
     * Checks if the player has won a set
     * @param winner The player to check if they have won the set.
     * @return boolean True if the player has won the set. False if not.
     * */
    Boolean wonSet(Player winner);

    /**
     * Checks if the player has won a match.
     * @param winner The player object to check if they have won the match.
     * @return boolean True if the player has won the match. False if not.
     * */
    Boolean wonMatch(Player winner);

    /**
     * Returns true or false if the match is over.
     * @return True if the match is finished, False if not.
     * */
    Boolean isWinner();

}
