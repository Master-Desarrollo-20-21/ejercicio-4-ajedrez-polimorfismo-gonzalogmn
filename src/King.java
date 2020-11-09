public class King extends Piece {
    public King(Position position, Color color) {
        super(position, color);
    }

    @Override
    public boolean isKing() {
        return true;
    }

    @Override
    public String getRepresentationType() {
        return "ki";
    }

    @Override
    public boolean canMove(Position toPosition) {
        return true;
    }
}
