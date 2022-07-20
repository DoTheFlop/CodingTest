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
        int T = sc.nextInt();
        sc.nextLine();
        System.out.println("T = " + T);
        for(int test_case = 1; test_case <= T; test_case++)
        {
            tree = new LinkedList<>();
            answer = new StringBuilder();
            String str;
            str = sc.nextLine();
            StringTokenizer st;
            st = new StringTokenizer(str, " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int aNode = Integer.parseInt(st.nextToken());
            int bNode = Integer.parseInt(st.nextToken());
            System.out.println("V + E+ aNode + bNode = " + V + " " + E + " " + aNode + " " + bNode);
            sc.nextLine();

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