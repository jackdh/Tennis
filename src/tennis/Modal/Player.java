/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis.Modal;

/**
 * This Class represents a line on the score board.
 * Hence it will only hold the information for that one player.
 * @Author Jack Dalrymple Hamilton 12023277
 */
public class Player implements Score{
    private int sets;
    private int games;
    private int points;

    private String name;
    private Boolean won;

    /**
     * Class constructor
     * @post Sets the points, games and sets to 0.
     * @post sets the name
     * */
    public Player(String name) {
        this.sets = 0;
        this.games = 0;
        this.points = 0;
        this.name = name;
    }

    /**
     * @return The name of the player
     * */
    public String getName() {
        return name;
    }
    /**
     * @param string Sets the players name.
     * */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Sets the winning player so they can be found after the match has finished.
     * @param boolean if this is the winning player.
     * */
    public void setWinner(boolean winner) {
        this.won = winner;
    }

    @Override
    public int getSets() {
        return sets;
    }

    @Override
    public void setSets(int sets) {
        this.sets = sets;
    }

    @Override
    public void incrementSet() {
        this.sets++;
    }

    @Override
    public int getGames() {
        return games;
    }

    @Override
    public void setGames(int games) {
        this.games = games;
    }

    @Override
    public void incrementGame() {
        this.games++;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public void incrementPoint() {
        this.points++;
    }


}
