import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int[][] map = new int[n][n];
    long[][] dp = new long[n][n];
    dp[0][0] = 1;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        map[i][j] = sc.nextInt();
      }
    }
    for(int i = 0; i < n; i++){
      
      for(int j = 0; j < n; j++){
        int jump = map[i][j];
        if(jump == 0){
          break;
        }
        if(i + jump < n){
          dp[i+ jump][j] += dp[i][j];
        }
        if(j + jump < n){
          dp[i][j + jump] += dp[i][j];
        }
      }
    }
    System.out.println(dp[n-1][n-1]);
  }
}