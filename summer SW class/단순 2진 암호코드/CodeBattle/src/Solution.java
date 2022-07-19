
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            String codeForUse = "";
            List<String> codeList = new ArrayList<>(7);
            for (int i = 0; i < N; i++) {
                String code = sc.next();
                for (int j = M - 1; j >= 0; j--) {
                    if(code.charAt(j) == '1'){
                        codeForUse = code.substring(j - 55, j + 1);
                        break;
                    }
                }
            }
            System.out.println("#" + test_case + " " + valid(codeForUse));
        }
    }

    public static int valid(String codeForUse){
        ArrayList<String> codeNum = new ArrayList<>(Arrays.asList("0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"));
        int[] decode = new int[8];

        decode[0] = codeNum.indexOf(codeForUse.substring(0, 7));
        for(int i = 1; i < 8; i++){
            decode[i] = codeNum.indexOf(codeForUse.substring(i*7, i*7+7));
        }
        int result = ((decode[0] + decode[2] + decode[4] + decode[6]) * 3) + (decode[1] + decode[3] + decode[5]) + decode[7];
        if (result % 10 == 0) {
            int sum = 0;
            for (int i : decode) {
                sum += i;
            }
            return sum;
        }
        else return 0;
    }
}