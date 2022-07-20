import java.util.*;
import java.io.*;


class Solution
{
    static int N;
    static StringBuilder answer;

    static List<Node> tree;
    public static int result;

    public static class Node{
        String data;
        Integer left;
        Integer right;

        public Node(String data, Integer left, Integer right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            tree = new LinkedList<>();
            answer = new StringBuilder();
            String str;
            str = sc.nextLine();
            StringTokenizer st;
            st = new StringTokenizer(str, " ");

            N = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= N; i++) {
                tree.add(null);
            }

            for (int i = 0; i < N; i++) {
                str = sc.nextLine();
                st = new StringTokenizer(str, " ");
                int key = Integer.parseInt(st.nextToken());
                String data = st.nextToken();

                if (data.equals("*") || data.equals("+") || data.equals("-") || data.equals("/")) {
                    int left = Integer.parseInt(st.nextToken());
                    int right = Integer.parseInt(st.nextToken());
                    tree.set(key, new Node(data, left, right));
                }
                else{
                    tree.set(key, new Node(data, null, null));
                }
            }
            System.out.println("tree = " + calculate(1));
        }
    }

    public static int calculate(int cur) {
        Node curNode = tree.get(cur);
        String data = curNode.data;

        if (data.equals("+"))
            result = calculate(curNode.left) + calculate(curNode.right);
        else if (data.equals("-"))
            result = calculate(curNode.left) - calculate(curNode.right);
        else if (data.equals("*"))
            result = calculate(curNode.left) * calculate(curNode.right);
        else if (data.equals("/"))
            result = calculate(curNode.left) / calculate(curNode.right);
        else result = Integer.parseInt(curNode.data);

        return result;
    }
}