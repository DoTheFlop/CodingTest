import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Problem implements Comparable<Problem> {
		int deadline, score;

		public Problem(int deadline, int score) {
			this.deadline = deadline;
			this.score = score;
		}

		@Override
		public int compareTo(Problem o) {
			return this.deadline - o.deadline;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		List<Problem> problemList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			problemList.add(new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(problemList);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (pq.size() < problemList.get(i).deadline) {
				pq.offer(problemList.get(i).score);
				result += problemList.get(i).score;
			} else if (!pq.isEmpty() && pq.peek() < problemList.get(i).score) {
				result -= pq.poll();
				pq.offer(problemList.get(i).score);
				result += problemList.get(i).score;
			}
		}
		System.out.println(result);
	}
}
