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
    public void sendDirection(GameToken gametoken) {
        Facing gtd = gametoken.getFacingDirection();
        Facing light = super.getHit();
        if ((gtd == Facing.N || gtd == Facing.S) && light == Facing.E || (gtd == Facing.E || gtd == Facing.W) && light == Facing.W) {
            gametoken.setLightDirection(Facing.N);
        } else if ((gtd == Facing.N || gtd == Facing.S) && light == Facing.W || (gtd == Facing.E || gtd == Facing.W) && light == Facing.E) {
            gametoken.setLightDirection(Facing.S);
        } else if((gtd == Facing.N || gtd == Facing.S) && light == Facing.N || (gtd == Facing.E || gtd == Facing.W) && light == Facing.S) {
            gametoken.setLightDirection(Facing.E);
        } else if((gtd == Facing.N || gtd == Facing.S) && light == Facing.S || (gtd == Facing.E || gtd == Facing.W) && light == Facing.N) {
            gametoken.setLightDirection(Facing.W);
        } else {
            gametoken.setLightDirection(null);
        }
    }
}