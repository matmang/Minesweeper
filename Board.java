public class Board {
    private int size;
    private Piece[][] board;

    public Board (int s) {
        size = s;
        board = new Piece[size][size];

        for (int num = 1; num != size * size; num = num + 1) { 
            Piece p = new Piece();
            int row = num / size;
            int col = num % size;
            board[row][col] = p;
    }
        public Piece[][] returnPiece() { 
            Piece[][] answer = new Piece[size][size];
            for(int i = 0; i != size; i = i + 1) 
                for(int j = 0; j != size; j = j + 1)
                    answer[i][j] = board[i][j];
        }
    }
}
public class Piece {


    public Piece() {

    }
}