package Pieces;

public class LitTarget extends GameToken {
    private boolean lit;
    
    public LitTarget(Facing facing) {
        super(facing, "Z");
        lit = false;
    }

    public boolean getLit() {
        return lit;
    }

    public void setLit(boolean lit) {
        this.lit = lit;
    }

    public Facing sendDirection(GameToken gametoken, Facing light) {
        Facing gtd = gametoken.getFacingDirection();
        if(gtd == Facing.N && light == Facing.E) {
            return Facing.S;
        } else if (gtd == Facing.S && light == Facing.W) {
            return Facing.N;
        } else if (gtd == Facing.E && light == Facing.S) {
            return Facing.E;
        } else if (gtd == Facing.W && light == Facing.N) {
            return Facing.W;
        } else {
            return null;
        }
    }

    public boolean targetHit(GameToken gametoken, Facing light) {
        Facing gtd = gametoken.getFacingDirection();
        if (gtd == Facing.N && light == Facing.S || gtd == Facing.S && light == Facing.N || gtd == Facing.E && light == Facing.W || gtd == Facing.W && light == Facing.E) {
            return true;
        }
        return false;
    }

    /*
    public Facing sendLaser(Facing laserDirection) {
        if(super.getFacingDirection() == Facing.N && laserDirection == Facing.E) {
            return Facing.S;
        } else if(super.getFacingDirection() == Facing.S && laserDirection == Facing.W) {
            return Facing.N;
        } else if(super.getFacingDirection() == Facing.E && laserDirection == Facing.S) {
            return Facing.E;
        } else if(super.getFacingDirection() == Facing.W && laserDirection == Facing.N) {
            return Facing.W;
        } else {
            return null;
        }
    }
    */
}