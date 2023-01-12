import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = 1;

            int [][] board = new int[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < 9; i++) {
                int row = 0;
                int col = 0;
                for (int j = 0; j < 9; j++) {
                    row += board[i][j];
                    col += board[j][i];
                }
                if (row != 45 || col != 45) {
                    answer = 0;
                    break;
                }
            }

            if (answer == 0) {
                System.out.println("#" + test_case + " 0");
                continue;
            }

            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 3; j++) {
                    int sum = 0;
                    for (int x = 0; x < 3; x++) {
                        for (int y = 0; y < 3; y++) {
                            sum += board[y][x];
                        }
                    }
                    if (sum != 45) {
                        answer = 0;
                        break;
                    }
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}