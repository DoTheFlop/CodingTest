/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution2
{
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\ghtjd\\Desktop\\SW\\test1\\sample_input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();;
            int answer = 1;

            int max_height = 0;

            int[][] graph = new int[n][n];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    graph[i][j] = sc.nextInt();
                    if(max_height < graph[i][j]) max_height = graph[i][j];
                }
            }

            for(int k = 0; k < max_height;k++){
                int now_answer = 0;
                int[][] visited = new int[n][n];
                for (int x = 0; x < n;x++){
                    for(int y = 0; y < n; y++){
                        if (graph[y][x] <= k) visited[y][x] = 1;
                    }
                }

                for (int x = 0; x < n;x++){
                    for(int y = 0; y < n; y++){
                        if (visited[y][x] == 0){
                            bfs(n,x,y,visited);
                            now_answer+=1;
                        }
                    }
                }

                answer = Math.max(answer,now_answer);
            }
            System.out.println("#"+test_case+" " + answer);
        }


    }

    public static void bfs(int n, int a, int b,int[][] visited) {
        Queue<int[]> queue = new LinkedList<int[]>();

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};

        int [] point = {a,b};

        queue.add(point);

        while(queue.size() != 0) {
            int [] p = queue.poll();
            int x = p[0];
            int y = p[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ( -1 < nx && nx < n && -1 < ny && ny < n && visited[ny][nx] == 0){
                    queue.add(new int[] {nx,ny});
                    visited[ny][nx] = 1;
                }
            }
        }
    }
}