import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] p = new int[n];
        int[] s = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        int[] origin = Arrays.copyOf(p, n);
        int answer = 0;
        while (true) {
            if (check(p, n)) {
                System.out.println(answer);
                return;
            }
            p = mix(p, s, n);
            answer++;
            if (Arrays.equals(p, origin)) {
                System.out.println(-1);
                return;
            }
        }
    }

    public static int[] mix(int[] p, int[] s, int n) {
        int[] tmp = Arrays.copyOf(p, n);
        for (int i = 0; i < n; i++) {
            p[s[i]] = tmp[i];
        }
        return p;
    }

    public static boolean check(int[] p, int n){
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (cur == 3) {
                cur = 0;
            }
            if (p[i] != cur) {
                return false;
            }
            cur++;
        }
        return true;
    }
}
