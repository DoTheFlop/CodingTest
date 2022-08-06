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
            int N = sc.nextInt();
            int q = sc.nextInt();

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < q; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                if (a == 0) {
                    arr[b] = c;
                } else {
                    int max = Integer.MIN_VALUE;
                    int min = Integer.MAX_VALUE;
                    int[] ints = Arrays.copyOfRange(arr, b, c);
                    for (int k = 0; k < ints.length; k++) {
                        if (ints[k] > max) {
                            max = ints[k];
                        }
                        if (ints[k] < min) {
                            min = ints[k];
                        }
                    }
                    System.out.print((max - min) + " ");
                }
            }

            System.out.println();
        }
    }
}