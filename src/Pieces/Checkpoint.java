package Pieces;

public class Checkpoint extends GameToken {
    private boolean passThrough;

    public Checkpoint(Facing facing) {
        super(facing, "P");
        passThrough = false;
    }  

    @Override
    public Facing sendDirection(GameToken gametoken, Facing light) {
        Facing gtd = gametoken.getFacingDirection();
        if((gtd == Facing.N || gtd == Facing.S) && light == Facing.N) {
            return Facing.N;
        } else if((gtd == Facing.N || gtd == Facing.S) && light == Facing.S) {
            return Facing.S;
        } else if((gtd == Facing.E || gtd == Facing.W) && light == Facing.E) {
            return Facing.N;
        } else if((gtd == Facing.E || gtd == Facing.W) && light == Facing.W) {
            return Facing.W;
        } else {
            return null;
        }
    }

    public boolean getPassThrough() {
        return passThrough;
    }

    public void setPassThrough(boolean passThrough) {
        this.passThrough = passThrough;
    }
}