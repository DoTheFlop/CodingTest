import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution{
    public  static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        
        int T;

        T = sc.nextInt();
        sc.nextLine();

        int R = 1_000_000_007;

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.nextLine();
            int days = str.length();
            long[][] record = new long[days][1 << 4];

            for (int i = 0; i < days; i++){ //{D, C, B, A}
                
                int must = 1 << (str.charAt(i) - 'A'); // 책임자의 비트트
                
                if (i == 0) { // 첫쨋날
                    for(int j = 0; j < 1 << 4; j++) {
                        if ((must & j) > 0 && (j & 1) > 0) { //(j & 1)에서 1은 A, 즉 A가 참석한 경우
                            record[0][j] = 1;
                        }
                    }
                }
                else{
                    for(int j = 0; j < 1 << 4; j++) {
                        if(record[i-1][j] != 0){
                            for(int k = 0; k < 1<<4; k ++){
                                if ((must & k) > 0 && (k & j) > 0) {
                                    record[i][k] += record[i-1][j];
                                    record[i][k] %= 1000000007;
                                }
                            }
                        }
                    }
                }
            }

            long answer = 0;
            for (int i = 0; i < 1 << 4; i++) {
                answer += record[days-1][i];
                answer %= 1000000007;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}