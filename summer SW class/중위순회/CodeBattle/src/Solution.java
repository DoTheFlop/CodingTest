import java.util.*;
import java.io.*;


class Solution
{

    static int N;
    static StringBuilder answer;
    static String[] tree;

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            answer = new StringBuilder();
            String str;
            str = sc.nextLine();
            StringTokenizer st;
            st = new StringTokenizer(str, " ");

            N = Integer.parseInt(st.nextToken());
            tree = new String[N+1];

            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(sc.nextLine());
                st.nextToken();
                String data = st.nextToken();
                tree[i] = data;
            }
            inOrder(1);
            System.out.println("#" + test_case + " " + answer.toString());
        }
    }

    static void inOrder(int index) {
        if(index > N) {
            return;
        }
        inOrder(2 * index);
        answer.append(tree[index]);
        inOrder(2 * index + 1);
    }
}