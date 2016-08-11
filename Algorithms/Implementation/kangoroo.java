//https://www.hackerrank.com/challenges/kangaroo
public class kangoroo {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();

        if( v1 <= v2 ) {
            System.out.print("NO");
            return;
        }

        if( (x1 - x2) % (v2 - v1) == 0) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}
