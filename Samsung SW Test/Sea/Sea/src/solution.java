import java.util.*;
import java.io.FileInputStream;

class Solution
{
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int answer = 1;
    private static int count = 1;
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, -1, 0, 1};
    private static int maxHeight = 0;
    private static List<Integer> heightList = new ArrayList<>(); //물 높이 경우의 수 리스트
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);

        int T;
        T = sc.nextInt();
        //System.out.println("T = " + T);

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    if (!heightList.contains(map[i][j])) heightList.add(map[i][j]);
                    if(map[i][j] > maxHeight) {
                        maxHeight = map[i][j];
                    }
                }
            }
            heightList.add(0);
            Collections.sort(heightList);

            for (int i : heightList){
                visited = new boolean[N][N];
                count = 0;
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
                        }
                    }
                }
                if (answer < count){
                    answer = count;
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }

    static void bfs(int x, int y, int height) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] position = q.poll();
            int px = position[0];
            int py = position[1];

            for(int i = 0; i < 4; i++) {
                int nx = px +dx[i];
                int ny = py +dy[i];

                if(nx > -1 && ny > -1 && nx < N && ny < N && visited[nx][ny] == false){
                    if(map[nx][ny]> height) {
                        visited[nx][ny] = true;
                        q.add(new int[] {nx,ny});
                    }
                }
            }
        }
        count++;
    }
}