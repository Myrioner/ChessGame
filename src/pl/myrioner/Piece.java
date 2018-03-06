package pl.myrioner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Piece {
    public enum Color {
        BLACK, WHITE
    }

    private Color color;
    private String name;

    protected BufferedImage image;
    protected Field field;

    public Piece(Color color, String name) {
        this.color = color;
        this.name = name;
        this.field = field;
    }

    protected void loadImage(String s) throws IOException {
        image = ImageIO.read(new File(s));
    }


    public abstract void move(Field field);

    protected boolean checkIfOutOfBoard(Field field, int x, int y) {
        return true;        // TO DO OR NOT TO DO!
    }

    protected boolean checkIfFieldEmpty(Field field) {
        return field == null;
    }

    protected boolean checkIfYourPiece(Piece piece) {
        return piece.color.equals(this.color);
    }
}