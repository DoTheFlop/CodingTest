import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int answer = 0;

		while (true) {
			int check = 0;
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0 && !visited[i][j]) {
						bfs(i, j);
						check++;
					}
				}
			}

			if (check > 1) {
				break;
			} else if (check == 0) {
				answer = 0;
				break;
			}
			answer++;
		}

		System.out.println(answer);
	}

	public static void bfs(int r, int c) {
		ArrayDeque<Point> q = new ArrayDeque<Point>();

		if (map[r][c] > 0) {
			melt(r, c);
		}
		visited[r][c] = true;
		q.offer(new Point(r, c));

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int pr = p.x + dr[i];
				int pc = p.y + dc[i];

				if (pr < 0 || pc < 0 || pr >= N || pc >= M || visited[pr][pc] || map[pr][pc] == 0) {
					continue;
				}
				if (map[pr][pc] > 0) {
					melt(pr, pc);
				}
				visited[pr][pc] = true;
				q.offer(new Point(pr, pc));
			}
		}
	}

	public static void melt(int r, int c) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int pr = r + dr[i];
			int pc = c + dc[i];

			if (pr < 0 || pc < 0 || pr >= N || pc >= M || visited[pr][pc] || map[pr][pc] != 0) {
				continue;
			}
			cnt++;
		}
		map[r][c] -= cnt;
		if (map[r][c] < 0) {
			map[r][c] = 0;
		}
	}
}
