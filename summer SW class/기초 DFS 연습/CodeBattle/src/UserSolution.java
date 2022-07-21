public class UserSolution {

    static int[][] tree;
    static int prev;
    static int result = -1;


    public void dfs_init(int N, int[][] path) {
        tree = new int[100][100];
        for (int i = 0; i < path.length; i++) {
            tree[path[i][0]][path[i][1]] = 1;
        }
    }
    public int dfs(int N) {
        for (int i = 0; i < 100; i++) {
            if (tree[N][i] == 1) {
                if(i > N){
                    return i;
                }
                dfs(i);
            }
        }
        return result;
    }
}