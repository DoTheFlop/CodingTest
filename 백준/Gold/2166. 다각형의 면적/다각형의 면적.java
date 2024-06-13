import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		long[] x = new long[n + 1];
		long[] y = new long[n + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		long sum1 = 0;
		long sum2 = 0;
		x[n] = x[0];
		y[n] = y[0];

		for (int i = 0; i < n; i++) {
			sum1 += x[i] * y[i + 1];
			sum2 += x[i + 1] * y[i];
		}

		System.out.println(String.format("%.1f", Math.abs(sum1 - sum2) / 2.0));
	}
}
