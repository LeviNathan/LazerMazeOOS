package Pieces;

public class BeamSplitter extends GameToken {
    private Facing straightLight;
    public BeamSplitter(Facing facing) {
        super(facing, "B");
        straightLight = null;
    }

    public Facing getStraightLight() {
        return straightLight;
    }

    public void setStraightLight(Facing straightLight) {
        this.straightLight = straightLight;
    }

    @Override
    public Facing sendDirection(GameToken gametoken, Facing light) {
        Facing gtd = gametoken.getFacingDirection();
        if ((gtd == Facing.N || gtd == Facing.S) && super.getHit() == Facing.E || (gtd == Facing.E || gtd == Facing.W) && super.getHit() == Facing.W) {
            return Facing.N;
        } else if ((gtd == Facing.N || gtd == Facing.S) && super.getHit() == Facing.W || (gtd == Facing.E || gtd == Facing.W) && super.getHit() == Facing.E) {
            return Facing.S;
        } else if((gtd == Facing.N || gtd == Facing.S) && super.getHit() == Facing.N || (gtd == Facing.E || gtd == Facing.W) && super.getHit() == Facing.S) {
            return Facing.E;
        } else if((gtd == Facing.N || gtd == Facing.S) && super.getHit() == Facing.S || (gtd == Facing.E || gtd == Facing.W) && super.getHit() == Facing.N) {
            return Facing.W;
        } else {
            return null;
        }
    }
}