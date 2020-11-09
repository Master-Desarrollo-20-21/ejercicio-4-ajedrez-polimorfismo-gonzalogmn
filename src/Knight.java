public class Knight extends Piece {
    public Knight(Position position, Color color) {
        super(position, color);
    }

    @Override
    public boolean isKing() {
        return false;
    }

    @Override
    public String getRepresentationType() {
        return "kn";
    }

    @Override
    public boolean canMove(Position toPosition) {
        return true;
    }
}
