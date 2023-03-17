import java.util.Scanner;

public class ChoosingOpponent {
    public String[] ChoosingOpponent() {

        String opponent1 = null;
        String opponent2 = null;

        while (!("Computer ".equals(opponent2) || "Player2 ".equals(opponent2))) {
            System.out.println("Do you want to play with computer, or with other player?\nType \"c\" or \"p\"");
            Scanner scanner = new Scanner(System.in);
            opponent1 = scanner.next();
            if (opponent1.toLowerCase().equals("c")) {
                opponent1 = "Human ";
                opponent2 = "Computer ";
            } else if (opponent1.toLowerCase().equals("p")) {
                opponent1 = "Player1 ";
                opponent2 = "Player2 ";
            } else {
                System.out.println("You write wrong letter");
            }
        }
        return new String[]{opponent1, opponent2};
    }
}