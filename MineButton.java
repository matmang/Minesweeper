import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MineButton extends JButton implements ActionListener{
	private Board puzzle;
	private MineFrame view;
	private MineCell cell;
	
	public MineButton(Board p, MineFrame v) {
		puzzle = p;
		view = v;
		addActionListener(this);
	}
	public void setMineCell(MineCell c) {
		cell = c;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(cell.getMine()) {
			setText("M");
		}else {
			setText("" + cell.getNeighbor_count());
		}
	}
}
