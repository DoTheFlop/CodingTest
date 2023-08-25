import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		List<String> gwal = new ArrayList<>(Arrays.asList("[", "]", "(", ")"));
		String[] in = s.split("");
		ArrayDeque<String> stack = new ArrayDeque<>();

		Map<String, Integer> map = new HashMap<>();
		for (String t : in) {
			map.put(t, map.getOrDefault(t, 0) + 1);
			stack.push(t);
		}

		if (
			!map.getOrDefault("(", 0).equals(map.getOrDefault(")", 0)) ||
				!map.getOrDefault("[", 0).equals(map.getOrDefault("]", 0))) {
			System.out.println("0");
			return;
		}

		ArrayDeque<String> stack2 = new ArrayDeque<>();
		int result = 0;
		while (true) {

			if (stack.isEmpty() && !stack2.isEmpty()) {
				while (!stack2.isEmpty()) {
					stack.push(stack2.pop());
				}
				continue;
			}

			String cur = stack.pop();

			// 올바르지 않는 괄호의 경우
			if (!stack.isEmpty()) {
				if (stack.peek().equals("(") && cur.equals(")")) {
					stack.pop();
					stack2.push(String.valueOf(2));
					continue;
				}

				if (stack.peek().equals("[") && cur.equals("]")) {
					stack.pop();
					stack2.push(String.valueOf(3));
					continue;
				}

				if (stack.peek().equals("(") && cur.equals("]")) {
					System.out.println(0);
					return;
				}

				if (stack.peek().equals("[") && cur.equals(")")) {
					System.out.println(0);
					return;
				}
			}

			// 뽑은 문자가 마지막 숫자의 경우 출력
			if (stack.isEmpty() && stack2.isEmpty()) {
				System.out.println(cur);
				return;
			}

			if (stack2.isEmpty()) {
				stack2.push(cur);
				continue;
			}

			if (stack.isEmpty() && stack2.size() == 1) {
				result = Integer.parseInt(cur) + Integer.parseInt(stack2.pop());
				break;
			}

			// 문자가 괄호일 경우
			if (gwal.contains(cur)) {
				stack2.push(cur);
				continue;
			}

			if (stack.isEmpty()) {
				stack2.push(cur);
				continue;
			}

			if (!gwal.contains(cur) && !gwal.contains(stack2.peek())) {
				stack2.push(String.valueOf(Integer.parseInt(cur) + Integer.parseInt(stack2.pop())));
				continue;
			}

			if (stack.peek().equals("(") && stack2.peek().equals(")")) {
				stack.pop();
				stack2.pop();
				stack2.push(String.valueOf(Integer.parseInt(cur) * 2));
				continue;
			}

			if (stack.peek().equals("[") && stack2.peek().equals("]")) {
				stack.pop();
				stack2.pop();
				stack2.push(String.valueOf(Integer.parseInt(cur) * 3));
				continue;
			}

			if (stack.peek().equals("(") && stack2.peek().equals("]")) {
				System.out.println(0);
				return;
			}

			if (stack.peek().equals("[") && stack2.peek().equals(")")) {
				System.out.println(0);
				return;
			}

			stack2.push(cur);

		}
		System.out.println(result);
	}
}
