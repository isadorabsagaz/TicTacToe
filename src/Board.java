public class Board{

    private final char[][] board;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_YELLOW = "\u001B[33m";


    public Board() {
        this.board = new char[3][3];
    }

    public char[][] getBoard() {
        return board;
    }

    public char getPosition(int row, int col) {
        return board[row][col];
    }

    public void setPosition(int row, int col, char symbol) {
       board[row][col] = symbol;
    }

    public void initBoard() {
        int numbers = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = (char)('a' + numbers++);
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                //different colors for player and cpu
                char symbol = board[i][j];
                if (symbol == 'X') {
                    System.out.print(ANSI_PURPLE + symbol + ANSI_RESET);
                }
                else if (symbol == '0') {
                    System.out.print(ANSI_YELLOW + symbol + ANSI_RESET);
                }
                else {
                    System.out.print(symbol);
                }
                if (j < 2) System.out.print(" | ");

            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
        System.out.println();
    }
}
