import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class UserSolution {

    static int[][] child;
    static int childCnt[];
    static int nodeCnt = 0;
    static int result = -1;



    public void dfs_init(int N, int[][] path) {
        child = new int[100][40];
        childCnt = new int[100];
        for (int i = 0; i < N - 1; i++) {
            child[path[i][0]][childCnt[path[i][0]]++] = path[i][1];
        }
    }
    public int dfs(int N) {
        result = -1;
        nodeCnt = 0;
        dfs_rec(N, N);
        return result;
    }

    void dfs_rec(int compare, int n){
        if (nodeCnt == 0 && compare < n) {
            nodeCnt = 1;
            result = n;
        }
        else if (childCnt[n] == 0) return;
        else {
            for (int i = 0; i < childCnt[n]; i++) {
                dfs_rec(compare, child[n][i]);
            }
        }
    }
}