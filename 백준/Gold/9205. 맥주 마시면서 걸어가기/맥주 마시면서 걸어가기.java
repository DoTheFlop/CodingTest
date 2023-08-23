import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int n;
	static Point start, goal;
	static Point[] stores;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 0; tc < t; tc++) {
			n = sc.nextInt();
			stores = new Point[n];
			
			start = new Point(sc.nextInt(), sc.nextInt(), false, 0);
			
			for(int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				stores[i] = new Point(x, y, false, Math.abs(start.x - x) + Math.abs(start.y - y));
			}

			goal = new Point(sc.nextInt(), sc.nextInt(), false, 0);
			goal.dist = Math.abs(start.x - goal.x) + Math.abs(start.y - goal.y);
			
			if(bfs()) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
	}
	
	
	public static boolean bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
			return o1.dist - o2.dist;
		});
		
		start.visited = true;
		pq.offer(start);
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			for(Point temp : stores) {
				temp.dist = Math.abs(p.x - temp.x) + Math.abs(p.y - temp.y);
				if(temp.dist <= 1000 && temp.visited == false) {
					pq.offer(temp);
					temp.visited = true;
				}
			}
			goal.dist = Math.abs(p.x - goal.x) + Math.abs(p.y - goal.y);
			if(goal.dist <= 1000) {
				return true;
			}
		}
		return false;
	}
	
	static class Point {
		int x; int y; boolean visited; int dist;

		public Point(int x, int y, boolean visited, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.visited = visited;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", visited=" + visited + ", dist=" + dist + "]";
		}
		
	}
}
