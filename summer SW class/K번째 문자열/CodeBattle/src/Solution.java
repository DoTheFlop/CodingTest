import java.util.*;
import java.io.FileInputStream;

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
            int N = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            HashSet<String> list = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                for (int j = i; j < str.length(); j++) {
                    list.add(str.substring(i, j + 1));
                }
            }
            List<String> answer = new ArrayList<>(list);
            Collections.sort(answer);

            if (N > list.size()) {
                System.out.println("#" + test_case + " none");
            } else {
                System.out.println("#" + test_case + " " + answer.get(N-1));
            }
        }
    }
}