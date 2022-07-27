import java.awt.*;
import java.util.*;
import java.io.FileInputStream;


class Solution
{
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map, visited, ans;
    static int N, min;


    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            map = new int[N][N];
            visited = new int[N][N];
            ans = new int[N][N];
            min = Integer.MAX_VALUE;

            sc.nextLine();

            for (int i = 0; i < N; i++) {
                String[] temp = sc.nextLine().split("");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }
            ans[0][0] = 0;

            bfs(0, 0);
            System.out.println("#" + test_case + " " + min);
        }
    }

    static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[y][x] = 1;
        while(!q.isEmpty()) {
            Point poll = q.poll();
            int px = poll.x;
            int py = poll.y;

            if (px == N - 1 && py == N - 1) {
                if (min > ans[N - 1][N - 1]) {
                    min = ans[N - 1][N - 1];
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (!(nx < 0 || nx >= N || ny < 0 || ny >= N)){
                    if(visited[nx][ny] == 0 || ans[nx][ny] > ans[px][py] + map[nx][ny]  ){
                        visited[nx][ny] = 1;
                        ans[nx][ny] = ans[px][py] + map[nx][ny];
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}