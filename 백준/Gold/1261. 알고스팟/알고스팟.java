import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] map, dist;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[M][N];
		dist = new int[M][N];

		for(int i = 0; i < M; i++) {
			String[] in = sc.next().split("");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(in[j]);
			}
		}
		for(int i = 0; i < M; i++) {
			Arrays.fill(dist[i], 10000);
		}
		bfs();
		System.out.println(dist[M-1][N-1]);
	}
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	public static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0});
		dist[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int pr = p[0] + dr[i];
				int pc = p[1] + dc[i];
				
				if(pr < 0 || pc < 0 || pr >= M || pc >= N) continue;
				
				if(map[pr][pc] == 1) {
					if (dist[pr][pc] > dist[p[0]][p[1]] + 1) {
						dist[pr][pc] = dist[p[0]][p[1]] + 1;
						q.offer(new int[] {pr, pc});
					}
				}else {
					if (dist[pr][pc] > dist[p[0]][p[1]]) {
						dist[pr][pc] = dist[p[0]][p[1]];
						q.offer(new int[] {pr, pc});
					}
				}
			}
		}
	}
}
