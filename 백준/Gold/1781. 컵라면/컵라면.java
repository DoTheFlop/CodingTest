import java.util.*;

class Problem implements Comparable<Problem> {
    int deadline;
    int cupNoodles;

    public Problem(int deadline, int cupNoodles) {
        this.deadline = deadline;
        this.cupNoodles = cupNoodles;
    }

    @Override
    public int compareTo(Problem other) {
        return Integer.compare(this.deadline, other.deadline);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Problem> problems = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int deadline = sc.nextInt();
            int cupNoodles = sc.nextInt();
            problems.add(new Problem(deadline, cupNoodles));
        }

        Collections.sort(problems);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int totalCupNoodles = 0;

        for (Problem problem : problems) {
            if (pq.size() < problem.deadline) {
                pq.offer(problem.cupNoodles);
                totalCupNoodles += problem.cupNoodles;
            } else if (!pq.isEmpty() && pq.peek() < problem.cupNoodles) {
                totalCupNoodles -= pq.poll();
                pq.offer(problem.cupNoodles);
                totalCupNoodles += problem.cupNoodles;
            }
        }

        System.out.println(totalCupNoodles);
    }
}