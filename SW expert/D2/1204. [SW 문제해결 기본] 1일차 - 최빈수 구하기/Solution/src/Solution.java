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
            sc.nextInt();
            int[] student = new int[101];

            for (int i = 0; i < 1000; i++) {
                student[sc.nextInt()] += 1;
            }

            int max = 0;
            int index = 0;

            for (int i = 0; i < 101; i++) {
                if(max <= student[i]){
                    max = student[i];
                    index = i;
                }
            }

            System.out.println("#" + test_case + " " + index);
        }
    }
}