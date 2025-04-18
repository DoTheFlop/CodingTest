import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int answer = 0;

        for(int i = 0 ; i < N ; i++) {
            int width = sc.nextInt();
            int height = sc.nextInt();

            if(width == 136){
                answer += 1000;
            }else if(width == 142){
                answer += 5000;
            }else if (width == 148){
                answer += 10000;
            }else if (width == 154){
                answer += 50000;
            }
        }
        System.out.println(answer);
    }
}
