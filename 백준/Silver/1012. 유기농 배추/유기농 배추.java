
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static int N, M;
    public static int[] dr = { 0, 0, -1, 1 };
    public static int[] dc = { -1, 1, 0, 0 };
    public static int[][] farm;
    public static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int testCase = 0; testCase < T; testCase++) {

            N = sc.nextInt();
            M = sc.nextInt();
            int K = sc.nextInt();
            farm = new int[N][M];
            visited = new boolean[N][M];

            int answer = 0;

            for(int i = 0; i < K; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                farm[x][y] = 1;
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(farm[i][j] == 1 && visited[i][j] == false){
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static void bfs(int r, int c) {
        ArrayDeque<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[]{r, c});
        visited[r][c] = true;
        while(!queue.isEmpty()){
            Integer[] cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int pr = cur[0] + dr[i];
                int pc = cur[1] + dc[i];

                if(pr < 0 || pc < 0 || pr >= N || pc >= M || visited[pr][pc] || farm[pr][pc] == 0){
                    continue;
                }

                queue.add(new Integer[]{pr, pc});
                visited[pr][pc] = true;
            }
        }
    }
}
