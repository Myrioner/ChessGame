package pl.myrioner;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Field {
    public enum Color {
        BLACK, WHITE
    }

    private int x, y;
    private Color color;
    private Piece piece;
    private String name;
    private BufferedImage image;

    public Field(int x, int y, Color color, Piece piece) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.piece = piece;
        this.name = Character.toString((char) (96 + y)) + x;

        try {
            if (color == Color.BLACK)
                loadImage("black_field.png");
            else
                loadImage("white_field.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadImage(String s) throws IOException {
        image = ImageIO.read(new File(s));
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return name + " " + color.toString() + " ";
    }
}