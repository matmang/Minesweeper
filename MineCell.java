public class MineCell {
    private boolean ismine = false;
    private int neighbor_count = 0;
    private String face_value;
    
    public MineCell(String value){
        face_value = value;
    }
    
    public void setMine(boolean s) { ismine = s; }
    public boolean getMine() { return ismine; }
    public void setNeighbor_count(int n) { neighbor_count = n; }
    public int getNeighbor_count() { return neighbor_count; }
}