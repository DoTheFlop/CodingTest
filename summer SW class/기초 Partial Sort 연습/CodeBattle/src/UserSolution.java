import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserSolution {

    ArrayList<user> userList;

    public class user{
        int uID;
        int income;

        public user(int uID, int income) {
            this.uID = uID;
            this.income = income;
        }
    }
    Comparator<user> comparator = new Comparator<user>() {
        @Override
        public int compare(user o1, user o2) {
            if (o1.income != o2.income) {
                return o2.income - o1.income;
            }
            return 0;
        }
    };

    public void init() {
        userList = new ArrayList<>();
    }

    public void addUser(int uID, int income) {
        userList.add(new user(uID, income));
    }

    int getTop10(int[] result) {
        Collections.sort(userList, comparator);
        int answer = 0;
        if (userList.size() >= 10) {
            for (int i = 0; i < 10; i++) {
                result[i] = userList.get(i).uID;
                answer++;
            }
        } else {
            for (int i = 0; i < userList.size(); i++) {
                result[i] = userList.get(i).uID;
                answer++;
            }
        }
        return answer;
    }
}