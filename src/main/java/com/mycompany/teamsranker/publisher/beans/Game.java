package com.mycompany.teamsranker.publisher.beans;

import java.util.Objects;

/**
 * Class that represents a Game or Match where 2 teams plays and result is
 * presented using this.
 *
 * @author Alex
 */
public class Game {

    private String homeTeam;
    private String guestTeam;
    private int homeTeamGoals;
    private int guestTeamGoals;

    public Game(String homeTeam, int homeTeamGoals, String guestTeam, int guestTeamGoals) {
        this.homeTeam = homeTeam;
        this.homeTeamGoals = homeTeamGoals;
        this.guestTeam = guestTeam;
        this.guestTeamGoals = guestTeamGoals;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(String guestTeam) {
        this.guestTeam = guestTeam;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getGuestTeamGoals() {
        return guestTeamGoals;
    }

    public void setGuestTeamGoals(int guestTeamGoals) {
        this.guestTeamGoals = guestTeamGoals;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[homeTeam=").append(this.homeTeam);
        strBuilder.append(", homeTeamGoals=").append(this.homeTeamGoals);
        strBuilder.append(", guestTeam=").append(this.guestTeam);
        strBuilder.append(", guestTeamGoals=").append(this.guestTeamGoals).append("]");
        return strBuilder.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.homeTeam);
        hash = 97 * hash + Objects.hashCode(this.guestTeam);
        hash = 97 * hash + this.homeTeamGoals;
        hash = 97 * hash + this.guestTeamGoals;
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
        final Game other = (Game) obj;
        if (this.homeTeamGoals != other.homeTeamGoals) {
            return false;
        }
        if (this.guestTeamGoals != other.guestTeamGoals) {
            return false;
        }
        if (!Objects.equals(this.homeTeam, other.homeTeam)) {
            return false;
        }
        if (!Objects.equals(this.guestTeam, other.guestTeam)) {
            return false;
        }
        return true;
    }

}
