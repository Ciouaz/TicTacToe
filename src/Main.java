import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        String anotherGame = "yes";
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to TicTacToe game.\n");

        ChoosingOpponent choosingOpponent = new ChoosingOpponent();
        String[] opponent = choosingOpponent.ChoosingOpponent();

        while ("yes".equals(anotherGame)) {

            if (opponent[0].equals("Player1 ")) {
                System.out.println("Playing with other human.");
                new GameWithHuman(opponent);
            } else {
                System.out.println("Playing with computer.");
                new GameWithComputer(opponent);
            }

            System.out.println("\nAnother game? Type \"yes\" or \"no\"");
            anotherGame = scanner.next();

            while ((!"yes".equals(anotherGame) && (!"no".equals(anotherGame)))) {
                System.out.println("Wrong input");
                System.out.println("\nAnother game? Type \"yes\" or \"no\"");
                anotherGame = scanner.next();
            }
        }
        System.out.println("Understandable, have a nice day :)");
    }
}
