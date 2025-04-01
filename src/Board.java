public class Board{

    private final char[][] board;
    private final boolean[][] visited;

    public Board() {
        this.board = new char[3][3];
        this.visited = new boolean[3][3];
    }

    public char getSymbolInPosition(int row, int col) {
        return board[row][col];
    }

    public void setSymbolInPosition(int row, int col, char symbol) {
       board[row][col] = symbol;
       visited[row][col] = true;
    }

    public boolean isVisited(int row, int col) {
        return visited[row][col];
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
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");

            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
        System.out.println();
    }
}
