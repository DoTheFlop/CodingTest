import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split("");
        int answer = 1;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(words[words.length-1-i])){
                continue;
            }else{
                answer = 0;
                break;
            }
        }
        System.out.println(answer);
    }
}
