package Pieces;

public class Light extends GameToken {
    public Light(Facing facing) {
        super(facing, "*");
    }

    public String toString() {
        return super.getGameTokenType() + " ";
    }
}