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
            int M = sc.nextInt();
            int[] num = new int[N];
            for (int i = 0; i < N; i++) {
                num[i] = sc.nextInt();
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                if (max < num[i]) {
                    max = num[i];
                }
            }

            int min = 1;

            while (min <= max) {
                int mid = (min + max) / 2;
                int cnt = 0;
                for (int i : num) {
                    cnt += i / mid;
                }
                if (cnt < M) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            System.out.println("#" + test_case + " " + max);

        }
    }
}