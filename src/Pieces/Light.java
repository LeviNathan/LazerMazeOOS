package Pieces;

public class Light extends GameToken {
    public Light(Facing facing) {
        super(facing, "*");
    }

    @Override
    public Facing sendDirection(GameToken gametoken, Facing light) {
        return null;
    }

    @Override
    public String toString() {
        return super.getGameTokenType() + " ";
    }
}