import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception{
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int toBinary = (1 << N) - 1;
            if( (M & toBinary) != toBinary){
                System.out.println("#" + test_case +" OFF");
            }
            else System.out.println("#" + test_case +" ON");
        }
    }
}