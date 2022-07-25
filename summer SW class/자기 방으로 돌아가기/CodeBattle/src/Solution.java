import java.util.Collections;
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
            int[] roomOdd = new int[201];
            int[] roomEven = new int[201];
            int[] hallway = new int[201];
            int max = 0;

            for (int i = 0; i < N; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                if (to < from) {
                    int temp = from;
                    from = to;
                    to = temp;
                }

                for (int j = (from+1)/2; j <= (to+1)/2; j++) {
                    hallway[j]++;
                }
            }
            for (int i = 0; i < hallway.length; i++) {
                if (max < hallway[i]) {
                    max = hallway[i];
                }
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}