import java.util.ArrayList;
import java.util.List;

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
    public Position[] getPossibleMovements(Board board) {
        List<Position> possibleMovements = new ArrayList<>();

        if(board.isInBoard(this.getPosition().adding(1,1))) {
            possibleMovements.add(this.getPosition().adding(1,1));
        }

        if(board.isInBoard(this.getPosition().adding(0,1))) {
            possibleMovements.add(this.getPosition().adding(0,1));
        }

        if(board.isInBoard(this.getPosition().adding(0,-1))) {
            possibleMovements.add(this.getPosition().adding(0,-1));
        }

        if(board.isInBoard(this.getPosition().adding(1,0))) {
            possibleMovements.add(this.getPosition().adding(1,0));
        }

        if(board.isInBoard(this.getPosition().adding(-1,0))) {
            possibleMovements.add(this.getPosition().adding(-1,0));
        }

        if(board.isInBoard(this.getPosition().adding(-1,-1))) {
            possibleMovements.add(this.getPosition().adding(-1,-1));
        }

        if(board.isInBoard(this.getPosition().adding(-1,1))) {
            possibleMovements.add(this.getPosition().adding(-1,1));
        }

        if(board.isInBoard(this.getPosition().adding(1,-1))) {
            possibleMovements.add(this.getPosition().adding(1,-1));
        }

        return (Position[]) possibleMovements.toArray();
    }

}
