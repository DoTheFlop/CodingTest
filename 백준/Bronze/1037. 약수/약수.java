import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		while(T-- > 0) {
			int N = in.nextInt();
			
			if(N > max) max = N;
			if(N < min) min = N;
		}
		System.out.println(max * min);
	}
 
}