import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static class Room{
        String type;
        int money;
        ArrayList<Integer> toRoom;
        boolean visit;

        public Room(String type, int money, ArrayList<Integer> toRoom) {
            this.type = type;
            this.money = money;
            this.toRoom = toRoom;
        }
    }
    static Room[] rooms;
    static int n;
    static boolean clear = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            n = sc.nextInt();

            if (n == 0) {
                break;
            }

            clear = false;
            rooms = new Room[n];

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int money = sc.nextInt();
                ArrayList<Integer> toRoom = new ArrayList<>();
                int in = sc.nextInt();
                while(in != 0){
                    toRoom.add(in);
                    in = sc.nextInt();
                }
                rooms[i] = new Room(type, money, toRoom);
            }

            dfs(0, 0);

            if (!clear) {
                System.out.println("No");
            }
        }
    }

    public static void dfs(int roomNum, int money) {

        if (rooms[roomNum].type.equals("T")) { // 트롤방이면 돈 빼앗김
            if (money < rooms[roomNum].money) { // 돈 모자르면 실패
                return;
            }
            money -= rooms[roomNum].money;
        }else if (rooms[roomNum].type.equals("L")) { // 해당 방이 레프리콘 방이면 돈 관련 처리
            if (money < rooms[roomNum].money) {
                money = rooms[roomNum].money;
            }
        }

        if (clear) {
            return;
        } else if (roomNum == n - 1) { // 마지막 방 도착
            clear = true; // 성공처리
            System.out.println("Yes");
        }
        rooms[roomNum].visit = true; // 방 방문 처리
        

        // 방문하지 않은 방 탐색
        for (int i = 0; i < rooms[roomNum].toRoom.size(); i++) {
            if (rooms[rooms[roomNum].toRoom.get(i) - 1].visit) {
                continue;
            }
            dfs(rooms[roomNum].toRoom.get(i) - 1, money);
        }

        rooms[roomNum].visit = false; // 다른 dfs를 위해 원복
    }
}
