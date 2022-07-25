import java.io.FileInputStream;
import java.util.*;

class Solution
{

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        int N, Ni;
        T=sc.nextInt();
        ArrayList<Integer> number = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        Set<Integer> set = new HashSet<>();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            set.clear();
            N = sc.nextInt();
            ArrayList<Integer> intArray;

            for(int i = 1; ; i++) {
                Ni = N*i;
                for(int temp = Ni; temp > 0; temp /= 10) {
                    set.add(temp % 10);
                }
                if(set.size() == 10) break;
            }

            System.out.println("#" + test_case + " " + Ni);
        }
    }
}