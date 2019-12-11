package Controller;

import Pieces.*;

public class ConsoleDisplay {

    public ConsoleDisplay() {

    }

    public String drawBoardToString(Board board) {
        String display = "";
        for (int i = 0; i < 5; i++) {
            display = display + "|";
            for (int j = 0; j < 5; j++) {
                if (board.getBoard()[i][j] == null) {
                    display = display + "  |" ;
                } else {
                    display = display + board.getBoard()[i][j].toString() + "|";
                }
            }
            display = display + "\n";
        }
        return display;
    }

    public boolean checkCheckpoints(Board board) {
        int size = board.getPresetGameTokens().size();
        for(int i = 0; i < size; i++) {
            GameToken gametoken = board.getPresetGameTokens().get(i);
            if(gametoken.getClass() == Checkpoint.class) {
                Facing facing = gametoken.getFacingDirection();
                Facing hit = gametoken.getHit();
                if ((facing == Facing.N || facing == Facing.S) && (hit == Facing.W || hit == Facing.E) || hit == null)
                    return false;
                if ((facing == Facing.W || facing == Facing.E) && (hit == Facing.N || hit == Facing.S))
                    return false;    
            }
        }
        return true;
    }
    
}