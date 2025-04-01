import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        Board board = new Board();
        board.initBoard();

        System.out.print("Type the symbol you want to play: ");
        char symbol = input.next().charAt(0);
        Player player = new Player(symbol);

        Game game = new Game(board, player);

        while (true) {
            board.printBoard();

            System.out.print("Type the letter of the position you will play: ");
            char position = input.next().charAt(0);
            game.playerMove(position);

            if(game.checkWin()) {
                board.printBoard();
                System.out.println("Congratulations! You won!");
                break;
            }

            if(game.isBoardFull()) {
                board.printBoard();
                System.out.println("Oh, it's a draw");
                break;
            }
        }
    }
}