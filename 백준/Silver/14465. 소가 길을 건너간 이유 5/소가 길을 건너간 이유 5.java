import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] signs = new boolean[n];

        for(int i = 0; i < b; i++){
            st = new StringTokenizer(br.readLine());
            int broken = Integer.parseInt(st.nextToken());
            signs[broken - 1] = true;
        }
        int answer = Integer.MAX_VALUE;
        int cnt = 0;
        int left = 0;
        int right;
        for(right = 0 ; right < k; right++){
            if(signs[right] == true){
                cnt++;
            }
        }
        answer = Integer.min(answer, cnt);
        for(; right < n; right++){
            if(signs[right] == true){
                cnt++;
            }
            if(signs[left++] == true){
                cnt--;
            }
            answer = Integer.min(answer, cnt);
        }
        System.out.println(answer);
    }
}
