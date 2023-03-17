import java.util.Scanner;
public class Character {
    public String[] Character() {

        String fstChar = null;
        String sndChar = null;

        while (!("X".equals(fstChar) || "X".equals(sndChar))) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Which character starts? Type \"X\" or \"O\"");

            fstChar = scanner.next();

            if (fstChar.equals("X") || fstChar.equals("x")) {
                sndChar = "O";
                fstChar = "X";
            } else if (fstChar.equals("O") || fstChar.equals("o") || fstChar.equals("0")) {
                sndChar = "X";
                fstChar = "O";
            } else {
                System.out.println("You type wrong character");
            }
        }
        return new String[]{fstChar, sndChar};
    }
}
