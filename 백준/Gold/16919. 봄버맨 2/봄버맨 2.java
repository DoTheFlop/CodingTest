import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, N;
	static String[][] map;
	static boolean[][] temp;
	static int[][] bomb;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new String[R][C];
		bomb = new int[R][C];
		temp = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String[] in = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = in[j];
				if (map[i][j].equals("O")) {
					bomb[i][j] = 1;
				}
			}
		}

		if (N == 1) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return;
		}

		if (N % 2 == 0) { // 폭탄 설치하는 시간
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print("O");
				}
				System.out.println();
			}
			return;
		}

		if (N % 4 == 3) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = "O";
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (bomb[i][j] > 0) {
						explode(i, j);
					}
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		} else if (N % 4 == 1) {

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = "O";
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (bomb[i][j] > 0) {
						explode(i, j);
					}
				}
			}

			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = "O";
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (!temp[i][j]) {
						explode2(i, j);
					}
				}
			}
			
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}
	}

	public static void explode(int r, int c) {

		map[r][c] = ".";
		bomb[r][c] = 0;
		temp[r][c] = true;
		for (int k = 0; k < 4; k++) {
			int pr = r + dr[k];
			int pc = c + dc[k];
			if (pr < 0 || pc < 0 || pr >= R || pc >= C)
				continue;
			map[pr][pc] = ".";
			temp[pr][pc] = true;
		}

	}

	public static void explode2(int r, int c) {

		map[r][c] = ".";
		bomb[r][c] = 0;
		temp[r][c] = true;
		for (int k = 0; k < 4; k++) {
			int pr = r + dr[k];
			int pc = c + dc[k];
			if (pr < 0 || pc < 0 || pr >= R || pc >= C)
				continue;
			map[pr][pc] = ".";
		}

	}
}
