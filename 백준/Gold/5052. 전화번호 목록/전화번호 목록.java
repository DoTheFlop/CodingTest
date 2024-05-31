import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int testCase = 0; testCase < t; testCase++) {
			int n = sc.nextInt();

			String[] numbers = new String[n];

			for (int i = 0; i < n; i++) {
				numbers[i] = sc.next();
			}

			Arrays.sort(numbers);

			if (extracted(n, numbers)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static boolean extracted(int n, String[] numbers) {
		for (int i = 0; i < n - 1; i++) {
			if (numbers[i + 1].startsWith(numbers[i])) {
				return false;
			}
		}

		return true;
	}
}
