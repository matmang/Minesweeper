import java.util.Random;

public class Board {
    private int size;
    private int mine_cnt;
    private MineCell[][] board;

    public Board(int s) {
        size = s;
        if (s == 9) {
            mine_cnt = 10;
        } else if (s == 16) {
            mine_cnt = 40;
        } else if (s == 22) {
            mine_cnt = 90;
        }
        board = new MineCell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new MineCell(i, j);
            }
        }
        Laymine(board);
        minerule(board);
        openrule(board);
    }

    private void Laymine(MineCell[][] board) {
        Random ran = new Random();
        int cnt = mine_cnt;
        while (cnt > 0) {
            int row = ran.nextInt(size);
            int col = ran.nextInt(size);
            if (!board[row][col].getMine()) {
                cnt--;
                board[row][col].setMine(true);
            }
        }
    }

    public MineCell[][] answerboard() {
        MineCell[][] answer = new MineCell[size][size];
        for (int i = 0; i != size; i = i + 1)
            for (int j = 0; j != size; j = j + 1)
                answer[i][j] = board[i][j];
        return answer;
    }

    private void minerule(MineCell[][] c) {
        int mine = 0;
        int[] x = {-1, 0, 1, 1, 1, 0, -1, -1};
        int[] y = {-1, -1, -1, 0, 1, 1, 1, 0};
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mine = 0;
                for (int k = 0; k < 8; k++) {
                    if (0 <= i + y[k] && i + y[k] < size && 0 <= j + x[k] && j + x[k] < size
                            && c[i + y[k]][j + x[k]].getMine())
                        mine++;
                }
                if (!c[i][j].getMine())
                    c[i][j].setNeighbor_count(mine);
            }
        }
    }

    private void openrule(MineCell[][] c) {
        int[] x = {-1, 0, 1, 1, 1, 0, -1, -1};
        int[] y = {-1, -1, -1, 0, 1, 1, 1, 0};
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (c[i][j].getNeighbor_count() == 0) {
                    c[i][j].set_open(true);
                    for (int k = 0; k < 8; k++)
                        if (0 <= i + y[k] && i + y[k] < size && 0 <= j + x[k] && j + x[k] < size
                                && c[i + y[k]][j + x[k]].getNeighbor_count() != 9 && !c[i + y[k]][j + x[k]].getopen())
                            c[i + y[k]][j + x[k]].set_open(true);
                }
            }
        }
    }

    public int getopen() {
        return size*size - mine_cnt;
    }
}
