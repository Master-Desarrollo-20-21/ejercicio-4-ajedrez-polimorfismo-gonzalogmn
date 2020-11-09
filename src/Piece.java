public abstract class Piece {
    private Position position;
    private Color color;

    public Piece(Position position, Color color) {
        this.position = position;
        this.color = color;
    }

    public boolean hasPosition(Position position) {
        return this.position.equals(position);
    }

    public boolean hasColor(Color color) {
        return this.color.equals(color);
    }

    public String getRepresentation() {
        return this.color == Color.BLACK ? this.getRepresentationType() : this.getRepresentationType().toUpperCase();
    }

    public void move(Position position) {
        this.position = position;
    }

    public abstract boolean canMove(Position toPosition);

    public abstract boolean isKing();

    public abstract String getRepresentationType();
}
