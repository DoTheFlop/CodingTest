import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	static int H, W;
	static int[][] map, check;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		map = new int[H][W];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int cnt = 0;
		while(true) {
			cnt++;
			bfs(0, 0);
			if(0 == remain()) break;
		}
		System.out.println(String.format("%d", cnt));
	}
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void bfs(int r, int c) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited = new boolean[H][W];
		check = new int[H][W];
		
		q.offer(new int[] {r, c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int pr = p[0] + dr[i];
				int pc = p[1] + dc[i];
				
				if(pr < 0 || pc < 0 || pr >= H || pc >= W || visited[pr][pc]) continue;
				
				if(map[pr][pc] == 1) {
					check[pr][pc]++;
				}else {
					q.offer(new int[] {pr, pc});
					visited[pr][pc] = true;
				}
			}
		}
	}
	
	public static int remain() {
		int cnt = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(check[i][j] >= 2) {
					map[i][j] = 0;
				}
				if(map[i][j] == 1) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
