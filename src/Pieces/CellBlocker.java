package Pieces;

public class CellBlocker extends GameToken {
    
    public CellBlocker(Facing facing) {
        super(facing, "K");
    }
    
    @Override
    public Facing sendDirection(GameToken gametoken, Facing light) {
        return null;
    }
}