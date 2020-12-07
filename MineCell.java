
public class MineCell {
    private boolean ismine = false;
    private int neighbor_count = 0; // 주의의 지뢰의 개수를 저장하는 변수, 9이면 지뢰로 간주
    private String face_value; // 
    
    
    public MineCell(String s) {
		// TODO Auto-generated constructor stub
    	face_value = s;
	}

	public void setMine(boolean s) { 
		ismine = s;
		neighbor_count = 9;
	}
    public boolean getMine() { return ismine; }
    public void setNeighbor_count(int n) { neighbor_count = n; }
    public int getNeighbor_count() { return neighbor_count; }
    public boolean getflag() { return face_value == "#"; } // 만약 플래스가 세워져있으면 true, 아니면 false;
}
