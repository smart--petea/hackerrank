//https://www.hackerrank.com/challenges/bomber-man

public class bomber_man {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int R = scanner.nextInt();
        int C = scanner.nextInt();
        int N = scanner.nextInt();

        int[][] state = new int[R][C];
        String line;
        int i, j;
        for(i = 0; i < R; i++) {
            line = scanner.next();
            for(j = 0; j < C; j++)
                state[i][j] = line.charAt(j) == 'O' ? state[i][j] = 3 : 5;
        }

        if(N == 1 || N == 2) {
            display(N, state, R, C);
            return;
        }

        int timer = 0;
        for(int t = 3; t <= N; t++) {
            timer = t + 3;
            for(i = 0; i < R; i++) 
                for(j = 0; j < C; j++) 
                    if(state[i][j] == t) {
                        state[i][j] = timer;
                        if(i > 0) state[i - 1][j] = timer;
                        if(i < R - 1 && state[i + 1][j] != t) state[i + 1][j] = timer;
                        if(j > 0) state[i][j - 1] = timer;
                        if(j < C - 1 && state[i][j + 1] != t) state[i][j + 1] = timer;
                    }
        }

        //display the result
        display(timer, state, R, C);
    }

    private static void display(int timer, int[][] state, int R, int C) {
        if(timer % 2 != 1) {
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
        //            System.out.print(state[i][j]);
                    System.out.print(state[i][j] == timer ? '.' : 'O');
                }
                System.out.println("");
            }
        } else {
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    System.out.print("O");
                }
                System.out.println("");
            }
        }
    }
}
