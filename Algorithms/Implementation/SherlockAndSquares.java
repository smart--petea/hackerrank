//https://www.hackerrank.com/challenges/sherlock-and-squares
import java.util.Scanner;

public class SherlockAndSquares {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for(int i = 0; i < t; i++) process(scanner.nextInt(), scanner.nextInt());;
    }

    private static void process(int a, int b) {
        double aSqrt = Math.sqrt(a);
        double bSqrt = Math.sqrt(b);

        int diff = (int)(Math.floor(bSqrt) - (int)Math.ceil(aSqrt)) + 1;

        if(diff > 0) {
            System.out.println(diff);
        } else {
            System.out.println(0);
        }
    }
}
