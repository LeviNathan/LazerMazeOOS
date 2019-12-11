package Controller;
import Pieces.*;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Problem {
    private String name;
    private int numOfTargets;
    private String problem;
    private ArrayList<String> gameTokens;
    private String solution;

    public Problem() {
        name = "";
        numOfTargets = 0;
        problem = "";
        gameTokens = new ArrayList<String>();
        solution = "";
    }

    static public Problem createFromFile(String filename) {
        BufferedReader reader;
        filename = "src\\data\\" + filename;
        Problem problem = new Problem();
        try {
            reader = new BufferedReader(new FileReader(filename));
            problem.setName(reader.readLine());
            String pieces = reader.readLine();
            splitTokens(pieces, problem);
            for(int i = 0; i < 5; i++) {
                problem.setProblem(problem.getProblem() + reader.readLine() + "\n");
            }
            reader.readLine();
            for(int i = 0; i < 5; i++) {
                problem.setSolution(problem.getSolution() + reader.readLine() + "\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return problem;
    }
    
    static public void splitTokens(String pieces, Problem problem) {
        String[] tokens = pieces.split(",");
        try {
            problem.setNumOfTargets(Integer.parseInt(tokens[0]));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        for(int i = 1; i < tokens.length; i++) {
            problem.addGameTokens(tokens[i]);
        }
    }

    public Board createBoard() {
        Board board = new Board();
        String[] rows = getProblem().split("\n");
        for (int i = 0; i < rows.length; i++) {
            rows[i] = rows[i].replace("|", ",");
            String[] token = rows[i].split(",");
            for (int j = 1; j < 6; j++) {
                GameToken gameToken = board.createPiece(token[j]);
                if (gameToken != null) {
                    if (gameToken.getFacingDirection() == Facing.z)
                        findUnknownPieceDirection(gameToken, i, j);
                }
                board.addPiece(gameToken, i, j-1);
            }
        }
        return board;
    }

    public void findUnknownPieceDirection(GameToken gametoken, int x, int y) {
        String[] rows = getSolution().split("\n");
        rows[x] = rows[x].replace("|", ",");
        String[] token = rows[x].split(",");
        char facing = token[y].charAt(1);
        switch(facing) {
            case 'N':
                gametoken.setFacingDirection(Facing.N);
                break;
            case 'S':
                gametoken.setFacingDirection(Facing.S);
                break;
            case 'E':
                gametoken.setFacingDirection(Facing.E);
                break;
            default:
                gametoken.setFacingDirection(Facing.W);
        }
    }

    public String toString() {
        return getProblem();
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfTargets() {
        return numOfTargets;
    }

    public void setNumOfTargets(int numOfTargets) {
        this.numOfTargets = numOfTargets;
    }
    
    public ArrayList<String> getGameTokens() {
        return gameTokens;
    }

    public void addGameTokens(String gameTokenChar) {
        gameTokens.add(gameTokenChar);
    }

    public void removeGameTokens() {

    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}