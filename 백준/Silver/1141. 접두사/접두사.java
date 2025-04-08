import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] words = new String[N];

        for(int i = 0; i < N; i++) {
            words[i] = sc.next();
        }

        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());

        HashSet<String> set = new HashSet<>();

        set.add(words[0]);

        for(int i = 1; i < N; i++) {
            boolean prefixTrue = false;

            for(String word : set) {
                if(word.startsWith(words[i])) {
                    prefixTrue = true;
                    break;
                }
            }

            if(!prefixTrue) {
                set.add(words[i]);
            }
        }

        System.out.println(set.size());
    }
}
