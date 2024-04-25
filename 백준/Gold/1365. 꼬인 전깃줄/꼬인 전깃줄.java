import java.util.Scanner;

public class Main {
	
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		dp = new int[N + 1];
		int len = 0;
		int idx = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i] > dp[len]) {
				len+=1;
				dp[len] = arr[i];
				continue;
			}
			
			idx = binarySearch(0, len, arr[i]);
			dp[idx] = arr[i];
		}
		
		System.out.println(N - len);
	}
	
	static int binarySearch(int left, int right, int key) {
		while(left<right) {
			int mid = (left+right)/2;
			if(dp[mid] > key) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		return right;
	}
}
