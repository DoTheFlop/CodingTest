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

            System.out.println("#" + test_case);
            int money = sc.nextInt();
            int[] restMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
            int[] result = new int[8];

            for (int i = 0; i < 8; i++) {
                while (money >= restMoney[i]) {
                    money -= restMoney[i];
                    result[i] += 1;
                }
            }
            for (int i = 0; i < 8; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }
}