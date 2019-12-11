package Pieces;

public class Laser extends GameToken {
    private boolean laserSwitch;

    public Laser(Facing facing) {
        super(facing, "L");
        laserSwitch = false;
    }

    public Facing sendDirection(GameToken gametoken, Facing light) {
        if (light == null)
            return gametoken.getFacingDirection();
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