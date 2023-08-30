import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static class Node implements Comparable<Node> {
		int r, c, friend, blank;

		public Node(int r, int c, int friend, int blank) {
			this.r = r;
			this.c = c;
			this.friend = friend;
			this.blank = blank;
		}

		public void setPos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Node other) {
			// 인접 좋아하는 학생 수로 비교
			if (friend != other.friend)
				return -(friend - other.friend);

			// 인접 빈칸 수로 비교
			if (blank != other.blank)
				return -(blank - other.blank);

			// 행으로 비교
			if (r != other.r)
				return r - other.r;

			// 열로 비교
			return c - other.c;
		}
	}

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	static HashSet<Integer>[] relation;

	static int n;
	static int[] order;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		init();
		solution();
		getResult();
	}

	private static void getResult() {
		int answer = 0;
		int[] jumsu = {0, 1, 10, 100, 1000};
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int pr = i + dr[k];
					int pc = j + dc[k];
					if (pr < 0 || pc < 0 || pr >= n || pc >= n)
						continue;
					if (relation[map[i][j]].contains(map[pr][pc])) {
						cnt++;
					}
				}
				answer += jumsu[cnt];
			}
		}
		System.out.println(answer);
	}

	private static void solution() {
		map[1][1] = order[1];

		for (int i = 2; i <= n * n; i++) {
			findSeat(order[i]);
		}

	}

	static void findSeat(int cur) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0) {
					continue;
				}
				pq.offer(isThereFriend(i, j, cur));
			}
		}
		Node poll = pq.poll();
		map[poll.r][poll.c] = cur;
	}

	static Node isThereFriend(int r, int c, int cur) {
		int friendCnt = 0;
		int blankCnt = 0;
		for (int k = 0; k < 4; k++) {
			int pr = r + dr[k];
			int pc = c + dc[k];
			if (pr < 0 || pc < 0 || pr >= n || pc >= n)
				continue;
			if (relation[cur].contains(map[pr][pc])) {
				friendCnt++;
			} else {
				if (map[pr][pc] == 0) {
					blankCnt++;
				}
			}
		}
		return new Node(r, c, friendCnt, blankCnt);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		order = new int[n * n + 1];
		map = new int[n][n];

		relation = new HashSet[n * n + 1];

		StringTokenizer st;
		for (int i = 1; i <= n * n; i++) {
			st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			HashSet<Integer> temp = new HashSet<>();
			while (st.hasMoreTokens()) {
				temp.add(Integer.parseInt(st.nextToken()));
			}
			order[i] = key;
			relation[key] = temp;
		}
	}
}
