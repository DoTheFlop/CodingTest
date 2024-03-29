import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class Ball {
        int idx;
        int color;
        int size;

        public Ball(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Ball[] balls = new Ball[N + 1];

        int[] result = new int[N + 1];
        int[] colors = new int[N + 1];

        balls[0] = new Ball(0, 0, 0);

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(i, color, size);
        }

        Arrays.sort(balls, (o1, o2) -> o1.size - o2.size);

        int sum = 0;
        int ball_idx = 1;

        for (int i = 1; i < N + 1; i++) {
            Ball cur = balls[i];
            while (balls[ball_idx].size < cur.size) {
                sum += balls[ball_idx].size;
                colors[balls[ball_idx].color] += balls[ball_idx].size;
                ball_idx++;
            }
            result[cur.idx] = sum - colors[cur.color];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(result[i] + "\n");
        }
        System.out.print(sb.toString());
    }
}
