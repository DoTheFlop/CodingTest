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
            String num_math = answer.toString();
            int count = 0;
            int result = 0;
            for (int i = 0; i < num_math.length(); i++) {
                String c = String.valueOf(num_math.charAt(i));

                if (Character.isDigit(c.charAt(0)) && count == 0) {
                    count = 1;
                }
                else if (!Character.isDigit(c.charAt(0))  && count == 1) {
                    count = 0;
                }
                else {
                    result = 0;
                    break;
                }
                result = 1;
            }
            System.out.println("#" + test_case + " " + result);

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