import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MineStarter {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int SIZE = 9;
        int d = 3;
        String message;

        Board b = new Board(SIZE);
        new MineFrame(SIZE, b);

    }
}