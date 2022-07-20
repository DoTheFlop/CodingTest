import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str;
            StringTokenizer st;
            int N = sc.nextInt();
            int M = sc.nextInt();
            int L = sc.nextInt();

            List<Integer> list = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                list.add(sc.nextInt());
            }
            sc.nextLine();
            for(int i = 0; i < M; i++){
                str = sc.nextLine();
                st = new StringTokenizer(str, " ");
                String order = st.nextToken();
                int index = Integer.parseInt(st.nextToken());
                int num;
                switch (order) {
                    case "I":
                        num = Integer.parseInt(st.nextToken());
                        list.add(index, num);
                        break;

                    case "D":
                        list.remove(index);
                        break;

                    case "C":
                        num = Integer.parseInt(st.nextToken());
                        list.set(index, num);
                        break;
                }
            }
            if(list.size() < L){
                System.out.println("#" + test_case + " -1");
            }else
                System.out.println("#" + test_case + " " + list.get(L));
        }
    }
}