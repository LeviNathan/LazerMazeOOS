package Controller;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class Problem {
    /*private String name;
    private int numOfLitTargets;
    */
    private String problem;
    
   // private ArrayList<GameToken> gameTokens;
    //private String solution;

    public Problem() {
        //name = "";
        //numOfLitTargets = 0;
        problem = "";
        //gameTokens = new ArrayList<GameToken>();
        //solution = "";
    }

    /*public void setName (String name) {
        this.name = name;
    }

    public void setNumOfLitTargets(int numOfLitTargets) {
        this.numOfLitTargets = numOfLitTargets;
    }
*/
    public void setProblem(String problem) {
        this.problem = problem;
    }

    static public Problem createFromFile(String filename) {
        BufferedReader reader;
        filename = "LazerMazeOOS\\src\\data\\" + filename;
        System.out.println(filename);
        String board = "";
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while(line != null) {
                board = board + '\n' + line;
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Problem problem = new Problem();
        problem.setProblem(board);
        return problem;
    }

    public String toString() {
        return problem;
    }

}