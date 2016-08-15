//https://www.hackerrank.com/challenges/strange-code
import java.util.*;

public class strange_code {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tStr = in.next();

        java.math.BigInteger t = new java.math.BigInteger(tStr);

        java.math.BigInteger  index = new java.math.BigInteger("1");
        java.math.BigInteger  distance = new java.math.BigInteger("3");

        while(index.add(distance).compareTo(t) == -1) {
            index = index.add(distance);
            distance = distance.add(distance);
        }

        java.math.BigInteger two = new java.math.BigInteger("2");
        System.out.println( 0 == index.add(distance).compareTo(t) ? t.add(two) : index.add(index).add(two).subtract(t));
    }
}
