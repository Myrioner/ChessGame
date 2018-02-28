package pl.myrioner;

public abstract class Piece {
    public enum Color {
        BLACK, WHITE
    }

    private Color color;
    private String name;

    public Piece(Color color, String name) {
        this.color = color;
        this.name = name;
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