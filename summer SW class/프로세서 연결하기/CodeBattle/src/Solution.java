import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    static class core{
        int x;
        int y;

        public core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<core> coreList;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int[][] map;
    static int N;

    static int maxCore = Integer.MIN_VALUE;
    static int minWireLength = Integer.MAX_VALUE;

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
            coreList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(sc.nextInt() == 1){
                        map[i][j] = 1;
                        if(i == 0 || j == 0 || i == N-1 || j == N-1) {
                            continue;
                        }
                        coreList.add(new core(j, i));
                    }
                }
            }


            dfs(0, 0, 0);

            System.out.println("#" + test_case + " " + minWireLength);

            maxCore = Integer.MIN_VALUE;
            minWireLength = Integer.MAX_VALUE;
        }
    }

    private static void dfs(int index, int coreCount, int wireLength) {

        if(index == coreList.size()) {
            if(maxCore < coreCount) {
                maxCore = coreCount;
                minWireLength = wireLength;
            } else if(maxCore == coreCount) {
                if (wireLength < minWireLength) {
                    minWireLength = wireLength;
                }
            }
            return;
        }

        int x = coreList.get(index).x;
        int y = coreList.get(index).y;

        for( int dir = 0; dir < 4; dir++) {

            int length = 0;
            int nx = x;
            int ny = y;

            while( true ) {
                nx += dx[dir];
                ny += dy[dir];

                if(ny < 0 || ny >= N || nx < 0 || nx >= N) break; //벽에 닿을때

                if(map[ny][nx] != 0) { //다른 코어, 전선을 만날 때
                    length = 0;
                    break;
                }

                length++;
            }

            int wire_x = x;
            int wire_y = y;

            for(int i = 0; i < length; i++) {
                wire_y += dy[dir];
                wire_x += dx[dir];
                map[wire_y][wire_x] = 1;
            }

            if(length == 0) {
                dfs(index+1, coreCount, wireLength);
            }
            else {
                dfs(index + 1, coreCount + 1, wireLength + length);

                wire_x = x;
                wire_y = y;
                for( int i = 0; i < length; i++) {
                    wire_y += dy[dir];
                    wire_x += dx[dir];
                    map[wire_y][wire_x] = 0;
                }
            }
        }
    }
}