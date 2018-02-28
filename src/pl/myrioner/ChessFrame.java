package pl.myrioner;

import javax.swing.*;
import java.awt.*;

public class ChessFrame extends JFrame {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    public ChessFrame() {
        setTitle("ChessGame");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - WIDTH) / 2, (screenSize.height - HEIGHT) / 2, WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        add(new BoardPanel());

    }

    public static void main(String[] args) {
        new ChessFrame();
    }
}
