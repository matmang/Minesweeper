public class Board {
    private int size;
    private int mine_cnt;
    private MineCell[][] board;

    public Board (int s) {
        size = s;
        if(s == 9) {
        	mine_cnt = 10;
        }else if(s == 16) {
        	mine_cnt = 40;
        }else if(s == 22) {
        	mine_cnt = 90;
        }
        board = new MineCell[size][size];
        
        
        for(int i = 0; i != size; i = i + 1) {
        	for(int j = 0; j != size; j = j + 1) {
        		answer[i][j] = board[i][j];
        	}
        }
        
    }
    
    
    public MineCell[][] answerboard() {
        MineCell[][] answer = new MineCell[size][size];
        for(int i = 0; i != size; i = i + 1)
        	for(int j = 0; j != size; j = j + 1)
        		answer[i][j] = board[i][j];
        return answer;
    }
    
    public MineCell[][] gameboard(){
    	
    }
}
