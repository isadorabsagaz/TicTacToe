public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        Player player = new Player('X');
        Game game = new Game(board, player);

        board.initBoard();
        board.printBoard();
        game.playerMove('C');
        game.playerMove('E');
        game.playerMove('G');
    }
}