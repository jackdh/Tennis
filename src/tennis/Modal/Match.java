    package tennis.Modal;

    import java.util.ArrayList;
    import java.util.HashMap;


    /**
     * Holds and controls information which relates to both players.
     * @Author Jack Dalrymple Hamilton 12023277
     */
    public class Match implements Rules {
        private Player playerOne;
        private Player playerTwo;
        private HashMap<String, String> oldSet;
        private String matchWinner;

        public ArrayList<HashMap<String, String>> previousSets;

        /**
         * Class constructor.
         *
         * @param playerOne Name of the first player.
         * @param playerTwo Name of the second player.
         * @post. Game state is created.
         * @post. Game is ready to play.
         * */
        public Match(String playerOne, String playerTwo) {
            /* Assert that both players are not null */
            assert (playerOne!=null && playerTwo!=null) : "Names should not be null";

            this.playerOne = new Player(playerOne);
            this.playerTwo = new Player(playerTwo);
            previousSets = new ArrayList<>();
        }

        /**
         * Resets the players points
         * @post. Both players scores are set to 0.
         * */
        public void resetPoints() {
            getPlayerOne().setPoints(0);
            getPlayerTwo().setPoints(0);
            assert (playerOne.getPoints()==0 && playerTwo.getPoints() ==0) : "Players points were  not rest";
        }

        /**
         * Resets the players games
         * @post. Both players games are set to 0.
         * */
        public void resetGames() {
            getPlayerOne().setGames(0);
            getPlayerTwo().setGames(0);
//            assertTrue("Players games were  not rest", (playerOne.getGames()==0 && playerTwo.getGames() ==0));
        }

        /**
         * Resets the players completely.
         * @post. Both players scores are reset to the start.
         * */
        public void reset() {
            playerOne = new Player(getPlayerOne().getName());
            playerTwo = new Player(getPlayerTwo().getName());
        }

        /**
         * Returns the player object relating to the name.
         * @pre. There is a player object with the name provided.
         * @return Player Returns a player Object.
         * */
        public Player getPlayer(String name) {
            /* Make sure the name exists in one of the two players.*/
            assert (playerOne.getName().equals(name) || playerTwo.getName().equals(name)) : "name should be one of the two players";
            return getPlayerOne().getName().equals(name) ? getPlayerOne() : getPlayerTwo();
        }

        /**
         * Returns the player object relating to the opponent of the name.
         * @pre. There is a player object with the name provided.
         * @return Player Returns a player Object.
         * */
        public Player getOpponent(Player player) {
             /* Make sure the name exists in one of the two players.*/
            assert (playerOne.getName().equals(player.getName()) || playerTwo.getName().equals(player.getName())) : "name should be one of the two players";
            return getPlayerOne().getName().equals(player.getName()) ? getPlayerTwo() : getPlayerOne();
        }

        /**
         * @return Player one object.
         * */
        public Player getPlayerOne() {
            return playerOne;
        }

        /**
         * @return Player two object.
         * */
        public Player getPlayerTwo() {
            return playerTwo;
        }

        /**
         * Adds the previous games to a Hashmap
         * @post. Previous set of games is added to the previousSets ArrayList HashMap.
         * */
        public void addToPreviousSet() {
            oldSet = new HashMap<>();
            oldSet.put(getPlayerOne().getName(), getPlayerOne().getGames() +"");
            oldSet.put(getPlayerTwo().getName(), getPlayerTwo().getGames() +"");
            previousSets.add(0, oldSet);
        }

        public Boolean isTieBreakGame() {
            return getPlayerOne().getGames() == 6 && getPlayerTwo().getGames() ==6;
        }


        public void setWinner(Player name) {
            matchWinner = name.getName();
        }

        public String getWinner() {
            return matchWinner;
        }

        public ArrayList<HashMap<String,String>> getPreviousSets() {
            return previousSets;
        }

        @Override
        public Boolean isWinner() {
            return matchWinner != null;
        }


        @Override
        public Boolean wonGame(Player winner) {
            int winnerPoints = winner.getPoints();
            int opponentPoints = getOpponent(winner).getPoints();
            assert winnerPoints >= 0 : "Winner Points should not be negative.";
            assert opponentPoints >= 0 : "Opponent Points should not be negative.";

            if (isTieBreakGame()) {
                return pointsToWin(winnerPoints, opponentPoints, 7);
            } else {
                return pointsToWin(winnerPoints, opponentPoints, 4);
            }
        }

        /**
         * Queries if provided points differences would result in a win for a player
         * @param winnerPoints The amount of points winner has.
         * @param opponentPoints The amount of points opponent has.
         * @pre. Winners, Opponents and amount > 0.
         * @return boolean True if it is a winning points difference. False if not.
         * */
        private boolean pointsToWin(int winnerPoints, int opponentPoints, int amount) {
            return winnerPoints >= amount && (winnerPoints - opponentPoints >= 2);
        }

        @Override
        public Boolean wonSet(Player winner) {
            int playerGames = winner.getGames();
            int opponentGames = getOpponent(winner).getGames();
            return playerGames == 6 && opponentGames <= 4 || playerGames == 7;
        }

        @Override
        public Boolean wonMatch(Player winner) {
            return winner.getSets() == 3;
        }
    }
