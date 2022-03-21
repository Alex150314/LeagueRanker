package com.mycompany.teamsranker.publisher.formatter;

import com.mycompany.teamsranker.publisher.beans.Team;
import com.mycompany.teamsranker.publisher.exceptions.RankerException;
import java.util.List;

/**
 * Interface used to define a formatter for the Teams list depending on needs
 * and choices.
 *
 * @author Alex
 */
public interface RankOutputFormatter {

    public void printRank(List<Team> teams) throws RankerException;

}
