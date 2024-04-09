import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static class Word{
        String type;
        String word;
        int time;

        public Word(String type, String word, int time) {
            this.type = type;
            this.word = word;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayDeque<Word> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            Word wordInput = new Word(sc.next(), sc.next(), sc.nextInt());
            stack.push(wordInput);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Word cur = stack.pop();
            if (cur.type.equals("undo")) {
                int b = Integer.parseInt(cur.word);
                int c = cur.time;
                int limit = c - b;
                while (true) {
                    Word word = stack.peek();
                     if (stack.isEmpty() || word.time < limit) {
                        break;
                    }else if (word.time >= limit) {
                        stack.pop();
                    }
                }
            } else {
                sb.append(cur.word);
            }
        }

        System.out.println(sb.reverse());
    }
}
