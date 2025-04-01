public class Game extends Board {

    private final Board board;
    private final Player player;
    private CPU cpu;

    public Game(Board board, Player player) {
        this.board = board;
        this.player = player;
        this.cpu = cpu;
    }

    public void playerMove(char position) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (position == board.getSymbolInPosition(i, j)) {
                    board.setSymbolInPosition(i, j, player.playerSymbol());
                    return;
                }
            }
        }
    }

    public void cpuMove() {

    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            //same line, row
            if (board.isVisited(i, 0) && board.isVisited(i, 1) && board.isVisited(i, 2)) return true;
            //same column
            if (board.isVisited(0, i) && board.isVisited(1, i) && board.isVisited(2, i)) return true;
        }
        //diagonals
        if (board.isVisited(0, 0) && board.isVisited(1, 1) && board.isVisited(2, 2)) return true;
        return board.isVisited(0, 2) && board.isVisited(1, 1) && board.isVisited(2, 0);
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSymbolInPosition(i, j) != player.playerSymbol()) return false;
            }
        }
        return true;
    }
}
