//https://www.hackerrank.com/challenges/almost-sorted
import java.util.Scanner;

class Swap {
    int l;
    int r;

    public Swap(int l_, int r_) {
        l = l_;
        r = r_;
    }

    public boolean isEmpty() {
        return l == -1 && r == -1;
    }
}

public class AlmostSorted {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ar[] = new int[n];

        for(int i = 0; i < n; i++) ar[i] = scanner.nextInt();

        Swap firstSwap = getNextSwap(ar, 0);
        if(firstSwap.isEmpty()) {
            printNo();
            return;
        } else if(firstSwap.r == ar.length - 1) {
            //fill the gap to the end
            oneSwapCase(ar, firstSwap);
            return;
        }

        Swap secondSwap = getNextSwap(ar, firstSwap.r + 1);
        if(secondSwap.isEmpty() ) {
            //fill the gap a part to the end
            oneSwapCase(ar, firstSwap);
            return;
        } else if(secondSwap.r == ar.length - 1) {
            //go to the end
            twoSwapCase(ar, firstSwap, secondSwap);
            return;
        }

        Swap thirdSwap = getNextSwap(ar, secondSwap.r + 1);
        if( thirdSwap.isEmpty()) {
            twoSwapCase(ar, firstSwap, secondSwap);
        } else {
            printNo();
        }
    }

    private static void printNo() {
        System.out.println("no");
    }

    private static void printSwap(int l, int r) {
        System.out.println("yes");
        System.out.println("swap " + l + " " + r);
    }

    private static void oneSwapCase(int[] ar, Swap swp) {
        if(swp.l == 0 && swp.r == ar.length - 1) {
            if(swp.r - swp.l == 1) {
                printSwap(swp.l + 1, swp.r + 1);
            } else {
                printReverse(swp.l + 1, swp.r + 1);
            }
        } else if (swp.l == 0) {
            if(ar[swp.l] < ar[swp.r + 1]) {
                if(swp.r - swp.l == 1) {
                    printSwap(swp.l + 1, swp.r + 1);
                } else {
                    printReverse(swp.l + 1, swp.r + 1);
                }
            } else {
                printNo();
            }
        } else if(swp.r == ar.length - 1) {
            if(ar[swp.l - 1] < ar[swp.r]) {
                if(swp.r - swp.l == 1) {
                    printSwap(swp.l + 1, swp.r + 1);
                } else {
                    printReverse(swp.l + 1, swp.r + 1);
                }
            } else {
                printNo();
            }
        } else {
            if(ar[swp.l - 1] < ar[swp.r] && ar[swp.l] < ar[swp.r + 1]) {
                if(swp.r - swp.l == 1) {
                    printSwap(swp.l + 1, swp.r + 1);
                } else {
                    printReverse(swp.l + 1, swp.r + 1);
                }
            } else {
                printNo();
            }
        }
    }

    private static void printReverse(int l, int r) {
        System.out.println("yes");
        System.out.println("reverse " + l + " " + r);
    }

    private static void twoSwapCase(int[] ar, Swap firstSwp, Swap secondSwp) {
        if(firstSwp.r - firstSwp.l > 1 || secondSwp.r - secondSwp.l > 1) {
            printNo();
            return;
        }

        if(ar[firstSwp.l] < ar[secondSwp.r]) {
            if(secondSwp.r == ar.length - 1) {
                printSwap(firstSwp.r + 1, secondSwp.r + 1);
                return;
            } else if(ar[firstSwp.r] < ar[secondSwp.r + 1]) {
                printSwap(firstSwp.r + 1, secondSwp.r + 1);
                return;
            } 
        }

        printNo();
    }

    private static int getMinMax(int[] ar, int left) {
        int tempi = left;
        int i = left - 1;

        for(; ar[tempi] < ar[i] && i >= 0; i--); 
        return i + 1;
    }

    private static Swap getNextSwap(int[] ar, int start) {
        int l = -1;
        int r = -1;
        int i = start + 1;

        for(; i < ar.length; i++) {
            if(ar[i] < ar[i - 1]) {
                l = i - 1;
                break;
            }
        }

        if(i == ar.length) {
            return new Swap(-1, -1);
        }

        for(; i < ar.length; i++) {
            if(ar[i] > ar[i - 1]) {
                r = i - 1;
                break;
            }
        }

        return new Swap(l, r == -1 ? ar.length - 1 : r);
    }
}
