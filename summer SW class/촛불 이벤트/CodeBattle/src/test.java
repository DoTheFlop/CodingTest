import java.io.*;

public class test {

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; ++t) {

            long num = Long.parseLong(br.readLine());
            long result = 0;
            long index = -1;

            for(long n=(long)Math.sqrt(num*2); ; ++n) {
                result = (n*(n+1))/2;
                if( result == num ){
                    index = n;
                    break;
                }else if( result > num ){
                    break;
                }
            }
            bw.write("#"+t+" "+index+"\n");
        }
        br.close();
        bw.close();
    }

}