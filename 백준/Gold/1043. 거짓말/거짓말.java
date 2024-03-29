import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int N, M;
    public static int[] parents;
    public static ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        parents = new int[N + 1];
        for(int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }

        int knowPeopleCnt = sc.nextInt();

        if (knowPeopleCnt == 0) {
            System.out.println(M);
            return;
        } else {
            list = new ArrayList<>();
            for (int i = 0; i < knowPeopleCnt; i++) {
                list.add(sc.nextInt());
            }
        }

        ArrayList<Integer>[] partyList = new ArrayList[M];
        for(int i = 0; i < M; i++) {
            partyList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            int partyPeopleCnt = sc.nextInt();

            int x = sc.nextInt();
            partyList[i].add(x);
            for(int j = 1; j < partyPeopleCnt; j++) {
                int y = sc.nextInt();
                union(x,y);
                partyList[i].add(y);
            }
        }

        int cnt = 0;
        for(int i = 0; i < M; i++) {
            boolean flag = true;
            for(int num : partyList[i]) {
                if(list.contains(find(parents[num]))) {
                    flag= false;
                    break;
                }
            }
            if(flag) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static int find(int x) {
        if(parents[x] == x ) return x;
        return find(parents[x]);
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if(list.contains(ry)) {
            int tmp = rx;
            rx = ry;
            ry =tmp;
        }

        parents[ry] = rx;
    }
}
