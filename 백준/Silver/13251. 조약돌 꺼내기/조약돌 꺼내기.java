import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int[] num = new int[M];
        int sum = 0;
        for(int i = 0; i < M; i++ ){
            num[i] = sc.nextInt();
            sum += num[i];
        }

        int K = sc.nextInt();

        double result = 0;

        for(int i = 0; i < M; i++){
            double temp = sum;
            double ttt = 1;
            for(int j = 0; j < K; j++){
                ttt *= (num[i]--)/(temp--);
            }
            result += ttt;
        }
        System.out.println(result);
    }
}