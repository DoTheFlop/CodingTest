import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		
		int[] eat = new int[d+1];
		int[] sushi = new int[n];
		
		int start = 0; int end = k;
		int max = 0;
		int cnt = 0;
		
		for(int i = 0; i < n+k; i++) {
			if(i < n) {
				sushi[i] = sc.nextInt();				
			}

			if(i < k) {
				if(eat[sushi[i]] == 0) {
					cnt++;
				}
				eat[sushi[i]]++;
			}else {
				eat[sushi[start]]--;
				if(eat[sushi[start]] == 0) {
					cnt--;
				}
				
				if(eat[sushi[end]] == 0) {
					cnt++;
				}
				eat[sushi[end]]++;
				
				if(eat[c] > 0) {
					max = Math.max(max, cnt);
				}else{
					max = Math.max(max, cnt + 1);
				}
				
				start++;
				end++;
				
				if(end == n) {
					end = 0;
				}
				if(start == n) {
					start = 0;
				}
			}
		}
		System.out.println(max);
	}
}
