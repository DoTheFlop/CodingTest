import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        ArrayList<String> list = new ArrayList<>(set);
        list.sort((s1, s2) -> {
            if(s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }else{
                return s1.length() - s2.length();
            }
        }
        );
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
