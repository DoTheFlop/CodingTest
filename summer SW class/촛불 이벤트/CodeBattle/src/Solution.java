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
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            long result = -1;
            long temp = 0;
            long N = Long.parseLong(sc.nextLine());

            long number = (long)Math.sqrt(N * 2);

            for (; ; number++) {
                temp = (number * (number + 1)) / 2;
                if (temp == N) {
                    result = number;
                    break;
                } else if (temp > N) {
                    break;
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}