import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
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

            String[] name = new String[N];

            for (int i = 0; i < N; i++) {
                name[i] = sc.next();
            }

            Arrays.sort(name, new Comparator<String>() { //comparator로 정렬 순서 커스텀
                public int compare(String o1, String o2) {
                    if (o1.length() != o2.length()) {
                        return o1.length() - o2.length();
                    } else {
                        return o1.compareTo(o2);
                    }
                }
            });

            System.out.println("#" + test_case);

            String temp = null;
            for (int i = 0; i < N; i++) {
                if(!name[i].equals(temp)){
                    System.out.println(name[i]);
                }
                temp = name[i];
            }
        }
    }
}