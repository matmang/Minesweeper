import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class MineFrame extends JFrame{
	private Board board;
	private int button_size = 50;
	private int size = 10;
	private MineButton[][] button;
	
	public MineFrame(int board_size, Board b) {
		size = board_size;
		board = b;
		button = new MineButton[size][size];
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(size, size));
		for(int i=0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				button[i][j] = new MineButton(board, this);
				cp.add(button[i][j]);
			}
		}
		
		update();
		setTitle("Slide Puzzle");
		setSize(size * button_size + 10, size * button_size + 10);
		setVisible(true);
		
	}
	
	public void update() {
		MineCell[][] r = board.answerboard();
		for(int i=0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(r[i][j].getNeighbor_count() == 9) {
					button[i][j].setBackground(Color.white);
					button[i][j].setText("※");
				}else {
					button[i][j].setBackground(Color.white);
					button[i][j].setText(""+r[i][j].getNeighbor_count());
				}
			}
		}
	}
}
