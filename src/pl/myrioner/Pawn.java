package pl.myrioner;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Pawn extends Piece {
    private boolean moved;

    public Pawn(Color color, int number, Field field) {
        super(color, color.toString() + " PAWN" + number, field);
        moved = false;

        try {
            if (color == Color.BLACK)
                loadImage("black_pawn.png");
            else
                loadImage("white_pawn.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage() {return image;}



    @Override
    public void move(Field destinationField) {
        //if(moved) {
            if (destinationField.getY() == field.getY() + 1 && destinationField.getX() == field.getX()) // UP
                field.setX(field.getX() + 1);
        //}
    }
}

