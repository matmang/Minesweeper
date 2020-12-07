import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MineButton extends JButton implements ActionListener{
	private Board puzzle;
	private MineFrame view;
	
	public MineButton(Board p, MineFrame v) {
		puzzle = p;
		view = v;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
