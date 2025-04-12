import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();

        int[][] road = new int[N][3];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < 3; j++){
                road[i][j] = sc.nextInt();
            }
        }

        int[] dp = new int[D + 1];

        for(int i = 0; i <= D; i++){
            dp[i] = i;
        }

        for(int i = 1; i <= D; i++){
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            for(int j = 0; j < N; j++){
                if(road[j][1] == i){
                    dp[i] = Math.min(dp[i], dp[road[j][0]] + road[j][2]);
                }
            }
        }

        System.out.println(dp[D]);
    }
}
