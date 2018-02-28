package pl.myrioner;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BoardPanel extends JPanel {
    private Board board;

    public BoardPanel() {
        GridLayout gridLayout = new GridLayout(Board.NUMBER_OF_FIELDS, Board.NUMBER_OF_FIELDS);
        setLayout(gridLayout);

        board = new Board();
        for (int i = 0; i < Board.NUMBER_OF_FIELDS; i++) {
            for (int j = 0; j < Board.NUMBER_OF_FIELDS; j++) {
                add(new BoardField());

            }
        }
    }

    private class BoardField extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            BufferedImage bufferedImage = null;
            try {
                bufferedImage = ImageIO.read(new File("black_field.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g2.drawImage(bufferedImage, 0,0,null);
            repaint();
        }
    }
}
