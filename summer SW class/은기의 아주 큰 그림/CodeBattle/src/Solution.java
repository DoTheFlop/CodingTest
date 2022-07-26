import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

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
            int H = sc.nextInt();
            int W = sc.nextInt();

            char[][] picA = new char[H][W];

            int N = sc.nextInt();
            int M = sc.nextInt();
            char[][] picB = new char[N][M];
            sc.nextLine();

            int result = 0;

            for (int i = 0; i < H; i++) {
                String str = sc.nextLine();
                picA[i] = str.toCharArray();
            }

            for (int i = 0; i < N; i++) {
                String str = sc.nextLine();
                picB[i] = str.toCharArray();
            }

            char[][] temp = new char[H][W];
            for (int b = 0; b <= N - H; b++) {
                for (int a = 0; a <= M - W; a++) {
                    for (int i = b; i < H; i++) {
                        for (int j = a; j < a+W; j++) {
                            temp[i][j] = picB[i][j];
                        }
                    }
                    if (Arrays.equals(temp, picA)) {
                        result++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + result);

        }
    }
}