import Controller.*;
import Pieces.*;

public class Main {

    public static void main(String args[]) {// throws FileNotFoundException {
        
        Problem problem2 = Problem.createFromFile("25.txt");
        Board board = problem2.createBoard();
        ConsoleDisplay console = new ConsoleDisplay();
        
        board.setDisplay(console);
        System.out.println(problem2.getName());        
        // Problem 2
        //board.addPiece(new Target(Facing.E), 3, 4);
        
        //board.addPiece(new BeamSplitter(Facing.N), 3, 3);
        
        // Problem 12
        //board.addPiece(new Target(Facing.W), 2, 0);
        //board.addPiece(new Target(Facing.W), 0, 2);

        // Problem 25
        board.addPiece(new DoubleMirror(Facing.W), 3, 0);
        board.addPiece(new LitTarget(Facing.W), 3, 4);

        //board.addPiece(new Target(Facing.E), 3, 0);
        board.getLaser().setOn(true);
        board.draw();

        if(board.getNumOfTargetsHit() == problem2.getNumOfTargets()) {
            System.out.println("*** SUCCESS ***");
        } else {
            System.out.println("*** FAILED !!!");
        }

        if(console.drawBoardToString(board).equals(problem2.getSolutionText()))
            System.out.println("*** SUCCESS ***");
        else
            System.out.println("*** FAILURE !!!");

        System.out.println(console.drawBoardToString(board));
    }
}