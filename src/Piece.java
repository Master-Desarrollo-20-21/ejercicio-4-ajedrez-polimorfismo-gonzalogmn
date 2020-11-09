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

    public boolean canMove(Position toPosition, Board board) {
        Position[] possibleMovements = getPossibleMovements(board);

        for(Position position: possibleMovements) {
            if(position.equals(toPosition)) return true;
        }
        return false;
    }

    public Position getPosition() {
        return this.position;
    }

    public Color getColor() {
        return this.color;
    }

    public abstract Position[] getPossibleMovements(Board board);

    public abstract boolean isKing();

    public abstract String getRepresentationType();
}
