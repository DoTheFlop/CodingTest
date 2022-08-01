import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution
{

    static int[] arr, temp;
    static int answer;

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            answer = 0;
            int N = sc.nextInt();
            arr = new int[N];
            temp = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            mergeSort(0, N - 1);
            System.out.println("#" + test_case + " " + answer);
        }
    }

    public static void mergeSort(int begin, int end) {
        if (begin >= end) return;

        int mid = (begin + end) / 2;
        mergeSort(begin, mid);
        mergeSort(mid + 1, end);
        merge(begin, mid, end);

    }

    public static void merge(int begin, int mid, int end) {
        int begin1 = begin;
        int begin2 = mid + 1;
        int index = begin;

        while(begin1 <= mid || begin2 <= end) {
            if (begin2 > end || (begin1 <= mid && arr[begin1] < arr[begin2])) {
                temp[index++] = arr[begin1++];
            }
            else {
                temp[index++] = arr[begin2++];
                answer += (mid - begin1 + 1);
            }
        }
        for(int i = begin; i <= end; i++) {
            arr[i] = temp[i];
        }
    }
}