public class Game extends Board {

    private final Board board;
    private final Player player;
    private final CPU cpu;

    public Game(Board board, Player player, CPU cpu) {
        this.board = board;
        this.player = player;
        this.cpu = cpu;
    }

    public void playerMove(char position) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (position == board.getPosition(i, j)) {
                    board.setPosition(i, j, player.playerSymbol());
                    return;
                }
            }
        }
    }

    public void cpuMove() {
        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1, bestCol = -1;
        int numbers = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getPosition(i, j) != player.playerSymbol() && board.getPosition(i, j) != cpu.CPUSymbol()) {//if position is null ' '

                    board.setPosition(i, j, cpu.CPUSymbol());
                    int score = dfsSearch(board.getBoard(), false);
                    board.setPosition(i, j,  (char)('a' + numbers++));

                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = i;
                        bestCol = j;
                    }
                }
            }
        }
        if (bestRow != -1 && bestCol != -1) {
            board.setPosition(bestRow, bestCol, cpu.CPUSymbol());
            System.out.println("CPU played at [" + bestRow + "][" + bestCol + "]");
        }
    }

    //depth-first search
    private int dfsSearch(char[][] state, boolean cpuTurn) {
        if (checkWin(state, cpu.CPUSymbol())) return 1;
        if (checkWin(state, player.playerSymbol())) return -1;
        if (isBoardFull(state)) return 0;

        int bestScore = cpuTurn ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int numbers = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] != player.playerSymbol() && state[i][j] != cpu.CPUSymbol()) { //if position is null ' '

                    state[i][j] = cpuTurn ? cpu.CPUSymbol() : player.playerSymbol();
                    int score = dfsSearch(state, !cpuTurn);
                    state[i][j] = (char)('a' + numbers++);

                    bestScore = cpuTurn ? Math.max(bestScore, score) : Math.min(bestScore, score);
                }
            }
        }
        return bestScore;
    }


    public boolean checkWin(char[][] state, char player) {
        for (int i = 0; i < 3; i++) {
            //same line, row
            if (state[i][0] == player
                    && state[i][1] == player
                    && state[i][2] == player) return true;
            //same column
            if (state[0][i] == player
                    && state[1][i] == player
                    && state[2][i] == player) return true;
        }
        //diagonals
        if (state[0][0] == player
                && state[1][1] == player
                && state[2][2] == player) return true;

        return state[0][2] == player
                && state[1][1] == player
                && state[2][0] == player;
    }

    public boolean isBoardFull(char[][] state) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] != player.playerSymbol() && state[i][j] != cpu.CPUSymbol()) return false;
            }
        }
        return true;
    }
}
