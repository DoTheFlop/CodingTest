import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map, answer;
	static int[] start;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		answer = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					start = new int[] { i, j };
				}
			}
		}

		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					System.out.print(-1 + " ");
				} else {
					System.out.print(answer[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { start[0], start[1], 0 });
		visited[start[0]][start[1]] = true;

		while (!q.isEmpty()) {
			int[] p = q.poll();

			for (int i = 0; i < 4; i++) {
				int pr = p[0] + dr[i];
				int pc = p[1] + dc[i];

				if (pr < 0 || pr >= N || pc < 0 || pc >= M) {
					continue;
				}

				if (map[pr][pc] == 0) {
					continue;
				}
				if (visited[pr][pc]) {
					continue;
				}

				q.offer(new int[] { pr, pc, p[2] + 1 });
				answer[pr][pc] = answer[p[0]][p[1]] + 1;
				visited[pr][pc] = true;
			}
		}
	}
}
