import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static String[][] map;
    public static boolean[][] visited;
    public static int[]dx = {0, -1, 0, 1};
    public static int[]dy = {1, 0, -1, 0};
    public static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new String[N][M];
        visited = new boolean[N][M];

        int answer = 0;

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < N; i++) {
            String[] input = sc.next().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j];
                if(map[i][j].equals("I")) {
                    startX = i;
                    startY = j;
                }
            }
        }

        answer = bfs(startX, startY);
        System.out.println(answer > 0 ? answer : "TT");
    }

    public static int bfs(int x, int y){
        ArrayDeque<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[]{x, y});
        visited[x][y] = true;

        int answer = 0;

        while(!queue.isEmpty()){
            Integer[] temp = queue.poll();
            if(map[temp[0]][temp[1]].equals("P")){
                answer++;
            }

            for(int i = 0; i < 4; i ++){
                int px = temp[0] + dx[i];
                int py = temp[1] + dy[i];

                if(px < 0 || px >= N || py < 0 || py >= M || visited[px][py] || map[px][py].equals("X")){
                    continue;
                }
                queue.add(new Integer[]{px, py});
                visited[px][py] = true;
            }
        }

        return answer;
    }
}
