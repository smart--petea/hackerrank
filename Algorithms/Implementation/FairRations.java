//https://www.hackerrank.com/challenges/fair-rations
import java.util.Scanner;

public class FairRations {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int temp;
        int count = 0;
        int buf = 0;
        for(int i = 0; i < n; i++) {
            temp = scanner.nextInt();

            temp += buf;

            if(temp % 2 == 0) {
                buf = 0;
            } else {
                buf = 1;
                count += 2;
            }
        }

        if(buf == 0) {
            System.out.println(count);
        } else {
            System.out.println("NO");
        }
    }
}
