//www.hackerrank.com/challenges/utopian-tree
import java.util.Scanner;

public class UtopianTree {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i < T; i++) System.out.println(compute(scanner.nextInt()));
    }

    private static int compute(int n) {
        if(n == 0) return 1;

        int rest = n % 2;
        n = (n + 1)/ 2 ;

        int sum = 0;
        int temp = 1;
        for(int i = 0; i <= n; i++, sum += temp, temp *= 2);

        if(rest == 1) return sum - 1;
        return sum;
    }
}
