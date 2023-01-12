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
            int N = sc.nextInt();
            int[][] board = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            System.out.println("#" + test_case);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.printf("%d", board[N-1-j][i]);
                }
                System.out.printf(" ");
                for (int j = 0; j < N; j++) {
                    System.out.printf("%d", board[N-1-i][N-1-j]);
                }
                System.out.printf(" ");
                for (int j = 0; j < N; j++) {
                    System.out.printf("%d", board[j][N-1-i]);
                }
                System.out.println();
            }
        }
    }
}