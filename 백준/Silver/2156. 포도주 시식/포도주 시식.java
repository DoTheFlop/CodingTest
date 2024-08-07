import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        int[] wine = new int[n+1];
        for(int i = 1; i < n+1; i++) {
            wine[i] = sc.nextInt();
        }

        dp[1] = wine[1];
        
        if(n > 1) {
            dp[2] = wine[1] + wine[2];
        }

        for(int i = 3; i < n+1; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-3] + wine[i-1]) + wine[i]);
        }

        System.out.println(dp[n]);
    }
}
