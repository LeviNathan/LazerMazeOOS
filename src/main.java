import Controller.*;
import Pieces.*;
import java.util.*;

public class main {
    public static void main(String args[]) {// throws FileNotFoundException {
        Problem problem = Problem.createFromFile("2.txt");
        System.out.println(problem.toString());
        /*
        Problem problem2 = Problem.createFromFile("2.txt");
        Board board = problem2.createBoard();
        ConsoleDisplay console = new ConsoleDisplay();
        
        board.setDisplay(console);
        board.addPiece(new Target(Facing.E), 3, 4);
        board.getLaser().setOn(true);
        board.draw();

        if(console.drawBoardToString(board).equals(problem2.getSolutionText()))
            System.out.println("*** SUCCESS ***");
        else
            System.out.println("*** FAILURE !!!");
        */
    }
}