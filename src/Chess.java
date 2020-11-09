import java.util.Arrays;

class Chess {

    private Color turnColor;
    private Player[] players;
    private Board board;

    public Chess() {
        board = new Board();
        players = new Player[]{new Player(Color.WHITE, board), new Player(Color.BLACK, board)};
    }

    public void play() {
        turnColor = Color.WHITE;
        board.show();
        do {
            Player player = Arrays.stream(players).filter(p -> p.getColor() == turnColor).findFirst().get();
            player.move();
            board.show();
            turnColor = turnColor == Color.WHITE ? Color.BLACK : Color.WHITE;
        } while (board.hasKing(Color.WHITE) && board.hasKing(Color.BLACK));

        new Console().out("Player " + (board.hasKing(Color.WHITE) ? "white" : "black") + " has won!");
    }

    public static void main(String[] args) {
        new Chess().play();
    }
}
