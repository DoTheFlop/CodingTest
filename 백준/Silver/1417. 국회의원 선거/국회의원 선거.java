import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static class Vote implements Comparable<Vote>{
        int idx;
        int cnt;

        public Vote(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Vote o) {
            return o.cnt - this.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Vote> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        Vote dasom = new Vote(1, Integer.parseInt(br.readLine()));

        for (int i = 1; i < N; i++) {
            pq.offer(new Vote(i, Integer.parseInt(br.readLine())));
        }

        int answer = 0;

        while (dasom.cnt <= pq.peek().cnt) {
            Vote cur = pq.poll();
            cur.cnt -= 1;
            pq.offer(cur);
            dasom.cnt += 1;
            answer++;
        }

        System.out.println(answer);
    }
}
