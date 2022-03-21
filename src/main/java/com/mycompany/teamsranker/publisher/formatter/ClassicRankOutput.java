package com.mycompany.teamsranker.publisher.formatter;

import com.mycompany.teamsranker.publisher.beans.Team;
import com.mycompany.teamsranker.publisher.exceptions.OutputRankerException;
import com.mycompany.teamsranker.publisher.exceptions.RankerException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Class used to print and define the format that will be presented. It accepts
 * an OutputStream to make it dynamic working with different output choices.
 *
 * @author Alex
 */
public class ClassicRankOutput implements RankOutputFormatter {

    private OutputStream out;

    public ClassicRankOutput(OutputStream out) {
        this.out = out;
    }

    /**
     * This method is used to print the formatted data into an output stream.
     *
     * @param teams all teams in a rank table
     * @throws RankerException
     */
    @Override
    public void printRank(List<Team> teams) throws RankerException {
        String formattedOutput = buildOutput(teams);
        try {
            out.write(formattedOutput.getBytes());
            out.flush();
        } catch (UnsupportedEncodingException ex) {
            throw new OutputRankerException("Error getting Bytes, UTF-8 enconding format is not supported.", ex);
        } catch (IOException ex) {
            throw new OutputRankerException("Error writting in OuputStream.", ex);
        }
    }

    /**
     * Used to format or build the output using an specific format.
     *
     * @param teams
     * @return
     */
    public String buildOutput(List<Team> teams) {
        int beforePoints = 0;
        int rankState = 0;
        int rank = 1;
        StringBuilder sb = new StringBuilder();
        String pointWord;
        for (Team team : teams) {

            if (team.getPoints() == beforePoints) {
                sb.append(rankState);
            } else {
                sb.append(rank);
                rankState++;
            }
            rank++;
            beforePoints = team.getPoints();
            pointWord = team.getPoints() == 1 ? "pt" : "pts";
            sb.append(". ").append(team.getName()).append(", ");
            sb.append(team.getPoints()).append(" ").append(pointWord).append("\n");
        }
        return sb.toString();
    }

}
