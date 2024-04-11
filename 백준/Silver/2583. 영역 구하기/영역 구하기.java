import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        ArrayList<Integer> area = new ArrayList<>();

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int j = y1; j < y2; j++) {
                for(int k = x1; k < x2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && visited[i][j] == false) {
                    area.add(bfs(i, j));
                }
            }
        }
        Collections.sort(area);
        System.out.println(area.size());
        for(int i = 0; i < area.size(); i++) {
            System.out.print(area.get(i) + " ");
        }
    }

    public static int bfs(int r, int c) {
        int result = 1;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[r][c] = true;
        queue.offer(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int pr = cur[0] + dr[i];
                int pc = cur[1] + dc[i];

                if(pr < 0 || pr >= M || pc < 0 || pc >= N || visited[pr][pc] || map[pr][pc] == 1) continue;

                queue.offer(new int[]{pr, pc});
                visited[pr][pc] = true;
                result++;
            }
        }
        return result;
    }
}
