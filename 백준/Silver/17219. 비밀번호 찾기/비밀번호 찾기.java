import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		HashMap<String, String> passwd = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			String site = sc.next();
			String password = sc.next();
			passwd.put(site, password);
		}
		for(int i = 0; i < m; i++) {
			System.out.println(passwd.get(sc.next()));
		}
	}
}
