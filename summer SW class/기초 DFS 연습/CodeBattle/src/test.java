import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class test {

    static int[][] tree;
    static int nodeCnt=0;
    static int result = -1;



    public void dfs_init(int N, int[][] path) {
        tree = new int[100][100];
        for (int i = 0; i < path.length; i++) {
            tree[path[i][0]][path[i][1]] = 1;
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(tree[i][j] > 0){
                    nodeCnt++;
                }
            }
        }
    }
    public int dfs(int N) {
        ArrayQueue queue = new ArrayQueue();

        for (int i = 0; i < 100; i++) {
            if (tree[N][i] == 1) {
                queue.push(i);
            }
        }
        while (!queue.queueIsEmpty()) {
            int pop = queue.pop();
            if(pop > N){
                return pop;
            }
            else{
                int dfs = dfs(pop);
                if (dfs != -1) {
                    while (!queue.queueIsEmpty()) {
                        queue.pop();
                    }
                    return dfs;
                }
            }
        }
        return -1;
//
//        for (int i = 0; i < 100; i++) {
//            if (tree[N][i] == 1) {
//                if(i > N){
//                    return i;
//                }
//                dfs(i);
//            }
//        }
//        return result;
    }

    public class ArrayQueue {
        int MAX = 1000;
        int front;
        int rear;
        int [] queue;
        public ArrayQueue() {
            front = rear = 0;    //초기값 0
            queue = new int[MAX]; //배열 생성
        }

        public boolean queueIsEmpty() {
            return front == rear;
        }
        public void push(int value) {
            queue[rear++] = value;
        }
        public int pop() {
            int popValue = queue[front++];
            return popValue;
        }
    }

    public class ArrayStack {
        int top;
        int size;
        int [] stack;
        public ArrayStack(int size) {
            this.size = size;
            stack = new int[size];
            top = -1;
        }

        public void push(int item) {
            stack[++top] = item;
        }
        public int pop() {
            int pop = stack[top];
            stack[top--] = 0;
            return pop;
        }
    }
}