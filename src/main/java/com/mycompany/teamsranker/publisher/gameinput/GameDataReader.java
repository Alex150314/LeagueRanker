package com.mycompany.teamsranker.publisher.gameinput;

import com.mycompany.teamsranker.publisher.beans.Game;
import com.mycompany.teamsranker.publisher.exceptions.RankerException;
import java.util.List;

/**
 * Interface used to abstract the way we get the game data. 
 * Reason: We probabbly need in future get information from databases, web services or other type of files.
 *
 * @author Alex
 */
public interface GameDataReader {

    public List<Game> getGamesResults() throws RankerException;

}
