import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int N, L, R;
	static boolean[][] visited;
	static int[][] land;
	static ArrayList<int[]> border;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		land = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				land[i][j] = sc.nextInt();
			}
		}
		
		int sum;
		int cnt = 0;
		while(true) {
			visited = new boolean[N][N];
			boolean check = false;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					
					if(!visited[i][j]) {
						sum = bfs(i, j);
						if(border.size() > 1) {
							for(int[] p : border) {
							land[p[0]][p[1]] = sum / border.size();
							}
							check = true;
						}
					}
					
				}
			}
			
			if(!check) {
				break;
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static int bfs(int r, int c) {
		border = new ArrayList<int[]>();
		int sum = 0;
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {r, c});
		visited[r][c] = true;
		border.add(new int[] {r, c});
		sum += land[r][c];
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int pr = p[0] + dr[i];
				int pc = p[1] + dc[i];
				
				if(pr < 0 || pc < 0 || pr >= N || pc >= N || visited[pr][pc]) continue;
				
				int diff = Math.abs(land[p[0]][p[1]] - land[pr][pc]);
				
				if(diff >= L && diff <= R) {
					border.add(new int[] {pr, pc});
					sum += land[pr][pc];
					q.offer(new int[] {pr, pc});
					visited[pr][pc] = true;
				}
			}
		}
		
		return sum;
	}
}
