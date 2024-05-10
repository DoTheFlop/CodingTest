import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] brokenBtn = new int[m];
		
		for(int i = 0; i < m; i++) {
			brokenBtn[i] = sc.nextInt();
		}
		
		int answer = Math.abs(100 - n);
		
		for(int i = 0; i < 999999; i++) {
			boolean pushBreakBtn = false;
			String nums = String.valueOf(i);
			for(int j = 0; j < m; j++) {
				if(nums.contains(String.valueOf(brokenBtn[j]))) {
					pushBreakBtn = true;
					break;
				}
			}
			
			if(!pushBreakBtn)
			answer = Math.min(answer, Math.abs(i - n) + nums.length());
		}
		System.out.println(answer);
	}
}
