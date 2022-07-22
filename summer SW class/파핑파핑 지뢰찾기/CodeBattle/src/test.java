import java.io.*;
import java.util.*;
public class test{
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1, 1,1,-1,-1};
    static int[] dy = {1,0,-1,0, 1,-1,1,-1};
    static int n;
    static Queue<int[]> queue= new LinkedList<int[]>();
    public static void main(String[] args)throws Exception {
        // TODO Auto-generated method stub

        System.setIn(new FileInputStream("res/input2.txt"));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc=Integer.parseInt(br.readLine());
        for(int t=1 ; t<=tc ; t++) {
            n=Integer.parseInt(br.readLine());
            map= new char[n][n];
            visited = new boolean[n][n];
            for(int i=0 ; i < n ;i++) {
                String tmp=br.readLine();
                for(int j=0 ; j< n ; j++) {
                    map[i][j]=tmp.charAt(j);
                    if(map[i][j]=='*') visited[i][j]=true;

                }
            }
            // map에 주변 지뢰를 탐색
            for(int i=0 ; i<n ;i++) {
                for(int j=0; j<n ;j++) {
                    int cnt=0;
                    for(int k=0; k<8 ; k++) {
                        int nx=i+dx[k];
                        int ny=j+dy[k];
                        if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                        if(map[nx][ny]=='*') cnt+=1;
                    }

                    if(map[i][j]=='.')map[i][j]=(char)(cnt+'0');
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(visited[i][j]);
                }
                System.out.println();
            }

            int total=0;
            //0 이 뭉쳐있는것들 방문처리, 0옆에 붙어있는거 방문처리
            for(int i=0 ; i<n ; i++) {
                for(int j=0 ;j<n; j++) {
                    if(map[i][j]=='0' && visited[i][j]==false) {
                        bfs(i,j);
                        total+=1;
                    }
                }
            }
            // 나머지 방문 안된것들만 더하기
            for(int i=0 ; i<n ; i++) {
                for(int j=0 ;j<n; j++) {
                    if(visited[i][j]==false) {
                        total+=1;
                    }
                }
            }
            System.out.println("#"+t+" "+total);
        }

    }
    private static void bfs(int i, int j) {
        // TODO Auto-generated method stub
        queue.add(new int[] {i,j});
        visited[i][j]=true;
        //bfs
        while(!queue.isEmpty()) {
            int[] cur=queue.poll();
            int x=cur[0];
            int y=cur[1];
            for(int k=0; k<8 ; k++) {
                int nx=x+dx[k];
                int ny=y+dy[k];
                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                // 0일 경우
                if(visited[nx][ny]==false &&map[nx][ny]=='0') {
                    visited[nx][ny]=true;
                    queue.add(new int[] {nx,ny});
                }
                //0이 아닐경우
                else if(visited[nx][ny]==false && map[nx][ny]!='0') {
                    visited[nx][ny]=true;
                }
            }
        }

    }

}