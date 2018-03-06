package pl.myrioner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class BoardPanel extends JPanel {
    private Board board;

    public BoardPanel() {
        GridLayout gridLayout = new GridLayout(Board.NUMBER_OF_FIELDS, Board.NUMBER_OF_FIELDS);
        setLayout(gridLayout);

        board = new Board();
        for (int i = 0; i < Board.NUMBER_OF_FIELDS; i++) {
            for (int j = 0; j < Board.NUMBER_OF_FIELDS; j++) {
                if(board.getField(i, j).getColor().equals(Field.Color.WHITE))
                    add(new BoardField(board.getField(i,j)));

                else
                    add(new BoardField(board.getField(i,j)));
                //if (i == 2)
                    //add(new PawnField(new Pawn(Piece.Color.BLACK, 5, board.getField(i,j))));

            }
        }
    }

    private class PawnField extends JComponent {
        Pawn pawn;

        public PawnField(Pawn pawn) {
            this.pawn = pawn;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            BufferedImage bufferedImage = pawn.getImage();

            g2.drawImage(bufferedImage, 0,0, this.getSize().width,
                    this.getSize().height,null);
            repaint();
        }
    }

    private class BoardField extends JComponent {
        Field field;

        public BoardField(Field field) {
            this.field = field;

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    System.out.println(field);
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            BufferedImage bufferedImage = field.getImage();

            g2.drawImage(bufferedImage, 0,0, this.getSize().width,
                    this.getSize().height,null);
            repaint();
        }
    }
}
