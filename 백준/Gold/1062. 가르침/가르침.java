import java.util.Scanner;

public class Main {

    static String[] words;
    static boolean[] visited = new boolean[26];
    static int N, K;
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
           
        sc.nextLine();
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.nextLine();
            words[i] = words[i].replace("anta", "");
            words[i] = words[i].replace("tica", "");
        }

        if(K < 5) {
            System.out.println("0");
            return;
        } else if(K == 26) {
            System.out.println(N);
            return;
        }

        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int word, int index){
        if(index == K - 5){
            int count = 0;
            for(int i = 0; i < N; i++){
                boolean readable = true;
                for(int j = 0; j < words[i].length(); j++){
                    if(!visited[words[i].charAt(j) - 'a']){
                        readable = false;
                        break;
                    }
                }
                if(readable){
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        for(int i = word; i < 26; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, index + 1);
                visited[i] = false;
            }
        }
    }
}
