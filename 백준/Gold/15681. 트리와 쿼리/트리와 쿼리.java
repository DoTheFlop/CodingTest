import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, R, Q;
	static int[] qArr, cnt;
	static ArrayList<Integer>[] tree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		cnt = new int[N + 1];

		tree = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}

		qArr = new int[Q];
		for (int i = 0; i < Q; i++) {
			qArr[i] = Integer.parseInt(br.readLine());
		}

		solution();
	}

	static void solution() {
		dfs(R, -1);
		for (int x : qArr) {
			sb.append(cnt[x]).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs(int cur, int prevNode) {
		cnt[cur] = 1;

		for (int i : tree[cur]) {
			if (i == prevNode) {
				continue;
			}
			dfs(i, cur);
			cnt[cur] += cnt[i];
		}
	}
}
