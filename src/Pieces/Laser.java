package Pieces;

public class Laser extends GameToken {
    private boolean laserSwitch;

    public Laser(Facing facing) {
        super(facing, "L");
        laserSwitch = false;
    }

    public boolean getLaserSwitch() {
        return laserSwitch;
    }

    public void setOn(boolean on) {
        laserSwitch = on;
    }
}