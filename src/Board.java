import java.util.Arrays;

public class Board extends EmptyBoard{

    String[][] board = {{" ", "a", "b", "c"}, {"1", null, null, null}, {"2", null, null, null}, {"3", null, null, null}};
    String[][] replacements = {{"[[", " "}, {"]]", " "}, {"],", "\n"}, {"[", ""}, {"null", "-"}, {",", ""}};

    @Override
    public String[][] gameBoard(int row, int column, String character) {

    board[row][column] = character;
    String boardRep = Arrays.deepToString(board);

    for (String[] replacement : replacements) {
            boardRep = boardRep.replace(replacement[0], replacement[1]);
        }
        System.out.println(boardRep + "\n");
    return board;
    }

}
