import Controller.*;
import Pieces.*;

public class Main {

    public static void main(String args[]) {// throws FileNotFoundException {
        /*
        Problem problem = Problem.createFromFile("2.txt");
        Board board = problem.createBoard();
        board.addPiece(new Target(Facing.E), 3, 4);
        board.printBoard(board);
        */
        /*
        LitTarget gametoken = new LitTarget(Facing.S);
        System.out.println(gametoken.getFacingDirection());
        System.out.println(gametoken.getGameTokenType());
        */
        
        Problem problem2 = Problem.createFromFile("2.txt");
        Board board = problem2.createBoard();
        //ConsoleDisplay console = new ConsoleDisplay();
        
        //board.setDisplay(console);
        board.addPiece(new Target(Facing.E), 3, 4);
        board.getLaser().setOn(true);
        board.printBoard(board);
        board.draw();

        GameToken gametoken = new CellBlocker(Facing.E);
        System.out.println(gametoken.sendDirection(gametoken, Facing.S));

        /*
        if(console.drawBoardToString(board).equals(problem2.getSolutionText()))
            System.out.println("*** SUCCESS ***");
        else
            System.out.println("*** FAILURE !!!");
        */
    }
}