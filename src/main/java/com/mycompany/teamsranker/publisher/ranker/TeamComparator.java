package com.mycompany.teamsranker.publisher.ranker;

import com.mycompany.teamsranker.publisher.beans.Team;
import java.util.Comparator;

/**
 * Used to make easier comparison between list teams when sort the collection
 * This class is intended to organize the list using a descendant mode in points but name using ascendant.
 * @author Alex
 */
public class TeamComparator implements Comparator<Team> {

    @Override
    public int compare(Team t1, Team t2) {
        if (t1.getPoints() > t2.getPoints()) {
            return -1;
        } else if (t1.getPoints() == t2.getPoints()) {
            return t1.getName().compareTo(t2.getName());
        } else {
            return 1;
        }
    }

}
