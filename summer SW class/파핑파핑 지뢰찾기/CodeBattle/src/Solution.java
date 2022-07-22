import java.awt.*;
import java.util.*;
import java.io.FileInputStream;

class Solution
{

    static int dx[] = {0, 0, -1, 1, 1, -1, 1, -1};
    static int dy[] = {-1, 1, 0, 0, -1, -1, 1, 1};

    static char[][] map;
    static int N, count, visited[][];

    static Queue<Point> q;

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input2.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {

            N = sc.nextInt();
            sc.nextLine();
            map = new char[N][N];
            visited = new int[N][N];
            count = 0;

            for (int i = 0; i < N; i++) {
                String str = sc.nextLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            checkMine();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0 && map[i][j] == '0') {
                        bfs(j, i);
                        count++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0 ) {
                        count++;
                    }
                }
            }

            System.out.println("#" + test_case + " " + count);
            count = 0;
        }
    }

    static void bfs(int x, int y) {
        q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[y][x] = -1;

        while(!q.isEmpty()) {
            Point point = q.poll();

            int px = point.x;
            int py = point.y;

            for(int i = 0; i < 8; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                    continue;
                }

                if(visited[ny][nx] == 0 && map[ny][nx] == '0') {
                    visited[ny][nx] = 1;
                    q.add(new Point(nx, ny));
                }

                else if(visited[ny][nx] == 0 && map[ny][nx] != '0') {
                    visited[ny][nx] = 1;
                }

                if(nx > -1 && ny > -1 && nx < N && ny < N && visited[ny][nx] == 0 && map[ny][nx] == '.'){
                    visited[ny][nx] = -1;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    static void checkMine() {
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++){
                if (map[y][x] == '*') {
                    visited[y][x] = 1;
                }
                if(map[y][x] == '.'){
                    int cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[ny][nx] != '*'){
                            continue;
                        }
                        cnt++;
                    }
                    map[y][x] = (char)(cnt+'0');
                }
            }
        }
    }
}