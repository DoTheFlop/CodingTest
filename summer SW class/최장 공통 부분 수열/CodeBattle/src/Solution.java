import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

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
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            char[] char1 = st.nextToken().toCharArray();
            char[] char2 = st.nextToken().toCharArray();

            int m = char1.length;
            int n = char2.length;
            int result[][] = new int[m+1][n+1];

            for(int i=0; i<=m; i++) {
                for(int j=0; j<=n; j++) {
                    if( i==0 || j==0 ) {
                        result[i][j] = 0;
                        continue;
                    }
                    if( char1[i-1] == char2[j-1] ) {
                        result[i][j] = result[i-1][j-1]+1;
                        continue;
                    }
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
                }
            }
            System.out.println("#" + test_case + " " + result[m][n]);

        }
    }
}