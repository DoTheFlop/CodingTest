import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		
		int[] dp = new int[n];
		
		dp[0] = nums[0];
		int max = nums[0];
		
		
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
