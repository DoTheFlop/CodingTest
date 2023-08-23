import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int h, w, answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        h = sc.nextInt();
        w = sc.nextInt();
        answer = 0;
        int cnt = 0;

        map = new int[h][w];
        visited = new boolean[h][w];

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(map[i][j] != 0 && visited[i][j] == false){
                    answer = Math.max(answer, bfs(i, j));
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(answer);
    }

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static int bfs(int r, int c){
        int size = 1;
        Queue<int[]> pq = new LinkedList<>();
        visited[r][c] = true;
        pq.offer(new int[] {r, c});
        while(!pq.isEmpty()){
            int[] p = pq.poll();

            for(int i = 0; i< 4; i++){
                int pr = p[0] + dr[i];
                int pc = p[1] + dc[i];

                if(pr < 0 || pr >= h || pc < 0 || pc >= w || map[pr][pc] == 0 || visited[pr][pc]) continue;

                pq.offer(new int[] {pr, pc});
                visited[pr][pc] = true;
                size++;
            }
        }
        return size;
    }
}