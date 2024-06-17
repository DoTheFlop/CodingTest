import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };
	static boolean visited[][][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[2][N][M];
		for (int i = 0; i < N; i++) {
			String[] in = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(in[j]);
			}
		}

		bfs(0, 0);

	}

	public static void bfs(int r, int c) {
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { 0, r, c, 1 });
		visited[0][r][c] = true;

		while (!q.isEmpty()) {
			int[] p = q.poll();

			if (p[1] == N - 1 && p[2] == M - 1) {
				System.out.println(p[3]);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int pr = p[1] + dr[i];
				int pc = p[2] + dc[i];

				if (pr < 0 || pc < 0 || pr >= N || pc >= M) {
					continue;
				}

				if (map[pr][pc] == 0) {
					if (!visited[p[0]][pr][pc]) {
						q.offer(new int[] { p[0], pr, pc, p[3] + 1 });
						visited[p[0]][pr][pc] = true;
					}

				} else if (map[pr][pc] == 1) {

					if (p[0] == 0) {
						q.offer(new int[] { 1, pr, pc, p[3] + 1 });
						visited[1][pr][pc] = true;
					}

				}

			}
		}
		System.out.println(-1);

	}
}
