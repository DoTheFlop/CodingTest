import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	static String[][] map;
	static boolean[][] visited;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new String[12][6];
		answer = 0;

		for (int i = 0; i < 12; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < 6; j++) {
				map[i][j] = split[j];
			}
		}
		boolean go = true;
		while (go) {
			go = false;

			for (int k = 0; k < 11; k++) {
				for (int j = 0; j < 6; j++) {
					if (map[k + 1][j].equals(".")) {
						for (int i = k; i >= 0; i--) {
							map[i + 1][j] = map[i][j];
							map[i][j] = ".";
						}
					}
				}
			}
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j].equals(".")) {
						continue;
					} else {
						go = bfs(i, j, go);
					}
				}
			}
			if (go) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static boolean bfs(int r, int c, boolean go) {
		String cur = map[r][c];
		boolean[][] visited = new boolean[12][6];
		visited[r][c] = true;
		List<int[]> list = new ArrayList<>();
		list.add(new int[] {r, c});
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});

		while (!q.isEmpty()) {
			int[] p = q.poll();
			for (int i = 0; i < 4; i++) {
				int pr = p[0] + dr[i];
				int pc = p[1] + dc[i];

				if (pr >= 12 || pr < 0 || pc >= 6 || pc < 0 || visited[pr][pc] || !map[pr][pc].equals(cur)) {
					continue;
				}
				list.add(new int[] {pr, pc});
				q.offer(new int[] {pr, pc});
				visited[pr][pc] = true;
			}
		}
		if (list.size() >= 4) {
			for (int[] puyo : list) {
				map[puyo[0]][puyo[1]] = ".";
			}
			go = true;
		}
		return go;
	}
}
