import java.util.ArrayList;
import java.util.List;

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
    public Position[] getPossibleMovements(Board board) {
        List<Position> possibleMovements = new ArrayList<>();

        if(board.isInBoard(this.getPosition().adding(1,2))) {
            possibleMovements.add(this.getPosition().adding(1,2));
        }

        if(board.isInBoard(this.getPosition().adding(1,-2))) {
            possibleMovements.add(this.getPosition().adding(1,-2));
        }

        if(board.isInBoard(this.getPosition().adding(2,1))) {
            possibleMovements.add(this.getPosition().adding(2,1));
        }

        if(board.isInBoard(this.getPosition().adding(2,-1))) {
            possibleMovements.add(this.getPosition().adding(2,-1));
        }

        if(board.isInBoard(this.getPosition().adding(-2,-1))) {
            possibleMovements.add(this.getPosition().adding(-2,-1));
        }

        if(board.isInBoard(this.getPosition().adding(-2,1))) {
            possibleMovements.add(this.getPosition().adding(-2,1));
        }

        if(board.isInBoard(this.getPosition().adding(-1,-2))) {
            possibleMovements.add(this.getPosition().adding(-1,-2));
        }

        if(board.isInBoard(this.getPosition().adding(-1,2))) {
            possibleMovements.add(this.getPosition().adding(-1,2));
        }

        return (Position[]) possibleMovements.toArray();
    }
}
