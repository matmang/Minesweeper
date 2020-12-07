public class Board {
    private int size;
    private MineCell[][] board;

    public Board (int s) {
        size = s;
        board = new MineCell[size][size];
        
        for (int num = 1; num != size * size; num = num + 1) { 
        	MineCell p = new MineCell();
            int row = num / size;
            int col = num % size;
            board[row][col] = p;
        }
    }
    
    
    public MineCell[][] returnboard() { 
        MineCell[][] answer = new MineCell[size][size];
        for(int i = 0; i != size; i = i + 1)
        	for(int j = 0; j != size; j = j + 1)
        		answer[i][j] = board[i][j];
            return answer;
    }
}
