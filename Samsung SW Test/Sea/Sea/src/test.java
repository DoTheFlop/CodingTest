
import java.util.*;
import java.io.FileInputStream;


class test
{
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int answer = 1;
    private static int count = 0;
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < N; i++){
            // 0. 초기화
            visited = new boolean[N][N];
            count = 0;
            // 1. 물잠기기 세팅
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (map[y][x] <= i) {
                        visited[y][x] = true;
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k]) {
                        bfs(j, k, i);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    static void bfs(int x, int y, int height) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int px = pos[0];
            int py = pos[1];

            for(int i=0; i<4; i++) {
                int nx = px +dx[i];
                int ny = py +dy[i];

                if(nx<0 || ny<0 || nx>N-1 || ny >N-1) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny]> height) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx,ny});
                }
            }
        }
    }
}