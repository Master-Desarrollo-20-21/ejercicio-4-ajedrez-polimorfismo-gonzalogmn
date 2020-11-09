import java.util.ArrayList;
import java.util.List;

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
    public Position[] getPossibleMovements(Board board) {
        List<Position> possibleMovements = new ArrayList<>();

        if(board.isInBoard(this.getPosition().adding(0,1))) {
            possibleMovements.add(this.getPosition().adding(0,1));
        }

        if(board.isInBoard(this.getPosition().adding(1,1)) && board.hasPiece(this.getPosition().adding(1,1), this.getColor() == Color.WHITE ? Color.BLACK : Color.WHITE)) {
            possibleMovements.add(this.getPosition().adding(1,1));
        }

        if(board.isInBoard(this.getPosition().adding(1,-1)) && board.hasPiece(this.getPosition().adding(1,-1), this.getColor() == Color.WHITE ? Color.BLACK : Color.WHITE)) {
            possibleMovements.add(this.getPosition().adding(1,-1));
        }

        return (Position[]) possibleMovements.toArray();
    }
}
