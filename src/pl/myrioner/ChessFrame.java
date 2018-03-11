package pl.myrioner;

import javax.swing.*;
import java.awt.*;

public class ChessFrame extends JFrame {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    public ChessFrame(BoardPanel boardPanel) {
        setTitle("ChessGame");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - WIDTH) / 2, (screenSize.height - HEIGHT) / 2, WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("ChessIcon.png").getImage());
        setVisible(true);

        add(boardPanel);
    }

    public static void main(String[] args) {
        BoardPanel boardPanel = new BoardPanel();
        new ChessFrame(boardPanel);
    }
}
