
public class Position {
    public static char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private int row;
    private int column;

    public Position(String coordinate) {
        for(int i = 0; i<ALPHABET.length; i++) {
            if(ALPHABET[i] == coordinate.substring(0,1).charAt(0)) this.row = i + 1;
        }
        this.column = Character.getNumericValue(coordinate.substring(1,2).charAt(0));
    }

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static boolean isValid(String coordinate) {
        if(coordinate.length() != 2) return false;
        if(!Character.isAlphabetic(coordinate.substring(0,1).charAt(0))) return false;
        if(!Character.isDigit(coordinate.substring(1,2).charAt(0))) return false;

        return true;
    }

    public char getRow() {
        return ALPHABET[row + 1];
    }

    public int getColumn() {
        return column;
    }

    public boolean equals(Position position) {
        if(position.getRow() != this.row) return false;
        if(position.getColumn() != this.column) return false;
        return true;
    }

    public Position adding(int rows, int columns) {
        return new Position(this.row + rows, this.column + columns);
    }

}
