package com.mycompany.teamsranker.publisher.gameinput;

import com.mycompany.teamsranker.publisher.exceptions.UnableToAccessDataException;
import com.mycompany.teamsranker.publisher.beans.Game;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class used to read the Game data from a file using a filepath.
 *
 * @author Alex
 */
public class FileGameDataReader implements GameDataReader {

    private String filePath;

    public FileGameDataReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Gets a List<Game> reading the data from the file respecting specific
     * format.
     *
     * @return
     * @throws UnableToAccessDataException
     */
    @Override
    public List<Game> getGamesResults() throws UnableToAccessDataException {
        List<Game> gamesResults = new ArrayList<>();
        try {
            Scanner data = new Scanner(new BufferedReader(new FileReader(filePath)));
            while (data.hasNext()) {
                String dataLine = data.nextLine();
                String[] lineSplit = dataLine.split(",");
                String[] homeTeamInfoSplited = lineSplit[0].trim().split("\\s+");
                String[] guestTeamInfoSplited = lineSplit[1].trim().split("\\s+");

                String homeTeamName = extractTeamName(homeTeamInfoSplited);
                int homeTeamGoals = extractTeamGoals(homeTeamInfoSplited);
                String guestTeamName = extractTeamName(guestTeamInfoSplited);
                int guestTeamGoals = extractTeamGoals(guestTeamInfoSplited);

                Game gameData = new Game(homeTeamName, homeTeamGoals, guestTeamName, guestTeamGoals);
                gamesResults.add(gameData);
            }
        } catch (IOException ex) {
            throw new UnableToAccessDataException("Error trying to read file from path: " + filePath, ex);
        }
        return gamesResults;
    }

    private String extractTeamName(String[] teamInfo) {
        String name = teamInfo[0];
        for (int i = 1; i < teamInfo.length - 1; i++) {
            name += " " + teamInfo[i];
        }
        return name;
    }

    private int extractTeamGoals(String[] teamInfo) {
        return Integer.parseInt(teamInfo[teamInfo.length - 1]);
    }
}
