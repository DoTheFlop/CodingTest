import java.util.Arrays;
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
            int result = 0;
            char[] charA = null;
            char[] charB = null;
            charA = sc.nextLine().toCharArray();
            charB = sc.nextLine().toCharArray();
            result = 0;
            for (int j = 0; j < charA.length - charB.length+1; j++) {
                char[] temp = Arrays.copyOfRange(charA, j, j+charB.length);
                if (Arrays.equals(charB, temp)) {
                    result++;
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}