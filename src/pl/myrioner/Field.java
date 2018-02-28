package pl.myrioner;

public class Field {
    public enum Color {
        BLACK, WHITE
    }

    private int x, y;
    private Color color;
    private Piece piece;
    private String name;

    public Field(int x, int y, Color color, Piece piece) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.piece = piece;
        this.name = Character.toString((char) (96 + y)) + x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return name + " " + color.toString() + " ";
    }
}