//https://www.hackerrank.com/challenges/almost-sorted
import java.util.Scanner;

class Swap {
    int l;
    int r;

    public Swap(int l, int r) {
        l = l;
        r = r;
    }
}

public class AlmostSorted {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ar[] = new int[n];

        for(int i = 0; i < n; i++) ar[i] = scanner.nextInt();
    }

    private static Swap getNextSwap(int[] ar, int start) {
        int l = -1;
        int r = -1;
        int i = start + 1;;

        for(; i < ar.length; i++) 
            if(ar[i] < ar[i - 1]) {
                l = i;
                break;
            }

        for(; i < ar.length; i++) 
            if(ar[i] > ar[i - 1]) {
                r = i - 1;
                break;
            }

        return new Swap(l, r);
    }
}
