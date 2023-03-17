public class GameWithHuman {
    GameWithHuman() {


        WinningCheck winningCheck = new WinningCheck();
        String[][] nullBoard = new String[4][4];
        String win = winningCheck.winningCheck(nullBoard);

        while (!"X".equals(win) && !"O".equals(win)) {

            ChoosingOpponent choosingOpponent = new ChoosingOpponent();
            String[] opponent = choosingOpponent.ChoosingOpponent();

            Board board = new Board();

            Character side = new Character();
            String[] character = side.Character();


            board.PrintEmptyBoard();
            CharactersInsertion charactersInsertion = new CharactersInsertion();
            Integer[] position = charactersInsertion.CharactersInsertion(opponent[0]);
            nullBoard = board.gameBoard(position[0], position[1], character[0]);

            for (int i = 1; i < 9; i++) {

                win = winningCheck.winningCheck(nullBoard);

                if ("X".equals(win) || "O".equals(win)) {
                    System.out.println("End of game. " + opponent[1 - (i % 2)] + "with \"" + character[1 - (i % 2)] + "\" won!");
                    break;
                } else {

                    position = charactersInsertion.CharactersInsertion(opponent[i % 2]);

                    while (nullBoard[position[0]][position[1]] != null) {
                        System.out.println("Choose unoccupied coordinates");
                        position = charactersInsertion.CharactersInsertion(opponent[i % 2]);
                    }

                    if (i % 2 == 0) {
                        board.gameBoard(position[0], position[1], (character[0]));
                    } else {
                        board.gameBoard(position[0], position[1], character[1]);
                    }
                }
            }
            System.out.println("Draw");
            break;
        }
    }
}