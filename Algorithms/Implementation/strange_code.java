//https://www.hackerrank.com/challenges/strange-code
import java.util.*;

public class strange_code {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        int index = 1;
        int distance = 3;

        while(index + distance < t) {
            index += distance;
            distance = 2 * distance;
        }

        System.out.println( t == (index + distance) ? (t + 2) : (2 * index + 2 - t));
    }
}
