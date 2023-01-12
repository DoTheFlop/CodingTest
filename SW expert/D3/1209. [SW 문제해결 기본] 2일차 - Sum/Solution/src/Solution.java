import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = sc.nextInt();
            int[][] board = new int[100][100];

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int answer = 0;

            for (int i = 0; i < 100; i++) {
                int row = 0;
                int col = 0;

                for (int j = 0; j < 100; j++) {
                    row += board[i][j];
                    col += board[j][i];
                }

                answer = Math.max(answer, Math.max(row, col));
            }

            int leftDig = 0;
            int rightDig = 0;

            for (int i = 0; i < 100; i++) {
                leftDig += board[i][i];
                rightDig += board[99 - i][i];
            }
            answer = Math.max(answer, Math.max(leftDig, rightDig));

            System.out.println("#" + test_case + " " + answer);
        }
    }
}