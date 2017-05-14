package tennis.Modal;

/**
 * Score is an interface to be implemented by a player. It provides access to scores items as well as
 * setting / incrementing them.
 * @Author Jack Dalrymple Hamilton 12023277
 */
public interface Score {
    /**
     * Holds a score for a player
     * */


    /**
     * @return int The number of sets
     * */
    int getSets();

    /**
     * @param sets Set the number of sets
     * */
    void setSets(int sets);

    /**
     * @post. Increase the amount of sets by 1
     * */
    void incrementSet();

    /**
     * @return int The number of games
     * */
    int getGames();

    /**
     * @param games Set the number of games
     * */
    void setGames(int games);

    /**
     * @post. Increase the amount of games by 1
     * */
    void incrementGame();

    /**
     * @return int The number of points
     * */
    int getPoints();

    /**
     * @param points Set the number of points
     * */
    void setPoints(int points);

    /**
     * @post. Increase the amount of points by 1
     * */
    void incrementPoint();


}
