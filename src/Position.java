
public class Position {
    private String coordinate;

    public Position(String coordinate) {
        this.coordinate = coordinate;
    }

    public static boolean isValid(String coordinate) {
        if(coordinate.length() != 2) return false;
        if(!Character.isAlphabetic(coordinate.substring(0,1).charAt(0))) return false;
        if(!Character.isDigit(coordinate.substring(1,2).charAt(0))) return false;

        return true;
    }

    public char getRow() {
        return this.coordinate.substring(0,1).charAt(0);
    }

    public int getColumn() {
        return Character.getNumericValue(this.coordinate.substring(1,2).charAt(0));
    }

    public boolean equals(Position position) {
        return coordinate.equals(position.coordinate);
    }
}
