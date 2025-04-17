import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] team1 = new int[N];
        int[] team2 = new int[N];

        int team1WinStreak = 0;
        int team2WinStreak = 0;

        int team1MaxWinStreak = 0;
        int team2MaxWinStreak = 0;

        for(int i = 0; i < N; i++) {
            team1[i] = sc.nextInt();
        }
        for(int i = 0; i < N; i++) {
            team2[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++) {
            if(RSP(team1[i], team2[i]) == 1) {
                team1WinStreak++;
                team2WinStreak = 0;
            }else if(RSP(team1[i], team2[i]) == 2) {
                team2WinStreak++;
                team1WinStreak = 0;
            }else{
                if(team1WinStreak == 0){
                    team1WinStreak++;
                    team2WinStreak = 0;
                } else if (team2WinStreak == 0) {
                    team2WinStreak++;
                    team1WinStreak = 0;
                }
            }
            team1MaxWinStreak = Math.max(team1WinStreak, team1MaxWinStreak);
            team2MaxWinStreak = Math.max(team2WinStreak, team2MaxWinStreak);
        }
        System.out.println(Math.max(team1MaxWinStreak, team2MaxWinStreak));
    }

    public static int RSP(int team1, int team2) {
        if(team1 == 1 && team2 == 2) {
            return 2;
        }else if(team1 == 2 && team2 == 3) {
            return 2;
        }else if(team1 == 3 && team2 == 1) {
            return 2;
        }else if(team1 == team2) {
            return 3;
        }
        return 1;
    }
}
