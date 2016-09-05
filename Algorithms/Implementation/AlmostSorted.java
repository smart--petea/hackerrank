//https://www.hackerrank.com/challenges/almost-sorted
import java.util.Scanner;

class Swap {
    int l;
    int r;

    public Swap(int l_, int r_) {
        l = l_;
        r = r_;
    }
}

public class AlmostSorted {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ar[] = new int[n];

        for(int i = 0; i < n; i++) ar[i] = scanner.nextInt();

        Swap firstSwap = getNextSwap(ar, 0);
        System.out.println("first l = " + firstSwap.l + " r = " + firstSwap.r);
        if(firstSwap.r == -1) {
            //either one reverse or one swap
            if(firstSwap.l == n - 1) {
                int minMax = getMinMax(ar);
                if(ar[minMax] > ar[ar.length - 2]) {

                    System.out.println("yes");
                    System.out.print("swap ");
                    System.out.print(getMinMax(ar) + 1);
                    System.out.print(" " + ar.length);
                } else if (firstSwap.l == 0) {
                }return;
            }

        }

        Swap secondSwap = firstSwap.r == -1 ? new Swap(-1, -1) : getNextSwap(ar, firstSwap.r);
        Swap thirdSwap = secondSwap.r == -1 ? new Swap(-1, -1) : getNextSwap(ar, secondSwap.r);
    }

    private static int getMinMax(int[] ar) {
        int tempi = ar.length - 1;
        int i = ar.length - 2;

        for(; ar[tempi] < ar[i] && i >= 0; i--); 
        return i + 1;
    }

    private static Swap getNextSwap(int[] ar, int start) {
        int l = -1;
        int r = -1;
        int i = start + 1;

        for(; i < ar.length; i++) {
            if(ar[i] < ar[i - 1]) {
                l = i;
                break;
            }
        }

        for(; i < ar.length; i++) {
            if(ar[i] > ar[i - 1]) {
                r = i - 1;
                break;
            }
        }

        return new Swap(l, r);
    }
}
