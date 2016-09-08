//https://www.hackerrank.com/challenges/service-lane
import java.util.Scanner;
public class ServiceLane {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int T = scanner.nextInt();

        int[] freeway = new int[N];
        for(int i = 0; i < N; i++) freeway[i] = scanner.nextInt();

        for(int i = 0; i < T; i++) process(freeway, scanner.nextInt(), scanner.nextInt());
    }

    private static void process(int[] freeway, int i, int j) {
        int min = freeway[i];

        for(int k = i + 1; k < j + 1; k++) 
            if(freeway[k] < min) min = freeway[k];

        System.out.println(min);
    }
}
