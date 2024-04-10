import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static int N, M;

    public static boolean[][] visited;
    public static int[][] map;

    public static int[] dr = {0, 1, 0, -1, 1, -1, 1, -1};
    public static int[] dc = {1, 0, -1, 0, 1, -1, -1, 1};
    public static boolean pick;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[N][M];
        int answer = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j]) {
                    pick=true;
                    dfs(i,j);
                    if(pick)answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int r, int c) {
        visited[r][c]=true;
        for (int k = 0; k < 8; k++) {
            int x=r + dr[k];
            int y=c + dc[k];
            if(x < 0 || y < 0 || x >= N || y >= M)continue;
            //꼭대기가 아니면 값을 더하지 않기 위해 사용
            if(map[x][y] > map[r][c])pick=false;
            if(!visited[x][y]&&map[x][y]==map[r][c]) {
                dfs(x, y);
            }
        }
    }
}
