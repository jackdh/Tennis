//package tennis.Tests;
//
//import org.junit.Test;
//import tennis.Modal.Modal;
//
//import static org.junit.Assert.*;
//
///**
// * Created by jack on 09/11/2016.
// */
//public class ModalTest {
//
//    /**
//     * This tests adding a single point to a player and checking it returns the right score.
//     *
//     * This is the most basic addGreenBackground possible should this not correctly return it is likely that none of the tests
//     * will work.
//     *
//     * @throws Exception If one point is not added correctly.
//     * */
//    @Test
//    public void addPoint() throws Exception {
//        String murray = "Murray";
//        Modal modal = new Modal(murray, "Nadal");
//        modal.addPoint(murray);
//        String points = modal.getPoints(murray);
//        assertTrue(points.equals("15"));
//    }
//
//    /**
//     * Testing that the Tiebreaker works.
//     * It will get both players to 6 games.
//     * It will then give one layer 6 point sin the tiebreaker
//     * It will then give the other 8 points.
//     *
//     * This will addGreenBackground if the tie breaker is won and by 2 points over the seven point limit.
//     * @throws Exception if tie breaker is not correctly won.
//     */
//    @Test
//    public void winBreakPoint() throws Exception {
//        String murray = "Murray";
//        String nadal = "Nadal";
//        Modal modal = new Modal(murray, nadal);
//        // Get Murry and Nadal to 5 games each.
//        for (int i = 0; i <20; i++) {
//            modal.addPoint(murray);
//        }
//        for (int i = 0; i <20; i++) {
//            modal.addPoint(nadal);
//        }
//        // Get Murray and Nadal to 6 games each.
//        for (int i = 0; i <4; i++) {
//            modal.addPoint(murray);
//        }
//        for (int i = 0; i <4; i++) {
//            modal.addPoint(nadal);
//        }
//        // Give Nadal 6 points
//        for (int i = 0; i <6; i++) {
//            modal.addPoint(nadal);
//        }
//        for (int i = 0; i <8; i++) {
//            modal.addPoint(murray);
//        }
//        assertTrue("Tie Breaker failed", modal.getSets(murray).equals("1") && modal.getPoints(murray).equals("0"));
//    }
//
//    /**
//     * Tests to make sure that
//     *
//     * @throws Exception Match is not won in the required amount of games.
//     * */
//    @Test
//    public void testDeuce() throws Exception {
//        String murray = "Murray";
//        String nadal = "Nadal";
//        Modal modal = new Modal(murray, nadal);
//        for (int i = 0; i <(8); i++) {
//            modal.addPoint(murray);
//            modal.addPoint(nadal);
//        }
//        assertTrue("Both Scores should report duece", (modal.getPoints(nadal).equals("D") && modal.getPoints(murray).equals("D")));
//        modal.addPoint(murray);
//        assertTrue("Murray should have Advantage", (modal.getPoints(nadal).equals("40") && modal.getPoints(murray).equals("A")));
//        modal.addPoint(nadal);
//        assertTrue("Both Scores should report duece again.", (modal.getPoints(nadal).equals("D") && modal.getPoints(murray).equals("D")));
//        modal.addPoint(murray);
//        modal.addPoint(murray);
//        assertTrue("Murry should have won  1 game and Nadal 0", (modal.getGames(murray).equals("1") && modal.getGames(nadal).equals("0")));
//    }
//
//    /**
//     * This si to addGreenBackground that a Match can be won.
//     * A player will be given 72 games which is the right amount for exactly 3 sets to then win the game.
//     *
//     * @throws Exception Match is not won in the required amount of games.
//     * */
//    @Test
//    public void winMatch() throws Exception {
//        String murray = "Murray";
//        String nadal = "Nadal";
//        Modal modal = new Modal(murray, nadal);
//        for (int i = 0; i <(4*6*3); i++) {
//            modal.addPoint(murray);
//        }
//
//        assertTrue("", modal.getWinner().equals(murray));
//
//    }
//
//
//
//}