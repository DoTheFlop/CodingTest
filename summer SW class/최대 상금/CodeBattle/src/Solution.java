import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{

    static int result;
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int number = sc.nextInt();
            int changeCount = sc.nextInt();

            char[] numberList = Integer.toString(number).toCharArray();
            dfs(changeCount, 0, numberList);

            System.out.println("#" + test_case + " " + result);
            result = 0;
        }
    }

    public static void dfs(int changeCount, int start, char[] numbers) {

        if(changeCount == 0) {
            int current = Integer.parseInt(new String(numbers));
            if(current > result) {
                result = current;
            }
            return;
        }

        for(int i = start; i < numbers.length-1; i++) {

            for(int j = i + 1; j < numbers.length; j++) {

                int numA = Integer.parseInt(String.valueOf(numbers[i]));
                int numB = Integer.parseInt(String.valueOf(numbers[j]));

                numbers[i] = (char)(numB + '0');
                numbers[j] = (char)(numA + '0');
                dfs(changeCount - 1, i, numbers);
                numbers[i] = (char)(numA + '0');
                numbers[j] = (char)(numB + '0');

            }

        }
    }
}