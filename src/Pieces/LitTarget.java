package Pieces;

public class LitTarget extends GameToken {
    
    public LitTarget(Facing facing) {
        super(facing, "Z");
    }

    public boolean targetHit(Facing light) {
        Facing gtd = super.getFacingDirection();
        if (gtd == Facing.N && light == Facing.S || gtd == Facing.S && light == Facing.N || gtd == Facing.E && light == Facing.W || gtd == Facing.W && light == Facing.E) {
            return true;
        }
        return false;
    }
}