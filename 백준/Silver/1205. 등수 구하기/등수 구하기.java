import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int score = sc.nextInt();
        int P = sc.nextInt();

        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr, Collections.reverseOrder());

        if (N == P && score <= arr[arr.length - 1]) {
            System.out.println(-1);
        } else {
            int rank = 1;
            for (int i = 0; i < N; i++) {
                if (score < arr[i]) {
                    rank++;
                } else {
                    break;
                }
            }
            System.out.println(rank);
        }
    }
}
