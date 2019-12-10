package Controller;

import java.util.*;
import Pieces.*;

public class Board {
    private GameToken[][] board;

    public Board() {
        board = new GameToken[5][5];
        //initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = null;
            }
        }
    }

    public GameToken createPiece(String gameTokenType) {
        char type = gameTokenType.charAt(0);
        char facing = gameTokenType.charAt(1);
        Facing direction = findPieceFacingDirection(facing);
        switch(type) {
            case 'L':
                return new Laser(direction);
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
            default:
                return Facing.W;
        }
    }

    public void addPiece(GameToken gameToken, int x, int y) {
        board[x][y] = gameToken;
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

    public GameToken[][] getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}