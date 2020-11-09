public class Pawn extends Piece {
    public Pawn(Position position, Color color) {
        super(position, color);
    }

    @Override
    public boolean isKing() {
        return false;
    }

    @Override
    public String getRepresentationType() {
        return "pa";
    }

    @Override
    public boolean canMove(Position toPosition) {
        return true;
    }
}
