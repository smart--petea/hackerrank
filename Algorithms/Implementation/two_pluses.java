//https://www.hackerrank.com/challenges/two-pluses
//
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

class Cross {
    private static List<Cross> crosses = new LinkedList<>();
    private static char[][] table;
    private static int N;
    private static int M;

    int i;
    int j;
    int size;

    private static void fillTable() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        for(int i = 0; i < N; i++) table[i] = scanner.next().toCharArray();
    }

    public static int process() {
        fillTable();

        for(int i = 0; i < N; i++) 
            for(int j = 0; j < M; j++)
                if(table[i][j] == 'G') generateCrosses(i, j);

        return getMaximum();
    }

    public static int getMaximum() {
        return -1;
    }

    Cross(int x, int y, int sz) {
        i = x;
        j = y;
        size = sz;
    }

    private static void generateCrosses(int x, int y) {
        int i = 0;

        int height = table.length;
        int width = table[0].length;

        while(x - i > 0 && x + i < height && y - i > 0 && y + i < width && table[x - i][y] == 'G' && table[x + i][y] == 'G' && table[x][y - i] == 'G' && table[x][y + i] == 'G') crosses.add(new Cross(x, y, ++i));
    }
}

public class two_pluses {
    static public void main(String[] args) {
        System.out.println(Cross.process());
    }
}
