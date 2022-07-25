import java.io.FileInputStream;
import java.util.*;
public class test {

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] V = new int[N];
            int[] C = new int[N];

            for(int i=0; i<N; i++) {
                V[i] = sc.nextInt();
                C[i] = sc.nextInt();
            }

            int bag[][] = new int[N+1][K+1];

            for(int i = 0; i <= N; i++) {
                for(int j = 0; j <= K; j++) {
                    if(i == 0 || j == 0) {
                        bag[i][j] = 0;
                        continue;
                    }
                    if(V[i-1] <= j) {
                        bag[i][j] = Math.max(C[i-1] + bag[i-1][j-V[i-1]],  bag[i-1][j]);
                        continue;
                    }
                    bag[i][j] = bag[i-1][j];
                }
            }
            System.out.format("#%d %d\n", tc, bag[N][K]);
        }
        sc.close();
    }
}