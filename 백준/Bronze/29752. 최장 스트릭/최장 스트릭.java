import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int strict = 0;
        int answer = 0;

        for(int i = 0; i < N; i++){
            if(sc.nextInt() == 0){
                strict = 0;
            }else{
                strict++;
                answer = Math.max(answer, strict);
            }
        }

        System.out.println(answer);
    }
}
