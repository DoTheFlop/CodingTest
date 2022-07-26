import java.util.HashMap;
import java.util.HashSet;
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
            int result = 0;
            sc.nextLine();

            HashSet<String> mapA = new HashSet<>();
            for (int i = 0; i < N; i++) {
                String temp = sc.next();
                mapA.add(temp);
            }

            for (int i = 0; i < M; i++) {
                String temp = sc.next();
                if (mapA.contains(temp)) {
                    result++;
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}