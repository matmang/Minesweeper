public class Minerule {

    private int ROW;
    private int COL;
    private int MINE_CNT;
    private String MINE = "*";
    private String NONE = "x";
    private String mineBoard[][];

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
        if(isExistMine(row-1, col-1))mineCnt++;
        if(isExistMine(row-1, col))mineCnt++;
        if(isExistMine(row-1, col+1))mineCnt++;
        if(isExistMine(row, col-1))mineCnt++;
        if(isExistMine(row, col+1))mineCnt++;
        if(isExistMine(row+1, col-1))mineCnt++;
        if(isExistMine(row+1, col))mineCnt++;
        if(isExistMine(row+1, col+1))mineCnt++;

        return mineCnt;
    }

    private void setNumber(int row, int col){
        if(mineBoard[row][col].equals(NONE) && getMineNumber(row,col) != 0){
            mineBoard[row][col] = ""+getMineNumber(row,col)+"";
        }
    }
}