package com.mycompany.teamsranker.publisher.calculator;

/**
 * This interface's implementations defines the calculation of points based on
 * won,tied and lost games.
 *
 * @author Alex
 */
public interface PointCalculator {

    public int getPoints(int wonGames, int tiedGames, int lostGames);
}
