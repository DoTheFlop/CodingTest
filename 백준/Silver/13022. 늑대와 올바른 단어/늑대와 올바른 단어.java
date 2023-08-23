import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 1;

        char cur;
        char[] wolf = sc.next().toCharArray();
        int index = 0;
        int[] wordCnt = new int[4];
        if(wolf.length < 4 || wolf[0] != 'w'){
            System.out.println(0);
            return;
        }

        cur = wolf[index];
        wordCnt[index]++;

        for(int i = 1; i < wolf.length; i++){
            if (cur == wolf[i]) {
                wordCnt[index]++;
            }else if (cur == 'w' && wolf[i] == 'o') {
                cur = wolf[i];
                wordCnt[++index]++;
            } else if (cur == 'o' && wolf[i] == 'l') {
                if(wordCnt[0] != wordCnt[1]){
                    answer = 0;
                    break;
                }
                cur = wolf[i];
                wordCnt[++index]++;
            } else if (cur == 'l' && wolf[i] == 'f') {
                if(!(wordCnt[0] == wordCnt[1] && wordCnt[1] == wordCnt[2])){
                    answer = 0;
                    break;
                }
                cur = wolf[i];
                wordCnt[++index]++;
            } else if (cur == 'f' && wolf[i] == 'w') {
                if(!(wordCnt[0] == wordCnt[1] && wordCnt[1] == wordCnt[2] && wordCnt[2] == wordCnt[3])){
                    answer = 0;
                    break;
                }
                index = 0;
                cur = wolf[i];
                wordCnt = new int[4];
                wordCnt[index]++;
            } else {
                answer = 0;
                break;
            }
        }
        if(cur != 'f'){
            answer = 0;
        }
        if(!(wordCnt[0] == wordCnt[1] && wordCnt[1] == wordCnt[2] && wordCnt[2] == wordCnt[3])){
            answer = 0;
        }
        System.out.println(answer);
    }
}