package Pieces;

public class GameToken {

    private int x;
    private int y;
    private Facing facing;
    private String GameTokenType;

    public GameToken(Facing facing, String GameTokenType) {
        this.x = 0;
        this.y = 0;
        this.facing = facing;
        this.GameTokenType = GameTokenType;
    }

    public String direction() {
        switch(facing) {
            case N:
                return "Token facing North";
            case E:
                return "Token facing East";
            case S:
                return "Token facing South";
            case W:
                return "Token facing West";
            default:
                return "Failed";
        }
    }

    public int getXCoordinate() {
        return x;
    }
    public int getYCoordinate() {
        return y;
    }

    public Facing getFacingDirection() {
        return facing;
    }
    
    public void setXCoordinate(int x) {
        this.x = x;
    }

    public void setYCoordinate(int y) {
        this.y = y;
    }

    public void setFacingDirection(Facing facing) {
        this.facing = facing;
    }

    public String getGameTokenType() {
        return GameTokenType;
    }

    public String toString() {
        return getGameTokenType() + getFacingDirection();
    }
}