package Pieces;

public class Target extends GameToken {
    
    private Facing lightDirection;

    public Target(Facing facing) {
        super(facing, "T");
        lightDirection = null;
    }

    public Facing getLightDirection() {
        return lightDirection;
    }
}