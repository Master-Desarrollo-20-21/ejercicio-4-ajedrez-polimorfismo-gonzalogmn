public class Player {
    private Board board;
    private Color color;

    public Player(Color color, Board board) {
        this.color = color;
        this.board = board;
    }

    public void move() {
        Console console = new Console();
        Position piecePosition = null;
        Position toPosition = null;

        boolean correctPosition = true;
        do {
            console.out("Player " + this.color + ", please select piece position:");
            String coordinate = console.inString().toUpperCase();

            if(Position.isValid(coordinate)) {
                piecePosition = new Position(coordinate);

                if(!board.isInBoard(piecePosition) || !board.hasPiece(piecePosition, this.color)) correctPosition = false;
            } else {
                correctPosition = false;
            }

        } while(!correctPosition);

        console.out("Piece selected!");

        do {
            console.out("Please select piece movement:");
            String coordinate = console.inString().toUpperCase();

            if(Position.isValid(coordinate)) {
                toPosition = new Position(coordinate);

                if(!board.isInBoard(toPosition) || board.hasPiece(toPosition, this.color)) correctPosition = false;
            } else {
                correctPosition = false;
            }
        } while(!correctPosition);

        board.move(piecePosition, toPosition, this.color);
    }

    public Color getColor() {
        return this.color;
    }
}
