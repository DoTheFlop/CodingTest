import java.util.Scanner;


public class Main {

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0 ,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] hive = new int[M][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                hive[i][j] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            int zero = sc.nextInt();
            int one = sc.nextInt();
            int two = sc.nextInt();

            for (int j = M - 1; j >= 0; j--) {
                if (zero != 0) {
                    zero--;
                } else if (one != 0) {
                    one--;
                    hive[j][0] += 1;
                }else if (two != 0) {
                    two--;
                    hive[j][0] += 2;
                }
            }

            for (int j = 1; j < M; j++) {
                if (zero != 0) {
                    zero--;
                } else if (one != 0) {
                    one--;
                    hive[0][j] += 1;
                }else if (two != 0) {
                    two--;
                    hive[0][j] += 2;
                }
            }

            for (int k = 1; k < M; k++) {
                for (int q = 1; q < M; q++) {
                    hive[q][k] = Math.max(hive[q-1][k-1], Math.max(hive[q-1][k], hive[q][k-1]));
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(hive[i][j] + " ");
            }
            System.out.println();
        }
    }
}
