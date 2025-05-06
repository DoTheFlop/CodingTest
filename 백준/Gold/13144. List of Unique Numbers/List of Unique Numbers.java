import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N + 1];
        int[] visited = new int[100001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int l = 1;
        int r = 0;

        while(l <= N){
            while(r + 1 <= N && visited[numbers[r + 1]] == 0){
                r++;
                visited[numbers[r]]++;
            }

            answer += r - l + 1;
            visited[numbers[l++]]--;
        }
        System.out.println(answer);
    }
}
