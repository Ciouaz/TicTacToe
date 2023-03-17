import java.util.Arrays;
public class WinningCheck {


    public String winningCheck(String[][] board) {

        String win = "";
        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    win = board[1][1] + board[2][2] + board[3][3];
                    break;
                case 1:
                    win = board[3][1] + board[2][2] + board[1][3];
                    break;
                case 2:
                    win = board[1][1] + board[1][2] + board[1][3];
                    break;
                case 3:
                    win = board[2][1] + board[2][2] + board[2][3];
                    break;
                case 4:
                    win = board[3][1] + board[3][2] + board[3][3];
                    break;
                case 5:
                    win = board[1][1] + board[2][1] + board[3][1];
                    break;
                case 6:
                    win = board[1][2] + board[2][2] + board[3][2];
                    break;
                case 7:
                    win = board[1][3] + board[2][3] + board[3][3];
                    break;
            }
            if (win.equals("XXX")) {
                return "X";
            } else if (win.equals("OOO")) {
                return "O";
            }
        }
    return "";
    }
}

