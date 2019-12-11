package Pieces;

public class Light extends GameToken {
    public Light(Facing facing) {
        super(facing, "*");
    }

    @Override
    public void sendDirection(GameToken gametoken) {
        gametoken.setLightDirection(null);
    }

    @Override
    public String toString() {
        return super.getGameTokenType() + " ";
    }
}