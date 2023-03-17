import java.util.Scanner;

public class CharactersInsertion {
    public Integer[] CharactersInsertion(String opponent, String character) {
        int columnLoc = 10;
        int rowLoc;
        Scanner scanner = new Scanner(System.in);


        System.out.println(opponent + "insert " + character + ".\nWrite COLUMN letter and ROW number separated by a SPACE (e.g. \"a 3\"): ");

        String columnSymbol = scanner.next();
        String rowSymbol = scanner.next();

        while (!(("1".equals(rowSymbol)) || ("2".equals(rowSymbol)) || ("3".equals(rowSymbol)))
                || !(("a".equals(columnSymbol)) || ("b".equals(columnSymbol)) || ("c".equals(columnSymbol)))) {
        System.out.println("Wrong coordinates.");
        System.out.println(opponent + "insert " + character + ".\nWrite COLUMN letter and ROW number separated by a SPACE (e.g. \"a 3\"): ");
        columnSymbol = scanner.next();
        rowSymbol = scanner.next();
                }

            switch (columnSymbol) {
                case "a":
                    columnLoc = 1;
                    break;
                case "b":
                    columnLoc = 2;
                    break;
                case "c":
                    columnLoc = 3;
                    break;
            }

        rowLoc = Integer.valueOf(rowSymbol);

        Integer[] position = {rowLoc, columnLoc};
        return position;
        }
    }


