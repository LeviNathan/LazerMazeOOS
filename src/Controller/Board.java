package Controller;
import java.util.*;
import Pieces.*;

public class Board {
    private GameToken[][] board;
    private ArrayList<GameToken> presetGameTokens;
    private ArrayList<String> playableGameTokens;
    private int numOfTargetsHit;
    private Laser laser;
    private ConsoleDisplay console;

    public Board() {
        board = new GameToken[5][5];
        presetGameTokens = new ArrayList<GameToken>();
        playableGameTokens = new ArrayList<String>();
        numOfTargetsHit = 0;
        laser = null;
        console = null;
    }

    public GameToken createPiece(String gameTokenType) {
        char type = gameTokenType.charAt(0);
        char facing = gameTokenType.charAt(1);
        Facing direction = findPieceFacingDirection(facing);
        GameToken gametoken;
        switch(type) {
            case 'L':
                laser = new Laser(direction);
                gametoken = laser;
                break;
                //return laser;
            case 'T':
                gametoken = new Target(direction);
                break;
            case 'Z':
                gametoken = new LitTarget(direction);
                break;
            case 'B':
                gametoken = new BeamSplitter(direction);
                break;
            case 'M':
                gametoken = new DoubleMirror(direction);
                break;
            case 'P':
                gametoken = new Checkpoint(direction);
                break;
            case 'K':
                gametoken = new CellBlocker(direction);
                break;
            default:
                return null;
        }
        return gametoken;
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
        if (board[x][y] == null && gameToken != null ) {
            if ((!playableGameTokens.isEmpty() && playableGameTokens.contains(gameToken.getGameTokenType())) || gameToken.getClass() == Light.class) {
                gameToken.setXCoordinate(x);
                gameToken.setYCoordinate(y);
                board[x][y] = gameToken;
                addPresetGameTokens(gameToken);
                removePlayableGameTokens(gameToken.getGameTokenType());
            } else {
                System.out.println("Error: Invalid Game Token not placed.");
            }
        }
    }

    public void draw() {
        if (laser.getLaserSwitch() == false) {
            System.out.println("Error: Laser is off.");
            return;
        }
        laser.setLightDirection(laser.getFacingDirection());
        drawPath(laser);
    }
    /*
    | 00 | 01 | 02 | 03 | 04 |      | 00 | 01 | 02 | 03 | 04 |      xy
    | 05 | 06 | 07 | 08 | 09 |      | 10 | 11 | 12 | 13 | 14 |
    | 10 | 11 | 12 | 13 | 14 |      | 20 | 21 | 22 | 23 | 24 |
    | 15 | 16 | 17 | 18 | 19 |      | 30 | 31 | 32 | 33 | 34 |
    | 20 | 21 | 22 | 23 | 24 |      | 40 | 41 | 42 | 43 | 44 |
    */
    public void drawPath(GameToken token) {
        int position = (token.getXCoordinate() * 5) + (token.getYCoordinate());
        Facing lightDirection = token.getLightDirection();
        int i = findLightPath(lightDirection);
        position += i;
        while(position >= 0 && position < 25){
            int positionX = position / 5;
            int positionY = position % 5; 
            if (board[positionX][positionY] == null) {
                addPiece(new Light(laser.getFacingDirection()), positionX, positionY);
            } else {
                GameToken gametoken = board[positionX][positionY];
                gametoken.setLightDirection(lightDirection);
                if (gametoken.getClass() == BeamSplitter.class)
                    drawPath(gametoken);
                checkTargetHit(gametoken, lightDirection);
                gametoken.setHit(lightDirection);
                gametoken.sendDirection(gametoken);
                lightDirection = gametoken.getLightDirection();
                i = findLightPath(lightDirection);
            }
            if ((((position + i) % 5 == 0) && i == 1) || (position)% 5 == 0 && i == -1) 
                break;
            position += i;
        }
    }

    public int findLightPath(Facing lightDirection) {
        if (lightDirection == Facing.N)
            return -5;
        if (lightDirection == Facing.S)
            return 5;
        if (lightDirection == Facing.E) 
            return 1;
        if (lightDirection == Facing.W)
            return -1;
        return 25;
    }

    public void checkTargetHit(GameToken gametoken, Facing light) {
        if (gametoken.getClass() == LitTarget.class) {
            LitTarget tmp = new LitTarget(gametoken.getFacingDirection());
            if(tmp.targetHit(light)) {
                numOfTargetsHit += 1;
            }
        }
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
    public ArrayList<String> getPlayableGameTokens() {
        return playableGameTokens;
    }

    public void setPlayableGameTokens(ArrayList<String> gametokenList) {
        playableGameTokens = gametokenList;
    }
    public void removePlayableGameTokens(String gametokenType) {
        playableGameTokens.remove(gametokenType);
    }

    public int getNumOfTargetsHit() {
        return numOfTargetsHit;
    }

    public void setNumOfTargetsHit(int numOfTargetsHit) {
        this.numOfTargetsHit = numOfTargetsHit;
    }
    public Laser getLaser() {
        return laser;
    }

    public void setLaser(Laser laser) {
        this.laser = laser;
    }
    
    public ConsoleDisplay getDisplay() {
        return console;
    }

    public void setDisplay(ConsoleDisplay console) {
        this.console = console;
    }
}