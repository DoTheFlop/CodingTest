import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] board;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		board = new int[101];
		visited = new boolean[101];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
		}

		bfs(1);
	}

	public static void bfs(int cur) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 1, 0 });
		visited[1] = true;

		while (!q.isEmpty()) {
			int[] p = q.poll();

			if (p[0] == 100) {
				System.out.println(p[1]);
				return;
			}

			for (int i = 1; i <= 6; i++) {
				int moveP = p[0] + i;

				if (moveP > 100 || visited[moveP]) {
					continue;
				}

				if (board[moveP] != 0) {
					if (!visited[board[moveP]]) {
						q.offer(new int[] { board[moveP], p[1] + 1 });
						visited[moveP] = true;
					}
				} else {
					q.offer(new int[] { moveP, p[1] + 1 });
					visited[moveP] = true;
				}
			}
		}
	}
}
