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
            Queue<Integer> min = new PriorityQueue<Integer>();
            Queue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
            int sum = 0;

            int N = sc.nextInt();
            int A = sc.nextInt();

            if (max.size() == min.size()) {
                max.add(A);
                if (!min.isEmpty() && max.peek() > min.peek()) {
                    min.add(max.poll());
                    max.add(min.poll());
                }
            }
            else{
                min.add(A);
                if (max.peek() > min.peek()) {
                    min.add(max.poll());
                    max.add(min.poll());
                }
            }

            for (int i = 0; i < N; i++){
                for (int j = 0; j < 2; j++) {
                    int X = sc.nextInt();
                    if (max.size() == min.size()) {
                        max.add(X);
                        if (!min.isEmpty() && max.peek() > min.peek()) {
                            min.add(max.poll());
                            max.add(min.poll());
                        }
                    }
                    else{
                        min.add(X);
                        if (max.peek() > min.peek()) {
                            min.add(max.poll());
                            max.add(min.poll());
                        }
                    }
                }
                sum = (sum + max.peek()) % 20171109;
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }
}