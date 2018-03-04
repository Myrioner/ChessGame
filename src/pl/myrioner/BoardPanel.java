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
                if(board.getField(i, j).getColor().equals(Field.Color.WHITE))
                    add(new BoardField("white_field.png"));
                else
                    add(new BoardField("black_field.png"));
            }
        }
    }

    private class BoardField extends JComponent {
        String path;

        public BoardField(String path) {
            this.path = path;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            BufferedImage bufferedImage = null;

            try {
                bufferedImage = ImageIO.read(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g2.drawImage(bufferedImage, 0,0, this.getSize().width,
                    this.getSize().height,null);
            repaint();
        }
    }
}
