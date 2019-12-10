package Pieces;

public class DoubleMirror extends GameToken {
    public DoubleMirror(Facing facing) {
        super(facing, "M");
    }

    @Override
    public Facing sendDirection(GameToken gametoken, Facing light) {
        Facing gtd = gametoken.getFacingDirection();
        if ((gtd == Facing.N || gtd == Facing.S) && light == Facing.E || (gtd == Facing.E || gtd == Facing.W) && light == Facing.W) {
            return Facing.N;
        } else if ((gtd == Facing.N || gtd == Facing.S) && light == Facing.W || (gtd == Facing.E || gtd == Facing.W) && light == Facing.E) {
            return Facing.S;
        } else if((gtd == Facing.N || gtd == Facing.S) && light == Facing.N || (gtd == Facing.E || gtd == Facing.W) && light == Facing.S) {
            return Facing.E;
        } else if((gtd == Facing.N || gtd == Facing.S) && light == Facing.S || (gtd == Facing.E || gtd == Facing.W) && light == Facing.N) {
            return Facing.W;
        } else {
            return null;
        }
    }
}