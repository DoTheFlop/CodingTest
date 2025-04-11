import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] nums = new int[N][M];

        int answer = -1;

        for(int i = 0; i < N; i++){
            String[] lines = sc.next().split("");
            for(int j = 0; j < M; j++){
                nums[i][j] = Integer.parseInt(lines[j]);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int k = -N; k < N; k++){
                    for(int q = -M; q < M; q++){
                        if(k == 0 && q == 0){
                            continue;
                        }

                        int num = 0;
                        int di = i;
                        int dj = j;

                        while(di >= 0 && di < N && dj >= 0 && dj < M){
                            num = num * 10 + nums[di][dj];

                            if(check(num)){
                                answer = Math.max(answer, num);
                            }
                            di += k;
                            dj += q;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean check(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
