import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	static int R, C, BR, BC, answer;
	static String[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();

		map = new String[R][C];
		visited = new boolean[R][C];
		int r = 0, c = 0;
		int wr = 0, wc = 0;
		for (int i = 0; i < R; i++) {
			String[] in = sc.next().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = in[j];
				if (map[i][j].equals("D")) {
					BR = i;
					BC = j;
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j].equals("*")) {
					q.offer(new int[] { i, j, 0, 0 });
					visited[i][j] = true;
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j].equals("S")) {
					q.offer(new int[] { i, j, 0, 1 });
					visited[i][j] = true;
				}
			}
		}

		if (bfs()) {
			System.out.println(answer);
		} else {
			System.out.println("KAKTUS");
		}
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static ArrayDeque<int[]> q = new ArrayDeque<>();

	private static boolean bfs() {

		while (!q.isEmpty()) {

			int[] p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int wpr = p[0] + dr[i];
				int wpc = p[1] + dc[i];

				if (wpr < 0 || wpc < 0 || wpr >= R || wpc >= C || visited[wpr][wpc] || map[wpr][wpc].equals("X"))
					continue;
				
				if(p[3] == 1 && map[wpr][wpc].equals("D")) {
					answer = p[2] + 1;
					return true;
				}
				
				if(p[3] == 0 && map[wpr][wpc].equals("D")) {
					continue;
				}

				q.offer(new int[] { wpr, wpc, p[2] + 1, p[3]});
				visited[wpr][wpc] = true;
			}

		}
		return false;
	}

}
