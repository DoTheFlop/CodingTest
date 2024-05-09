import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			int number = sc.nextInt();
			int last = sc.nextInt();
			
			Deque<Integer> q = new ArrayDeque<Integer>();
			boolean[] visited = new boolean[10000];
			String[] command = new String[10000];
			
			q.push(number);
			visited[number] = true;
			Arrays.fill(command,  "");
			
			while(!q.isEmpty() || !visited[last]) {
				int cur = q.poll();
				
				int D = (cur * 2) % 10000;
				
				int S = cur == 0 ? 9999 : cur - 1;
				
				int L = (cur % 1000) * 10 + (cur / 1000);
				
				int R = (cur % 10) * 1000 + (cur / 10);
				
				if(!visited[D]) { //D
					q.offer(D);
					visited[D] = true;
					command[D] = command[cur] + "D";
				}
				
				if(!visited[S]) { //S
					q.offer(S);
					visited[S] = true;
					command[S] = command[cur] + "S";
				}
				
				if(!visited[L]) { //L
					q.offer(L);
					visited[L] = true;
					command[L] = command[cur] + "L";
				}
				
				if(!visited[R]) { //R
					q.offer(R);
					visited[R] = true;
					command[R] = command[cur] + "R";
				}
			}
			
			System.out.println(command[last]);
		}
	}
}
