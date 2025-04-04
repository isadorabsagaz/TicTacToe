import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        Board board = new Board();
        board.initBoard();

        Player player = new Player('X');
        CPU cpu = new CPU('0');
        Game game = new Game(board, player, cpu);

        System.out.println("Welcome to TicTacToe! You are " + player.playerSymbol()+"\n");

        while (true) {
            board.printBoard();

            System.out.print("Type the letter of the position you will play: ");
            char position = input.next().charAt(0);

            game.playerMove(position);

            if(game.checkWin(board.getBoard(), player.playerSymbol())) {
                board.printBoard();
                System.out.println("Congratulations! You won!");
                break;
            }

            if(game.isBoardFull(board.getBoard())) {
                board.printBoard();
                System.out.println("Oh, it's a draw");
                break;
            }

            game.cpuMove();

            if(game.checkWin(board.getBoard(), cpu.CPUSymbol())){
                board.printBoard();
                System.out.println("Ma bad! CPU won!");
                break;
            }

            if(game.isBoardFull(board.getBoard())) {
                board.printBoard();
                System.out.println("Oh, it's a draw");
                break;
            }
        }
    }
}