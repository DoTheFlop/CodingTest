import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] fruits = new int[N];

        for(int i = 0; i < N; i++){
            fruits[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> cnt = new HashMap<>();
        int answer = 0;
        int start = 0;
        for(int end = 0; end < N; end++){
            cnt.put(fruits[end], cnt.getOrDefault(fruits[end], 0) + 1);
            
            while(cnt.size() > 2){
                cnt.put(fruits[start], cnt.get(fruits[start]) - 1);
                if(cnt.get(fruits[start]) == 0){
                    cnt.remove(fruits[start]);
                }
                start++;
            }
            
            answer = Math.max(answer, end - start + 1);
        }

        System.out.println(answer);
    }
}
