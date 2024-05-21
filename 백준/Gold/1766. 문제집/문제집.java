import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] indegree = new int[N + 1];
		
		HashMap<Integer, ArrayList<Integer>> list = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			list.put(i, new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			indegree[b]++;
			list.get(a).add(b);
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		StringBuilder answer = new StringBuilder();
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			answer.append(cur + " ");
			
			for(int temp : list.get(cur)) {
				indegree[temp]--;
				if(indegree[temp] == 0) {
					q.offer(temp);
				}
			}
		}
		System.out.println(answer.toString());
	}
}
