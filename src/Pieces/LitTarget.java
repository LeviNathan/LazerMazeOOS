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