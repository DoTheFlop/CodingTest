import java.util.*;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++) {
            String str;
            StringTokenizer st;
            str = sc.nextLine();
            st = new StringTokenizer(str, " ");
            int N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(sc.nextLine(), " ");
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(sc.nextLine(), " ");
            int M = Integer.parseInt(st.nextToken());

            int x, y, s;
            st = new StringTokenizer(sc.nextLine(), " ");
            for (int i = 0; i < M; i++) {
                String order = st.nextToken();
                switch (order) {
                    case "I":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for (int j = x; j < x+y; j++){
                            s = Integer.parseInt(st.nextToken());
                            list.add(j, s);
                        }
                        break;

                    case "D":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < y; j++){
                            list.remove(x);
                        }
                        break;

                    case "A":
                        y = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < y; j++){
                            s = Integer.parseInt(st.nextToken());
                            list.add(list.size(), s);
                        }
                        break;
                }
            }
            System.out.print("#" + test_case + " ");
            for(int i = 0; i < 10; i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}