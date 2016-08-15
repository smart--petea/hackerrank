//https://www.hackerrank.com/challenges/bomber-man

public class bomber_man {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int R = scanner.nextInt();
        int C = scanner.nextInt();
        int N = scanner.nextInt();

        int[][] state = new int[R][C];
        String line;
        for(int i = 0; i < R; i++) {
            line = scanner.next();
            for(int j = 0; j < C; j++)
                if(line.charAt(j) == 'O') state[i][j] = 3;
        }

        for(int i = 0; i < R; i++) {
            System.out.println("");
            for(int j = 0; j < C; j++) {
                System.out.print(state[i][j]);
                System.out.print(" ");
            }
        }
    }
}
