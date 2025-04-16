import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int lenN = N.length();

        boolean allNines = true;
        for (int i = 0; i < lenN; i++) {
            if (N.charAt(i) != '9') {
                allNines = false;
                break;
            }
        }
        if(allNines) {
            BigInteger temp = new BigInteger(N);
            System.out.println(temp.add(new BigInteger("2")));
            return;
        }

        int halfLen = (lenN + 1) / 2;
        String halfNStr = N.substring(0, halfLen);
        String candidate1;
        StringBuilder reversedHalf = new StringBuilder(halfNStr).reverse();

        if (lenN % 2 != 0) {
            candidate1 = halfNStr + reversedHalf.substring(1);
        } else {
            candidate1 = halfNStr + reversedHalf.toString();
        }

        BigInteger nBig = new BigInteger(N);
        BigInteger cand1Big = new BigInteger(candidate1);

        if (cand1Big.compareTo(nBig) > 0) {
            System.out.println(candidate1);
        } else {
            BigInteger halfBig = new BigInteger(halfNStr);
            halfBig = halfBig.add(BigInteger.ONE);
            String incrementedHalfStr = halfBig.toString();

            String candidate2;
            StringBuilder reversedIncrementedHalf = new StringBuilder(incrementedHalfStr).reverse();

            if (lenN % 2 != 0) {
                candidate2 = incrementedHalfStr + reversedIncrementedHalf.substring(1);
            } else {
                candidate2 = incrementedHalfStr + reversedIncrementedHalf.toString();
            }
            System.out.println(candidate2);
        }
    }
}
