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

            int[] A = new int[N];
            int[] B = new int[M];

            int answer = 0;

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt();
            }

            if (A.length > B.length) {
                int L = N - M;
                for (int i = 0; i <= L; i++) {
                    int sum = 0;
                    for (int j = 0; j < B.length; j++) {
                        sum += A[i+j] * B[j];
                    }
                    if (answer < sum) {
                        answer = sum;
                    }
                }
            } else {
                int L = M - N;
                for (int i = 0; i <= L; i++) {
                    int sum = 0;
                    for (int j = 0; j < A.length; j++) {
                        sum += A[j] * B[i+j];
                    }
                    if (answer < sum) {
                        answer = sum;
                    }
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}