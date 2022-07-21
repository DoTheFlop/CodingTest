import java.util.*;
import java.io.*;


class Solution
{
    static StringBuilder answer;
    static int V;
    static int count;

    static Node[] tree;
    static int[] visited;
    public static int result;

    public static class Node{
        int data;

        Integer parent;
        Integer left;
        Integer right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        System.out.println("T = " + T);
        for(int test_case = 1; test_case <= T; test_case++)
        {
            answer = new StringBuilder();
            String str;
            str = sc.nextLine();
            StringTokenizer st;
            st = new StringTokenizer(str, " ");
            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int aNode = Integer.parseInt(st.nextToken());
            int bNode = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(sc.nextLine(), " ");

            tree = new Node[V+1];
            visited = new int[V + 1];

            for (int i = 0; i <= V; i++) {
                tree[i] = new Node(i);
                visited[i] = 0;
            }

            for (int i = 0; i < E; i++) {
                int root = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                if (tree[root].left == null) {
                    tree[root].left = child;
                } else {
                    tree[root].right = child;
                }
                tree[child].parent = root;
                tree[child].data = child;
                tree[root].data = root;
            }


            Node cur = tree[aNode];
            int commonParent = 0;
            for (; ; ) {
                if(tree[cur.data].parent == null) break;
                cur = tree[cur.parent];
                visited[cur.data] = 1;
            }

            cur = tree[bNode];
            int bCount = 0;
            for (; ; ) {
                if(visited[cur.data] == 1){
                    commonParent = cur.data;
                    break;
                }
                if(tree[cur.data].parent == null) break;
                visited[cur.data] = 1;
                cur = tree[cur.parent];
                bCount++;
            }

            count = 0;
            downNode(commonParent);
            System.out.println("#" + test_case + " " + commonParent + " " + count);
        }
    }

    static void downNode(int index) {
        count++;
        if (tree[index].left != null) {
            downNode(tree[index].left);
        }
        if (tree[index].right != null) {
            downNode(tree[index].right);
        }
    }
}