package com.mycompany.teamsranker.publisher.calculator;

/**
 * This class is the rule used to count how many points has a team depending the
 * won, lost or tied games.
 *
 * @author Alex
 */
public class ClassicPointCalculator implements PointCalculator {

    private final int POINTS_PER_WON = 3;
    private final int POINTS_PER_TIE = 1;
    private final int POINTS_PER_LOST = 0;

    @Override
    public int getPoints(int wonGames, int tiedGames, int lostGames) {
        int totalPoints = (POINTS_PER_WON * wonGames) + (POINTS_PER_TIE * tiedGames) + (POINTS_PER_LOST * lostGames);
        return totalPoints;
    }
}
