import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n, m, min, sum;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] connected;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static PriorityQueue<Node> pq;
	static ArrayList<Set<Node>> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬마다 번호 붙이기
		visited = new boolean[n][m];
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					bfs(i, j, cnt);
					cnt++;
				}
			}
		}
		
		// 섬에서 섬으로 다리 잇기
		
		list = new ArrayList<>();
		for(int i=0; i<cnt; i++) list.add(new HashSet<Node>());
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] != 0) {
					makeBridge(i, j);
				}
			}
		}
		
		// 최소 신장 트리
		
		pq = new PriorityQueue<>();
		connected = new boolean[cnt];
		pq.add(new Node(1, 1, 0));
		
		int result = 0;
		
		while(!pq.isEmpty()) {
			//가중치 가장 낮은 노드 선택
			Node curr = pq.poll();
			if(connected[curr.to]) continue;
			connected[curr.to] = true;
			result+=curr.dist;
			for(Node node : list.get(curr.to)) {
				if(!connected[node.to]) {
					pq.add(node);					
				}
			}
		}
		for(int i = 1; i < cnt; i++) {
			if(!connected[i]) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(result);			
	}


	private static void bfs(int r, int c, int cnt) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		map[r][c] = cnt;
		visited[r][c] = true;

		while(!q.isEmpty()) {
			int[] p = q.poll();
			for(int i = 0; i < 4; i++) {
				int pr = p[0] + dr[i];
				int pc = p[1] + dc[i];
				if(pr < 0 || pc < 0 || pr >= n || pc >= m || map[pr][pc] == 0 || visited[pr][pc]) continue;

				map[pr][pc] = cnt;
				q.offer(new int[] {pr,pc});
				visited[pr][pc] = true;
			}
		}
	}
	

	private static void makeBridge(int r, int c) {
		
		for(int i = 0; i < 4; i++) {
			int pr = r;
			int pc = c;
			int cnt = 0;
			while(true) {
				pr = pr + dr[i];
				pc = pc + dc[i];
				if(pr < 0 || pc < 0 || pr >= n || pc >= m) break;
				
				if(map[pr][pc] == 0) {
					cnt++;
				}else if(map[pr][pc] != 0 && map[pr][pc] != map[r][c] && map[pr][pc] != map[r][c]) {
					if(cnt > 1) {
						list.get(map[r][c]).add(new Node(map[r][c], map[pr][pc], cnt));
					}
					break;
				}else {
					break;
				}
			}
		}
	}



	static class Node implements Comparable<Node>{
		int from;
		int to;
		int dist;
		public Node(int from, int to, int dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", dist=" + dist + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + dist;
			result = prime * result + from;
			result = prime * result + to;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (dist != other.dist)
				return false;
			if (from != other.from)
				return false;
			if (to != other.to)
				return false;
			return true;
		}
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
		
	}
}
