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
        if(gtd == N && light == E) {
            return Facing.S;
        } else if (gtd == S && light == W) {
            return Facing.N;
        } else if (gtd == E && light == S) {
            return Facing.E;
        } else if (gtd == W && light == N) {
            return Facing.W;
        } else {
            return null;
        }
    }

    public boolean targetHit(GameToken gametoken, Facing light) {
        Facing gtd = gametoken.getFacingDirection();
        if (gtd == N && light == S || gtd == S && light == N || gtd == E && light == W || gtd == W && light == E) {
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