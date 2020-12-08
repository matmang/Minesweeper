public class MineCell {
    private boolean ismine = false; // 지뢰 여부
    private boolean open = false; // 한번에 까지는 칸 여부
    private boolean flag = false; // 플래그 여부
    private boolean click = false; // 클릭 여부
    private int neighbor_count = 0; // 주의의 지뢰의 개수를 저장하는 변수, 9이면 지뢰로 간주
    private int x=0;
    private int y=0;

    public MineCell(int i, int j) {
        // TODO Auto-generated constructor stub
        x = j;
        y = i;
    }

    public void setMine(boolean s) {
        ismine = s;
        neighbor_count = 9;
    }
    public void set_open(boolean b) {open = b; }
    public void set_click(boolean b) {click = b; }
    public void set_flag(boolean b) {flag = b; }
    public void set_xy(int i, int j) { x = j; y = i; }
    public void setNeighbor_count(int n) { neighbor_count = n; }
    public int getNeighbor_count() { return neighbor_count; }
    public int getx() { return x; }
    public int gety() { return y; }
    public boolean getMine() { return ismine; }
    public boolean getclick() { return click; }
    public boolean getflag() { return flag; }
    public boolean getopen() { return open; }// 만약 플래스가 세워져있으면 true, 아니면 false;
    public boolean getclear() { return flag == ismine; }
}
