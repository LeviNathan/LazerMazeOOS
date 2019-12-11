package Controller;
import java.util.*;
import Pieces.*;

public class Board {
    private GameToken[][] board;
    private ArrayList<GameToken> presetGameTokens;
    private Laser laser;

    public Board() {
        board = new GameToken[5][5];
        presetGameTokens = new ArrayList<GameToken>();
        laser = null;
    }

    public GameToken createPiece(String gameTokenType) {
        char type = gameTokenType.charAt(0);
        char facing = gameTokenType.charAt(1);
        Facing direction = findPieceFacingDirection(facing);
        switch(type) {
            case 'L':
                laser = new Laser(direction);
                return laser;
            case 'T':
                return new Target(direction);
            case 'Z':
                return new LitTarget(direction);
            case 'B':
                return new BeamSplitter(direction);
            case 'M':
                return new DoubleMirror(direction);
            case 'P':
                return new Checkpoint(direction);
            case 'K':
                return new CellBlocker(direction);
            default:
                return null;
        }
    }

    public Facing findPieceFacingDirection(char facing) {
        switch(facing) {
            case 'N':
                return Facing.N;
            case 'E':
                return Facing.E;
            case 'S':
                return Facing.S;
            case 'W':
                return Facing.W;
            default:
                return null;
                
        }
    }

    public void addPiece(GameToken gameToken, int x, int y) {
        if (board[x][y] == null && gameToken != null) {
            board[x][y] = gameToken;
            addPresetGameTokens(gameToken);
        }
    }

    /* Will go to ConsoleDisplay Later */
    public void printBoard(Board board) {
        String display = "";
        for (int i = 0; i < 5; i++) {
            display = display + "|";
            for (int j = 0; j < 5; j++) {
                if (board.getBoard()[i][j] == null) {
                    display = display + "  |" ;
                } else {
                    System.out.println(board.getBoard()[i][j].toString());
                    display = display + board.getBoard()[i][j].toString() + "|";
                }
            }
            display = display + "\n";
        }
        System.out.println(display);
    }

    public void draw() {
        System.out.println();
    }

    public GameToken[][] getBoard() {
        return board;
    }

    public void setBoard(GameToken[][] board) {
        this.board = board;
    }

    public ArrayList<GameToken> getPresetGameTokens() {
        return presetGameTokens;
    }

    public void setPresetGameTokens(ArrayList<GameToken> gametokens) {
        presetGameTokens = gametokens;
    }

    public void addPresetGameTokens(GameToken gametoken) {
        presetGameTokens.add(gametoken);
    }

    public Laser getLaser() {
        return laser;
    }

    public void setLaser(Laser laser) {
        this.laser = laser;
    }
}