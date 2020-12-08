import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class ClickListener extends JButton implements MouseListener {
    ImageIcon icon_flag = new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\flag.png");
    ImageIcon icon_empty = new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\mine_empty.png");
    private MineButton button;

    public ClickListener(MineButton b){
        button = b;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getModifiersEx() == InputEvent.BUTTON3_DOWN_MASK){
            if(button.getBackground() == Color.BLACK) {
                button.setIcon(icon_flag);
                button.setBackground(Color.GRAY);
                button.set_flag(true);
            }
            else if(button.getBackground() == Color.GRAY){
                button.setIcon(icon_empty);
                button.setBackground(Color.BLACK);
                button.set_flag(false);
            }
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}