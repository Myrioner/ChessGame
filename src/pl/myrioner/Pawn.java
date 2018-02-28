package pl.myrioner;

public class Pawn extends Piece {
    private boolean moved;

    public Pawn(Color color, int number) {
        super(color, color.toString() + " PAWN" + number);
        moved = false;
    }

    @Override
    public void move(Field field) {
        if(moved) {

        }

    }
}