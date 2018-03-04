package pl.myrioner;

public class Board {
    public static final int NUMBER_OF_FIELDS = 8;
    private Field[][] board;

    public Board() {
        board = new Field[NUMBER_OF_FIELDS][NUMBER_OF_FIELDS];

        for (int i = 0; i < NUMBER_OF_FIELDS; i++)
            for (int j = 0; j < NUMBER_OF_FIELDS; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0)
                        board[i][j] = new Field(NUMBER_OF_FIELDS - i, j + 1, Field.Color.WHITE, null);
                    else
                        board[i][j] = new Field(NUMBER_OF_FIELDS - i, j + 1, Field.Color.BLACK, null);
                }
                else {
                    if (j % 2 != 0)
                        board[i][j] = new Field(NUMBER_OF_FIELDS - i, j + 1, Field.Color.WHITE, null);
                    else
                        board[i][j] = new Field(NUMBER_OF_FIELDS - i, j + 1, Field.Color.BLACK, null);

                }
            }
    }

    public void Show() {
        for (int i = 0; i < NUMBER_OF_FIELDS ; i++) {
            for (int j = 0; j < NUMBER_OF_FIELDS; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }
    }

    Field getField(int i, int j) {
        return board[i][j];
    }
}
