import java.util.Arrays;

public class Board {
    private Piece[] pieces;

    public final static char[] ROWS = new char[]{1, 2, 3, 4, 5, 6, 7, 8};
    public static char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public final static int[] COLUMNS = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

    public Board() {
        pieces = new Piece[]{
                new King(new Position("D1"), Color.BLACK),
                new Knight(new Position("B1"), Color.BLACK),
                new Knight(new Position("G1"), Color.BLACK),
                new Pawn(new Position("A2"), Color.BLACK),
                new Pawn(new Position("B2"), Color.BLACK),
                new Pawn(new Position("C2"), Color.BLACK),
                new Pawn(new Position("D2"), Color.BLACK),
                new Pawn(new Position("E2"), Color.BLACK),
                new Pawn(new Position("F2"), Color.BLACK),
                new Pawn(new Position("G2"), Color.BLACK),
                new Pawn(new Position("H2"), Color.BLACK),
                new King(new Position("D8"), Color.WHITE),
                new Knight(new Position("B8"), Color.WHITE),
                new Knight(new Position("G8"), Color.WHITE),
                new Pawn(new Position("A7"), Color.WHITE),
                new Pawn(new Position("B7"), Color.WHITE),
                new Pawn(new Position("C7"), Color.WHITE),
                new Pawn(new Position("D7"), Color.WHITE),
                new Pawn(new Position("E7"), Color.WHITE),
                new Pawn(new Position("F7"), Color.WHITE),
                new Pawn(new Position("G7"), Color.WHITE),
                new Pawn(new Position("H7"), Color.WHITE)
        };
    }

    public boolean hasKing(Color color) {
        return Arrays.stream(this.pieces).filter(p -> p != null && p.isKing() && p.hasColor(color)).findFirst().isPresent();
    }

    public boolean isInBoard(Position position) {
        boolean hasRow = false;
        for(char row: ROWS) {
            if(row == position.getRow()) hasRow = true;
        }
        boolean hasColumn = false;
        for(int column: COLUMNS) {
            if(column == position.getColumn()) hasColumn = true;
        }
        return hasRow && hasColumn;
    }

    public boolean hasPiece(Position position, Color color) {
        return Arrays.stream(this.pieces).filter(p -> p != null && p.hasPosition(position) && p.hasColor(color)).findFirst().isPresent();
    }

    public void move(Position piecePosition, Position toPosition, Color movementColor) {
        assert(this.isInBoard(piecePosition));
        assert(this.isInBoard(toPosition));
        assert(this.hasPiece(piecePosition, movementColor));

        Piece piece = Arrays.stream(this.pieces).filter(p -> p != null && p.hasPosition(piecePosition)).findFirst().get();

        if(this.hasPiece(toPosition, movementColor == Color.WHITE ? Color.BLACK : Color.WHITE)) {
            this.deletePiece(toPosition);
        };

        if(piece.canMove(toPosition, this)) {
            piece.move(toPosition);
        }
        
    }

    public void show() {
        Console console = new Console();
        for(int i = COLUMNS.length - 1; i >= 0; i--) {
            console.out(i + "> ");
            for(int j = 0; j < ROWS.length; j++) {
                Position position = new Position(ROWS[j] + String.valueOf(COLUMNS[i]));
                if(this.hasAnyPiece(position)) {
                    Piece piece = this.getPiece(position);
                    console.out(piece.getRepresentation() + " ");
                } else {
                    console.out("__ ");
                }
                
                
            }
            console.out("\n");
        }

        console.out("  ");
        for(char row: ROWS) {
            console.out(" ^ ");  
        }

        console.out("\n");
        console.out("  ");

        for(int i = 0; i< ROWS.length; i++) {
            console.out(" " + ALPHABET[i] + " ");
        }

        console.out("\n");
    }


    public boolean hasAnyPiece(Position position) {
        return Arrays.stream(this.pieces).filter(p -> p != null && p.hasPosition(position)).findFirst().isPresent();
    }

    private void deletePiece(Position position) {
        for(int i = 0; i < pieces.length; i++) {
            if(pieces[i] != null && pieces[i].hasPosition(position)) {
                pieces[i] = null;
                new Console().out("Piece eaten! \n");
            }
        }
    }

    private Piece getPiece(Position position) {
        assert(this.hasAnyPiece(position));
        return Arrays.stream(this.pieces).filter(p -> p != null && p.hasPosition(position)).findFirst().get();
    }
}
