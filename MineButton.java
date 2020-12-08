import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class MineButton extends JButton implements ActionListener{
    private ImageIcon[] icon = {
            new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\mine0.png"),
            new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\mine1.png"),
            new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\mine2.png"),
            new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\mine3.png"),
            new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\mine4.png"),
            new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\mine5.png"),
            new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\mine6.png"),
            new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\mine7.png"),
            new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\mine8.png")
    };

    ImageIcon icon_empty = new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\mine_empty.png");
    ImageIcon icon_mine = new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\mine.png");
    ImageIcon icon_flag = new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\flag.png");
    ImageIcon icon_flagx = new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\flagx.png");

    private Board puzzle;
    private MineFrame view;
    private MineCell cell;

    public MineButton(Board p, MineFrame v) {
        puzzle = p;
        view = v;
        addActionListener(this);
        addMouseListener(new ClickListener(this));
    }

    public void setMineCell(MineCell c) {
        cell = c;
    }

    public void actionPerformed(ActionEvent e) {
        if(!cell.getflag()){
            if(cell.getMine()) {
                setIcon(icon_mine);
            }else {
                setIcon(icon[cell.getNeighbor_count()]);
            }
            cell.set_click(true);
            setBackground(Color.WHITE);
            if(cell.getopen())
                view.open(cell.gety(), cell.getx());
            if(getIcon().equals(icon_mine)) {
                view.mineopen();
                JOptionPane.showMessageDialog(null, "이걸 틀리네");
            }
            if(view.open_check()) {
                JOptionPane.showMessageDialog(null, "이걸깨네");
            }
        }
    }



    public void set_flag(boolean b) {
        cell.set_flag(b);
    }
}
