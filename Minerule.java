public class Minerule {

    private int ROW;
    private int COL;
    private int MINE_CNT;
    private String MINE = "*";
    private String NONE = "x";
    private String mineBoard[][];

    private int[] x = {-1, 0, 1, 1, 1, 0, -1, -1};
    private int[] y = {-1, -1, -1, 0, 1, 1, 1, 0};
    
    public Minerule(int row, int col){
        ROW = row;
        COL = col;
        mineBoard = new String[ROW][COL];
    }

    private boolean isExistMine(int row, int col){
        if(row < 0 || row >= ROW || col < 0 || col >= COL){
            return false;
        }
        return mineBoard[row][col].equals(MINE);
    }

    private int getMineNumber(int row, int col){
        int mineCnt = 0;
        
        for(int i = 0; i < 8; i++){
            if(isExistMine(row+x[i], col+y[i]))mineCnt++;    
        }
        return mineCnt;
    }

    private void setNumber(int row, int col){
        if(mineBoard[row][col].equals(NONE) && getMineNumber(row,col) != 0){
            mineBoard[row][col] = ""+getMineNumber(row,col)+"";
        }
    }
}
