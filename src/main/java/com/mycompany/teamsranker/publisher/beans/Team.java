package com.mycompany.teamsranker.publisher.beans;

import com.mycompany.teamsranker.publisher.calculator.PointCalculator;
import com.mycompany.teamsranker.publisher.ranker.ResultType;
import java.util.Objects;

/**
 * This class represents a Team in this application where it stores information
 * like points, won, tied and lost games.
 *
 * @author Alex
 */
public class Team {

    private String name;
    private int wonGames;
    private int tiedGames;
    private int lostGames;
    private int points;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWonGames() {
        return wonGames;
    }

    public void setWonGames(int wonGames) {
        this.wonGames = wonGames;
    }

    public int getTiedGames() {
        return tiedGames;
    }

    public void setTiedGames(int tiedGames) {
        this.tiedGames = tiedGames;
    }

    public int getLostGames() {
        return lostGames;
    }

    public void setLostGames(int lostGames) {
        this.lostGames = lostGames;
    }

    public int getPoints() {
        return this.points;
    }

    public void accumulateWonGames(int quantity) {
        this.wonGames += quantity;
    }

    public void accumulateTiedGames(int quantity) {
        this.tiedGames += quantity;
    }

    public void accumulateLostGames(int quantity) {
        this.lostGames += quantity;
    }

    /**
     * Accumulates win lost or tied games depending on result type.
     *
     * @param resultType
     */
    public void accumulateGame(ResultType resultType) {
        switch (resultType) {
            case WIN:
                accumulateWonGames(1);
                break;
            case TIE:
                accumulateTiedGames(1);
                break;
            case LOST:
                accumulateLostGames(1);
                break;
        }
    }

    /**
     * Used to calculate all points related to the won tied and lost games
     *
     * @param pointCalculator this point calculator contains the rules for
     * counting points based on the quantity of won lost or tied games
     * @return
     */
    public int calculatePoints(PointCalculator pointCalculator) {
        points = pointCalculator.getPoints(wonGames, tiedGames, lostGames);
        return this.points;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Team other = (Team) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Team{" + "name=" + name + ", wonGames=" + wonGames + ", tiedGames=" + tiedGames + ", lostGames=" + lostGames + ", points=" + points + '}';
    }

}
