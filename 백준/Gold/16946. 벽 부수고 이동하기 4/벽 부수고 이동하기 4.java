import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Node node = (Node)o;
			return r == node.r && c == node.c;
		}

		@Override
		public int hashCode() {
			return Objects.hash(r, c);
		}
	}

	static int h, w;
	static int[][] map, groupMap, result;
	static boolean[][] visited;
	static Map<Integer, Integer> group;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		StringTokenizer st = new StringTokenizer(in);
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		map = new int[h][w];
		result = new int[h][w];
		visited = new boolean[h][w];
		groupMap = new int[h][w];
		group = new HashMap<>();

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			String[] split = st.nextToken().split("");
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		int groupNum = 1;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					bfs(i, j, groupNum++);
				}
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] == 1) {
					Set<Node> sum = new HashSet<>();
					for (int k = 0; k < 4; k++) {
						int ph = i + dh[k];
						int pw = j + dw[k];
						if (ph < 0 || pw < 0 || ph >= h || pw >= w || map[ph][pw] != 0)
							continue;
						sum.add(new Node(groupMap[ph][pw], group.get(groupMap[ph][pw])));
					}
					for (Node t : sum) {
						result[i][j] += t.c;
					}
					result[i][j]++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				sb.append(result[i][j]%10);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int[] dh = {1, -1, 0, 0};
	static int[] dw = {0, 0, 1, -1};

	public static void bfs(int r, int c, int groupNum) {
		int cnt = 1;
		visited[r][c] = true;
		groupMap[r][c] = groupNum;
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(r, c));

		while (!q.isEmpty()) {
			Node p = q.poll();

			for (int i = 0; i < 4; i++) {
				int ph = p.r + dh[i];
				int pw = p.c + dw[i];
				if (ph < 0 || pw < 0 || ph >= h || pw >= w || visited[ph][pw] || map[ph][pw] != 0)
					continue;
				q.offer(new Node(ph, pw));
				groupMap[ph][pw] = groupNum;
				visited[ph][pw] = true;
				cnt++;
			}
		}
		group.put(groupNum, cnt % 10);
	}
}
