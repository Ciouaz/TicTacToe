import java.util.Arrays;
public abstract class EmptyBoard {
    int rowIndex;
    int columnIndex;

    EmptyBoard() {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public void PrintEmptyBoard(){

        System.out.println("Empty board: ");
        String[][] emptyBoard = {{" ", "a", "b", "c"}, {"1", "-", "-", "-"}, {"2", "-", "-", "-"}, {"3", "-", "-", "-"}};
        String[][] replacements = {{"[[", " "}, {"]]", " "}, {"],", "\n"},{"[", ""}, {",", ""}};

        String emptyGameBoard = Arrays.deepToString(emptyBoard);

        for (String[] replacement : replacements) {
            emptyGameBoard = emptyGameBoard.replace(replacement[0], replacement[1]);
        }
        System.out.println(emptyGameBoard + "\n");
    }

    abstract String[][] gameBoard(int rowIndex, int columnIndex, String character);
}

