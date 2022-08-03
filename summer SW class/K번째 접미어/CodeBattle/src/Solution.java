import java.util.ArrayList;
import java.util.Arrays;
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
            sc.nextLine();
            String str = sc.nextLine();
            String[] list = new String[str.length()];

            for (int i = 0; i < str.length(); i++) {
                list[i] = str.substring(i);
            }
            Arrays.sort(list);

            System.out.println("#" + test_case+ " " + list[N-1]);
        }
    }
}