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
            System.out.print("#" + test_case + " ");
            PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                int M = sc.nextInt();

                if (M == 1) {
                    heap.add(sc.nextInt());
                } else {
                    if (heap.isEmpty()) {
                        System.out.print("-1 ");
                    }
                    else {
                        System.out.print(heap.poll() + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}