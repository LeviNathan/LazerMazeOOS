package Pieces;

public class Checkpoint extends GameToken {
    private boolean passThrough;

    public Checkpoint(Facing facing) {
        super(facing, "P");
        passThrough = false;
    }  

    @Override
    public void sendDirection(GameToken gametoken) {
        Facing gtd = gametoken.getFacingDirection();
        Facing light = super.getHit();
        setPassThrough(true);
        if((gtd == Facing.N || gtd == Facing.S) && (light == Facing.N || light == Facing.S)) {
            gametoken.setLightDirection(light);
        } else if((gtd == Facing.E || gtd == Facing.W) && (light == Facing.E || light == Facing.W)) {
            gametoken.setLightDirection(light);
        } else {
            setPassThrough(false);
            gametoken.setLightDirection(null);
        }
    }

    public boolean getPassThrough() {
        return passThrough;
    }

    public void setPassThrough(boolean passThrough) {
        this.passThrough = passThrough;
    }
}