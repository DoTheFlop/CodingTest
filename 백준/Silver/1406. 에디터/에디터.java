import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());

		Stack<String> leftSt = new Stack<String>();
		Stack<String> rightSt = new Stack<String>();

		String[] arr = str.split("");
		for (String s : arr) {
			leftSt.push(s);
		}

		for (int i = 0; i < M; i++) {
			String command = br.readLine();
			char c = command.charAt(0);

			switch (c) {
			case 'L':
				if (!leftSt.isEmpty())
					rightSt.push(leftSt.pop());

				break;
			case 'D':
				if (!rightSt.isEmpty())
					leftSt.push(rightSt.pop());

				break;
			case 'B':
				if (!leftSt.isEmpty()) {
					leftSt.pop();
				}
				break;
			case 'P':
				char t = command.charAt(2);
				leftSt.push(String.valueOf(t));
				// leftSt.push(st.nextToken());

				break;
			default:
				break;
			}
		}

		StringBuilder sb = new StringBuilder();

		while (!leftSt.isEmpty())
			rightSt.push(leftSt.pop());

		while (!rightSt.isEmpty())
			sb.append(rightSt.pop());

		System.out.println(sb.toString());
	}
}
