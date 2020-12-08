import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MineFrame extends JFrame {

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
    ImageIcon icon_reset = new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\reset.png");
    ImageIcon logo = new ImageIcon("C:\\Users\\jysko\\IdeaProjects\\2주차 실습\\src\\images\\logo.png");

    JButton reset = new JButton();
    private Board board;
    private int button_size = 45;
    private int size = 10;
    private MineButton[][] button;
    private boolean[][] visit;
    JMenuBar mb = new JMenuBar();
    JMenu menu = new JMenu("메뉴");

    public MineFrame(int board_size, Board b) {
        super("지뢰찾기");
        setResizable(true);
        this.setIconImage(logo.getImage());
        size = board_size;
        board = b;
        button = new MineButton[size][size];
        visit = new boolean[size][size];
        JPanel minegame = new JPanel(new GridLayout(size, size));
        Container cp = getContentPane();
        JPanel p1 = new JPanel(new FlowLayout());

        menu.add(new JMenuItem("새로고침")).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { dispose();	new MineFrame(size,board);	} });
        menu.addSeparator();
        menu.add(new JMenuItem("1단계")).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {size = 9; dispose(); new MineFrame(size,new Board(9)); } });
        menu.add(new JMenuItem("2단계")).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {size = 16;	dispose();	new MineFrame(size,new Board(16)); } });
        menu.add(new JMenuItem("3단계")).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {size = 22;	dispose();	new MineFrame(size,new Board(22));} });
        menu.addSeparator();
        menu.add(new JMenuItem("종료")).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {System.exit(0);} });

        mb.add(menu);
        this.setJMenuBar(mb);
        this.setLayout(new BorderLayout());
        add(p1, "North");
        p1.add(reset);
        reset.setIcon(icon_reset);
        reset.setBorderPainted(false);
        reset.setContentAreaFilled(false);
        reset.setFocusPainted(false);
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "단계를 리셋합니다.");
                dispose();
                new MineFrame(size ,new Board(size));
            }
        });
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                button[i][j] = new MineButton(board, this);
                minegame.add(button[i][j]);
                visit[i][j] = false;
            }
        }
        setVisible(true);
        setResizable(true);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cp.setLayout(new BorderLayout());

        cp.add(p1, BorderLayout.NORTH);
        cp.add(minegame, BorderLayout.CENTER);

        update();
        setSize(size * button_size + 10, size * button_size + 30);
        setVisible(true);
    }

    private void update() {
        MineCell[][] r = board.answerboard();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                button[i][j].setIcon(icon_empty);
                button[i][j].setMineCell(r[i][j]);
                button[i][j].setBackground(Color.BLACK);
            }
        }
    }

    public void open(int i, int j) {

        Queue<Integer> x_list = new LinkedList<>();
        Queue<Integer> y_list = new LinkedList<>();
        y_list.offer(i);
        x_list.offer(j);
        int[] x = { -1, 0, 1, 1, 1, 0, -1, -1 };
        int[] y = { -1, -1, -1, 0, 1, 1, 1, 0 };
        MineCell[][] r = board.answerboard();

        while (!x_list.isEmpty()) {
            int xx = x_list.poll();
            int yy = y_list.poll();
            button[yy][xx].setIcon(icon[r[yy][xx].getNeighbor_count()]);
            button[yy][xx].setBackground(Color.WHITE);
            r[yy][xx].set_click(true);
            if (r[yy][xx].getNeighbor_count() == 0) {
                for (int k = 0; k < 8; k++) {
                    int X = xx + x[k];
                    int Y = yy + y[k];
                    if (0 <= Y && X < size && 0 <= X && Y < size && !visit[Y][X]) {
                        y_list.offer(Y);
                        x_list.offer(X);
                        visit[Y][X] = true;
                    }
                }
            }
        }
    }

    public void mineopen() {
        MineCell[][] r = board.answerboard();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(r[i][j].getMine()) {
                    button[i][j].setBackground(Color.WHITE);
                    button[i][j].setIcon(icon_mine);
                    r[i][j].set_click(true);
                }
            }
        }
    }

    public boolean open_check() {
        MineCell[][] r = board.answerboard();
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(r[i][j].getclick()) {
                    cnt++;
                }
            }
        }
        return board.getopen() == cnt;
    }
}
