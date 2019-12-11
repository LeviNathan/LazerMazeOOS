package Pieces;

public class GameToken {

    private int x;
    private int y;
    private Facing facing;
    private String GameTokenType;
    private Facing lightDirection;
    private Facing hit;

    public GameToken(Facing facing, String GameTokenType) {
        this.x = 0;
        this.y = 0;
        this.facing = facing;
        this.GameTokenType = GameTokenType;
        lightDirection = null;
        hit = null;
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

    public Facing sendDirection(GameToken gametoken, Facing light) {
        Facing gtd = gametoken.getFacingDirection();
        /*if(gtd == Facing.N && light == Facing.E || gtd == Facing.W && light == Facing.W) {
            return Facing.S;
        } else if (gtd == Facing.S && light == Facing.W || gtd == Facing.E && light == Facing.E) {
            return Facing.N;
        } else if (gtd == Facing.W && light == Facing.N || gtd == Facing.S && light == Facing.S) {
            return Facing.E;
        } else if (gtd == Facing.E && light == Facing.S || gtd == Facing.N && light == Facing.N) {
            return Facing.W;
        } else {
            return null;
        }*/
        if(gtd == Facing.N && hit == Facing.E || gtd == Facing.W && hit == Facing.W) {
            return Facing.S;
        } else if (gtd == Facing.S && hit == Facing.W || gtd == Facing.E && hit == Facing.E) {
            return Facing.N;
        } else if (gtd == Facing.W && hit == Facing.N || gtd == Facing.S && hit == Facing.S) {
            return Facing.E;
        } else if (gtd == Facing.E && hit == Facing.S || gtd == Facing.N && hit == Facing.N) {
            return Facing.W;
        } else {
            return null;
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

    public Facing getLightDirection() {
        return lightDirection;
    }

    public void setLightDirection(Facing lightDirection) {
        this.lightDirection = lightDirection;
    }

    public Facing getHit() {
        return hit;
    }

    public void setHit(Facing hit) {
        this.hit = hit;
    }

    public String toString() {
        return getGameTokenType() + getFacingDirection();
    }
}