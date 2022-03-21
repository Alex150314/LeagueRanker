package com.mycompany.teamsranker.publisher;

import com.mycompany.teamsranker.publisher.beans.Team;
import com.mycompany.teamsranker.publisher.calculator.ClassicPointCalculator;
import com.mycompany.teamsranker.publisher.exceptions.RankerException;
import com.mycompany.teamsranker.publisher.formatter.ClassicRankOutput;
import com.mycompany.teamsranker.publisher.formatter.RankOutputFormatter;
import com.mycompany.teamsranker.publisher.gameinput.FileGameDataReader;
import com.mycompany.teamsranker.publisher.ranker.Ranker;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Main used to create a rank table from a fileinput, 
 * this table could be printed in console or in an output file dependegin arguments entered
 * if second optional argument(filepath) is supplied, output table will print on that file.
 * otherwise will be printed over System.out.
 * @arguments args[0] = input file path, args[1] = output file path (optional)
 * @author Alex
 */
public class GameRankerMain {

    public static final Logger LOGGER = Logger.getLogger(GameRankerMain.class.getName());

    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                String filePath = args[0];
                OutputStream output = System.out;
                if (args.length == 2) {
                    String outputFile = args[1];
                    File file = new File(outputFile);
                    output = new FileOutputStream(file);
                }
                Ranker ranker = new Ranker(new FileGameDataReader(filePath), new ClassicPointCalculator());
                List<Team> lista = ranker.rankTeams();
                RankOutputFormatter rankOutFormat = new ClassicRankOutput(output);
                rankOutFormat.printRank(lista);

            } catch (RankerException ex) {
                LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            } catch (FileNotFoundException ex) {
                LOGGER.log(Level.SEVERE, "File not found inside provided path.", ex);
            }
        } else {
            LOGGER.log(Level.SEVERE, "No file input path datasource was introduced. Please add the filepath (first argument).");
        }
    }

}
