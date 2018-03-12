package pl.myrioner;

import pl.myrioner.parts.Pawn;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
                    add(new BoardField(board.getField(i,j)));
                else
                    add(new BoardField(board.getField(i,j)));

                if(i == 1 && j == 2)
                    board.getField(i,j).setPiece(new Pawn(Piece.Color.BLACK, 1,board.getField(i,j)));

                //if (i == 2)
                    //add(new PawnField(new Pawn(Piece.Color.BLACK, 5, board.getField(i,j))));

            }
        }

        addMouseListener(new MouseAdapter() {
            private BoardField boardField;
            private Piece piece;

            @Override
            public void mousePressed(MouseEvent e) {
                boardField = (BoardField) e.getComponent().getComponentAt(e.getPoint());
                if(piece == null && boardField.field.getPiece() != null) {
                    piece = boardField.field.getPiece();
                    boardField.field.setPiece(null);
                }
                else if(piece != null && boardField.field.getPiece() == null) {
                    boardField.field.setPiece(piece);
                    piece = null;
                }
            }
        });
    }

    private class BoardField extends JComponent {
        Field field;

        public BoardField(Field field) {
            this.field = field;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            BufferedImage bufferedImage = field.getImage();

            g2.drawImage(bufferedImage, 0,0, this.getSize().width,
                    this.getSize().height,null);

            // Próbne wyświetlenie pionków
            if(field.getPiece() != null) {
                try {
                    g2.drawImage(ImageIO.read(new File("ChessIcon.png")), 0,0, this.getSize().width,
                            this.getSize().height,null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            repaint();
        }
    }
}
