import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    static long A, B;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();

        System.out.println(bfs());
    }

    static int bfs(){
        ArrayDeque<Long> q = new ArrayDeque<>();
        q.add(A);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i < size; i++){
                long tmp = q.poll();
                if(tmp == B)
                    return cnt + 1;

                if(tmp * 2 <= B) q.offer(tmp * 2);
                if(tmp * 10 + 1 <= B) q.offer(tmp * 10 + 1);
            }
            cnt++;
        }
        return -1;
    }
}
