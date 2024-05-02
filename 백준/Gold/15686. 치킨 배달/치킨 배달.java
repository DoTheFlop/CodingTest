import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int ANS = Integer.MAX_VALUE;
	static boolean[] open;
	static ArrayList<int[]> house;
	static ArrayList<int[]> chicken;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		int[][] map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					house.add(new int[] {i, j});
				}else if(map[i][j] == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		open = new boolean[chicken.size()];
		dfs(0, 0);
		
		System.out.println(ANS);
	}

	
	public static void dfs(int start, int cnt) {
		if(cnt == M) {
			int res = 0;
			
			for(int i = 0; i < house.size(); i++) {
				int temp = Integer.MAX_VALUE;
				for(int j = 0; j < chicken.size(); j++) {
					if(open[j]) {
						int distance = Math.abs(house.get(i)[0] - chicken.get(j)[0]) + Math.abs(house.get(i)[1] - chicken.get(j)[1]);
						temp = Math.min(temp, distance);
					}
				}
				res += temp;
			}
			
			ANS = Math.min(ANS, res);
		}
		
		for(int i = start; i < chicken.size(); i++) {
			open[i] = true;
			dfs(i + 1, cnt + 1);
			open[i] = false;
		}
		
	}
}