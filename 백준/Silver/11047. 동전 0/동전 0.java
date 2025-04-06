import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] coins = new int[N];

        for(int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        int answer = 0;

        for (int i = N-1; i >= 0; i--) {
            if(coins[i] > K){
                continue;
            }
            answer += K / coins[i];
            K %= coins[i];
        }

        System.out.println(answer);
    }
}
