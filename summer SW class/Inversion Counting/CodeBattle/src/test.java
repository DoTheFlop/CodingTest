import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class test
{

    static int[] arr, temp;

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            arr = new int[N];
            temp = new int[N];
            sc.nextLine();
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println("#" + test_case + " " +  mergeSortAndCount(arr, 0, arr.length - 1));
        }
    }

    private static int mergeAndCount(int[] arr, int l, int m, int r)
    {

        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swaps;
    }

    private static int mergeSortAndCount(int[] arr, int l, int r)
    {
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;

            count += mergeSortAndCount(arr, l, m);

            count += mergeSortAndCount(arr, m + 1, r);

            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }
}