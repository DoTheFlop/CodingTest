import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static ArrayList<Integer>[] relation;
	static boolean[] visited;
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		relation = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			relation[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			relation[a].add(b);
			relation[b].add(a);
		}
		
		for(int i = 0; i < N; i++) {
			if(answer != 1) {
				visited[i] = true;
				dfs(i, 0);
				visited[i] = false;
			}
		}
		
		System.out.println(answer);
	}
	
	public static void dfs(int cur, int cnt) {
		if(cnt == 4) {
			answer = 1;
			return;
		}
		
		for(int i : relation[cur]) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, cnt + 1);
				visited[i] = false;
			}
		}
	}
}
