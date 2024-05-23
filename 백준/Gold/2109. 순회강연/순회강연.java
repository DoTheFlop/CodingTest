import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static class Study implements Comparable<Study> {
		int p, d;

		public Study(int p, int d) {
			this.p = p;
			this.d = d;
		}

		@Override
		public int compareTo(Study o) {
			if (this.p == o.p) {
				return this.d - o.d;
			} else
				return o.p - this.p;
		}

		@Override
		public String toString() {
			return String.format("p : %d d : %d", p, d);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		PriorityQueue<Study> q = new PriorityQueue<Main.Study>();

		int max = 0;

		for (int i = 0; i < n; i++) {
			Study in = new Study(sc.nextInt(), sc.nextInt());
			q.offer(in);
			max = Math.max(max, in.d);
		}

		boolean[] visited = new boolean[max + 1];
		int answer = 0;

		while (!q.isEmpty()) {
			Study cur = q.poll();

			for (int i = cur.d; i > 0; i--) {
				if (!visited[i]) {
					visited[i] = true;
					answer += cur.p;
					break;
				}
			}
		}

		System.out.println(answer);
	}
}
