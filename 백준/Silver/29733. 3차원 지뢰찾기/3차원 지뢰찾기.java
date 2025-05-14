import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static int[] dh = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    public static int[] dr = {1, 1, 1, 0, 0, 0, -1, -1, -1, 1, 1, 1, 0, 0, -1, -1, -1, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    public static int[] dc = {1, 0, -1, 1, 0, -1, 1, 0, -1, 1, 0, -1, 1, -1, 1, 0, -1, 1, 0, -1, 1, 0, -1, 1, 0, -1};
    public static String[][][] map;
    public static String[][][] ans;
    public static int R, C, H;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new String[H][R][C];
        ans = new String[H][R][C];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < R; j++) {
                String[] line = br.readLine().split("");
                for (int k = 0; k < C; k++) {
                    map[i][j][k] = line[k];
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if(map[i][j][k].equals("*")){
                        ans[i][j][k] = "*";
                        continue;
                    }
                    bfs(i, j, k);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    sb.append(ans[i][j][k]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void bfs(int h, int r, int c) {
        int cnt = 0;
        for(int i = 0; i < 26; i++){
            int ph = h + dh[i];
            int pr = r + dr[i];
            int pc = c + dc[i];

            if(ph < 0 || pr < 0 || pc < 0 || pc >= C || pr >= R || ph >= H){
                continue;
            }
            if(map[ph][pr][pc].equals("*")){
                cnt++;
            }
        }
        ans[h][r][c] = String.valueOf(cnt%10);
    }
}
