import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class GameWithComputer {
    GameWithComputer(String[] opponent) {

        Scanner scanner = new Scanner(System.in);

        WinningCheck winningCheck = new WinningCheck();
        String win;

        Board board = new Board();

//            System.out.println("Who starts the game? Type \"h\" for human or \"c\" for computer");
//        String whoStarts = scanner.next();
//
//        while(!("h".equals(whoStarts) || "c".equals(whoStarts))){
//            System.out.println("Wrong input.");
//            System.out.println("Who starts the game? Type \"h\" for human or \"c\" for computer");
//            whoStarts = scanner.next();
//        }
//        int a = 0;
//        if (whoStarts.equals("h")){
//            a = 1;
//            System.out.println("Computer starts");
//        } else {
//            System.out.println("You start");
//        }

        Character side = new Character();
        String[] character = side.Character();

        board.PrintEmptyBoard();
        CharactersInsertion charactersInsertion = new CharactersInsertion();
        Integer[] position = charactersInsertion.CharactersInsertion(opponent[0], character[0]);
        String[][] nullBoard = board.gameBoard(position[0], position[1], character[0]);

        for (int i = 1; i <= 9; i++) {

            win = winningCheck.winningCheck(nullBoard);

            if ("X".equals(win) || "O".equals(win)) {
                System.out.println("End of game. " + opponent[1 - (i % 2)] + "with \"" + character[1 - (i % 2)] + "\" won!");
                break;
            } else if (i == 9) {
                System.out.println("Draw");
                break;
            } else {

                if (i % 2 == 0) {
                    position = charactersInsertion.CharactersInsertion(opponent[i % 2], character[i % 2]);
                    while (nullBoard[position[0]][position[1]] != null) {
                        System.out.println("Choose unoccupied coordinates");
                        position = charactersInsertion.CharactersInsertion(opponent[i % 2], character[i % 2]);
                    }
                    board.gameBoard(position[0], position[1], (character[0]));
                } else {
                    Integer [] computerCoordinates = computerStrategy(nullBoard);
                    int compRow = computerCoordinates[0];
                    int compColumn = computerCoordinates[1];

                    while (nullBoard[compRow][compColumn] != null) {
                        computerCoordinates = computerStrategy(nullBoard);
                        compRow = computerCoordinates[0];
                        compColumn = computerCoordinates[1];
                    }
                        char compColumLetter = '0';
                        switch (compColumn) {
                            case 1:
                                compColumLetter = 'a';
                                break;
                            case 2:
                                compColumLetter = 'b';
                                break;
                            case 3:
                                compColumLetter = 'c';
                                break;
                        }
                        System.out.println("Computer with \"" + character[1] +"\" chosen: " + compColumLetter + " " + compRow);
                        board.gameBoard(compRow, compColumn, character[1]);
                    }
                }
            }
        }

    private int randomizer() {
        Random rand = new Random();
        int upperbound = 3;
        int random = 1 + rand.nextInt(upperbound);
        return random;
    }

    private Integer[] computerStrategy(String[][] board){
        Integer[] computerCoordinates;
        if ((board[1][1] + board[2][1]).equals("XX") || (board[1][1] + board[2][1]).equals("OO")){
            computerCoordinates = new Integer[]{3, 1};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[1][2] + board[2][2]).equals("XX") || (board[1][2] + board[2][2]).equals("OO")){
            computerCoordinates = new Integer[]{3, 2};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[1][3] + board[2][3]).equals("XX") || (board[1][3] + board[2][3]).equals("OO")){
            computerCoordinates = new Integer[]{3, 3};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[1][1] + board[3][1]).equals("XX") || (board[1][1] + board[3][1]).equals("OO")){
            computerCoordinates = new Integer[]{2, 1};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[1][2] + (board[3][2])).equals("XX") || (board[1][2] + (board[3][2])).equals("OO")){
            computerCoordinates = new Integer[]{2, 2};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[1][3] + board[3][3]).equals("XX") || (board[1][3] + board[3][3]).equals("OO")){
            computerCoordinates = new Integer[]{2, 3};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[2][1] + board[3][1]).equals("XX") || (board[2][1] + board[3][1]).equals("OO")){
            computerCoordinates = new Integer[]{1, 1};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[2][2] + board[3][2]).equals("XX") || (board[2][2] + board[3][2]).equals("OO")){
            computerCoordinates = new Integer[]{1, 2};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[3][3] + board[2][3]).equals("XX") || (board[3][3] + board[2][3]).equals("OO")){
            computerCoordinates = new Integer[]{1, 3};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[1][1] + board[1][2]).equals("XX") || (board[1][1] + board[1][2]).equals("OO")){
            computerCoordinates = new Integer[]{1, 3};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[2][1] + board[2][2]).equals("XX") || (board[2][1] + board[2][2]).equals("OO")){
            computerCoordinates = new Integer[]{2, 3};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[3][1] + board[3][2]).equals("XX") || (board[3][1] + board[3][2]).equals("OO")){
            computerCoordinates = new Integer[]{3, 3};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[1][1] + board[1][3]).equals("XX") || (board[1][1] + board[1][3]).equals("OO")){
            computerCoordinates = new Integer[]{1, 2};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[2][1] + board[2][3]).equals("XX") || (board[2][1] + board[2][3]).equals("OO")){
            computerCoordinates = new Integer[]{2, 2};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[3][1] + board[3][3]).equals("XX") || (board[3][1] + board[3][3]).equals("OO")){
            computerCoordinates = new Integer[]{3, 2};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[1][2] + board[1][3]).equals("XX") || (board[1][2] + board[1][3]).equals("OO")){
            computerCoordinates = new Integer[]{1, 1};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[2][2] + board[2][3]).equals("XX") || (board[2][2] + board[2][3]).equals("OO")){
            computerCoordinates = new Integer[]{2, 1};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[3][2] + board[3][3]).equals("XX") || (board[3][2] + board[3][3]).equals("OO")){
            computerCoordinates = new Integer[]{3, 1};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[3][3] + board[2][2]).equals("XX") || (board[3][3] + board[2][2]).equals("OO")){
            computerCoordinates = new Integer[]{1, 1};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[1][3] + board[2][2]).equals("XX") || (board[1][3] + board[2][2]).equals("OO")){
            computerCoordinates = new Integer[]{3, 1};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[1][1] + board[2][2]).equals("XX") || (board[1][1] + board[2][2]).equals("OO")){
            computerCoordinates = new Integer[]{3, 3};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[1][1] + board[3][3]).equals("XX") || (board[1][1] + board[3][3]).equals("OO")){
            computerCoordinates = new Integer[]{2, 2};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[1][3] + board[3][1]).equals("XX") || (board[1][3] + board[3][1]).equals("OO")){
            computerCoordinates = new Integer[]{2, 2};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[1][1] + board[2][2]).equals("XX") || (board[1][1] + board[2][2]).equals("OO")){
            computerCoordinates = new Integer[]{3, 3};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        } else if ((board[3][1] + board[2][2]).equals("XX") || (board[3][1] + board[2][2]).equals("OO")){
            computerCoordinates = new Integer[]{1, 3};
            if (board[computerCoordinates[0]][computerCoordinates[1]] == null){
                return computerCoordinates;
            }
        }
        computerCoordinates = new Integer[]{randomizer(), randomizer()};
        return computerCoordinates;
    }
}