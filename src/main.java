import Controller.*;
import Pieces.*;

public class Main {

    public static void main(String args[]) {// throws FileNotFoundException {
        
        Problem problem2 = Problem.createFromFile("2.txt");
        Board board = problem2.createBoard();
        //ConsoleDisplay console = new ConsoleDisplay();
        
        //board.setDisplay(console);
        board.addPiece(new Target(Facing.E), 3, 4);
        board.getLaser().setOn(true);
        board.draw();
        board.printBoard(board);

        if(board.getNumOfTargetsHit() == problem2.getNumOfTargets()) {
            System.out.println("***SUCCESS***");
        } else {
            System.out.println("***FAILED***");
        }

        //System.out.println(board.getPresetGameTokens().toString());
        /*
        if(console.drawBoardToString(board).equals(problem2.getSolutionText()))
            System.out.println("*** SUCCESS ***");
        else
            System.out.println("*** FAILURE !!!");
        */
    }
}