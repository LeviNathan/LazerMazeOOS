package Pieces;

public class CellBlocker extends GameToken {
    
    public CellBlocker(Facing facing) {
        super(facing, "K");
    }
    
    @Override
    public void sendDirection(GameToken gametoken) {
        gametoken.setLightDirection(null);
    }
}