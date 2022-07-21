class UserSolution {

    static int[][] map;
    static int[][] visited;
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    static int N;


    void bfs_init(int map_size, int map[][]) {
        this.map = map;
        visited = new int[map_size][map_size];
        N = map_size;
    }

    int bfs(int x1, int y1, int x2, int y2) {
        x1--; x2--; y1--; y2--;
        ArrayQueue q = new ArrayQueue();

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == 1) {
                    visited[y][x] = 1;
                }
                else visited[y][x] = 0;
            }
        }

        q.push(new int[]{y1, x1});

        while(!q.queueIsEmpty()) {
            int[] position = q.pop();
            int py = position[0];
            int px = position[1];

            for(int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx > -1 && ny > -1 && nx < N && ny < N && visited[ny][nx] == 0){
                    visited[ny][nx] = visited[py][px] + 1;
                    if(ny == y2 && nx == x2){
                        return visited[ny][nx];
                    }
                    q.push(new int[] {ny,nx});
                }
            }
        }
        return -1;
    }

    public class ArrayQueue {
        int MAX = 1000;
        int front;
        int rear;
        int [][] queue;
        public ArrayQueue() {
            front = rear = 0;    //초기값 0
            queue = new int[MAX][MAX]; //배열 생성
        }

        public boolean queueIsEmpty() {
            return front == rear;
        }
        public void push(int[] value) {
            queue[rear++] = value;
        }
        public int[] pop() {
            int[] popValue = queue[front++];
            return popValue;
        }
    }
}
