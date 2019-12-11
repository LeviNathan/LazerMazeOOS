package Pieces;

public class Laser extends GameToken {
    private boolean laserSwitch;

    public Laser(Facing facing) {
        super(facing, "L");
        laserSwitch = false;
    }

    public Facing sendDirection(GameToken gametoken, Facing light) {
        gametoken.setLightDirection(gametoken.getFacingDirection());
        if (light == null)
            return gametoken.getLightDirection();
        else
            return null;
    }

    public boolean getLaserSwitch() {
        return laserSwitch;
    }

    public void setOn(boolean on) {
        laserSwitch = on;
    }
}