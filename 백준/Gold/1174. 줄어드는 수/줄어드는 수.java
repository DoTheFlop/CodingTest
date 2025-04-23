import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int[] numbers = {9,8,7,6,5,4,3,2,1,0};
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        
        dfs(0, 0);
        
        Collections.sort(list);

        if(list.size() >= N) {
            System.out.println(list.get(N - 1));
        }else{
            System.out.println(-1);
        }
    }

    public static void dfs(long num, int index) {
        if(!list.contains(num)) {
            list.add(num);
        }

        if(index >= 10){
            return;
        }

        dfs(num * 10 + numbers[index], index + 1);
        dfs(num, index + 1);
    }
}
