import Controller.*;
import Pieces.*;

public class Main {

    public static void main(String args[]) {// throws FileNotFoundException {
        
        testProblems("2.txt");
        testProblems("12.txt");
        testProblems("25.txt");
        // Test file for all pieces.
        testProblems("22.txt");
        
    }

    private static void testProblems(String filename) {
        Problem problem = Problem.createFromFile(filename);
        Board board = problem.createBoard();
        ConsoleDisplay console = new ConsoleDisplay();
        board.setDisplay(console);
        System.out.println(problem.getName());  

        if (problem.getName().equals("Problem 2"))
            board.addPiece(new Target(Facing.E), 3, 4);
        else if (problem.getName().equals("Problem 12")) {
            board.addPiece(new Target(Facing.W), 2, 0);
            board.addPiece(new Target(Facing.W), 0, 2);
        } else if (problem.getName().equals("Problem 25")) {
            board.addPiece(new DoubleMirror(Facing.W), 3, 0);
            board.addPiece(new LitTarget(Facing.W), 3, 4);
        } else {
            board.addPiece(new BeamSplitter(Facing.N), 3, 1);
            board.addPiece(new Checkpoint(Facing.E), 3, 2);
            board.addPiece(new CellBlocker(Facing.S), 1, 1);
            board.addPiece(new Target(Facing.E), 3, 4);
            board.addPiece(new DoubleMirror(Facing.W), 1, 4);
            board.addPiece(new DoubleMirror(Facing.E), 1, 2);
            board.addPiece(new LitTarget(Facing.S), 0, 2);
        }
        board.getLaser().setOn(true);
        board.draw();

        System.out.println("Targets Hit");
        if(board.getNumOfTargetsHit() == problem.getNumOfTargets()) {
            System.out.println("*** SUCCESS ***");
        } else {
            System.out.println("*** FAILURE !!!");
        }

        System.out.println("Match to Solution");
        if(console.drawBoardToString(board).equals(problem.getSolutionText()))
            System.out.println("*** SUCCESS ***");
        else
            System.out.println("*** FAILURE !!!");

        System.out.println("Checkpoints Hit");
        if(console.checkCheckpoints(board))
            System.out.println("*** SUCCESS ***");
        else
            System.out.println("*** FAILURE !!!");

        System.out.println(console.drawBoardToString(board));
    }
}