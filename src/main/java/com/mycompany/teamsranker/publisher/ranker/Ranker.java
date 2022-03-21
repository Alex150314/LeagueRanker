package com.mycompany.teamsranker.publisher.ranker;

import com.mycompany.teamsranker.publisher.beans.Game;
import com.mycompany.teamsranker.publisher.beans.Team;
import com.mycompany.teamsranker.publisher.calculator.PointCalculator;
import com.mycompany.teamsranker.publisher.exceptions.RankerException;
import com.mycompany.teamsranker.publisher.gameinput.GameDataReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Ranker class is in charge of use other components to fetch the games
 * information and then use it to create an ordered table with the teams. It
 * doesn't print the information.
 *
 * @author Alex
 */
public class Ranker {

    private List<Team> rankedList;
    private GameDataReader gameDataReader;
    private PointCalculator pointCalculator;

    public Ranker(GameDataReader gameDataReader, PointCalculator pointCalculator) {
        this.gameDataReader = gameDataReader;
        this.pointCalculator = pointCalculator;
    }

    /**
     * Uses the List<Game> to extract all the information to create a ranked
     * list depending on points gotten by each team.
     *
     * @throws RankerException when error reading data.
     */
    public List<Team> rankTeams() throws RankerException {
        rankedList = new ArrayList<>();
        List<Game> gamesResults = gameDataReader.getGamesResults();
        for (Game gameResult : gamesResults) {
            addTeamsToListIfNotExist(gameResult);
            checkResult(gameResult);
        }
        calculatePoints();
        rankedList.sort(new TeamComparator());
        return rankedList;
    }

    /**
     * Uses the games list to extract teams and add it to the teams list.
     */
    private void addTeamsToListIfNotExist(Game gameResult) {
        Team homeTeam = new Team(gameResult.getHomeTeam());
        Team guestTeam = new Team(gameResult.getGuestTeam());

        if (!rankedList.contains(homeTeam)) {
            rankedList.add(homeTeam);
        }
        if (!rankedList.contains(guestTeam)) {
            rankedList.add(guestTeam);
        }
    }

    /**
     * Used to check results and call accumulate results for each team.
     */
    private void checkResult(Game gameResult) {
        ResultType homeResult;
        ResultType guestResult;
        int homeGoals = gameResult.getHomeTeamGoals();
        int guestGoals = gameResult.getGuestTeamGoals();

        if (homeGoals > guestGoals) {
            homeResult = ResultType.WIN;
            guestResult = ResultType.LOST;
        } else if (homeGoals == guestGoals) {
            homeResult = ResultType.TIE;
            guestResult = ResultType.TIE;
        } else {
            homeResult = ResultType.LOST;
            guestResult = ResultType.WIN;
        }
        accumulateResult(gameResult.getHomeTeam(), homeResult);
        accumulateResult(gameResult.getGuestTeam(), guestResult);
    }

    /**
     * Calls the accumulate team method to increase the quantity of games won
     * tied or lost.
     */
    private void accumulateResult(String teamName, ResultType resultType) {
        for (Team team : rankedList) {
            if (team.getName().equals(teamName)) {
                team.accumulateGame(resultType);
            }
        }
    }

    /**
     * Calls the calculatePoints method for each team so then we can order the
     * list using the points got.
     */
    private void calculatePoints() {
        for (Team team : rankedList) {
            team.calculatePoints(pointCalculator);
        }
    }

}
