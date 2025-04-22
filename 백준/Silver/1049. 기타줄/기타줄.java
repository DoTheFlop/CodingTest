import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int stringPackagePrice = Integer.MAX_VALUE;
        int stringPrice = Integer.MAX_VALUE;
        for(int i = 0; i< M; i++){
            stringPackagePrice = Math.min(stringPackagePrice, sc.nextInt());
            stringPrice = Math.min(stringPrice, sc.nextInt());
        }
        int answer = Integer.MAX_VALUE;
        answer = Math.min( (N / 6 + 1)* stringPackagePrice, N * stringPrice);
        answer = Math.min( N / 6 * stringPackagePrice + N % 6 * stringPrice, answer);
        System.out.println(answer);
    }
}
