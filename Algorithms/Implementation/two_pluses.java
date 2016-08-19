//https://www.hackerrank.com/challenges/two-pluses
//
import java.util.Scanner;

class Cross {
    int i;
    int j;
    int size;

    Cross(int x, int y, int sz) {
        i = x;
        j = y;
        size = sz;
    }

    public boolean overlap(Cross crs) {
        return false;
    }

    static public Cross getCross(int x, int y, char[][] table) {
        int i = 1;

        int height = table.length;
        int width = table[0].length;

        while(x - i > 0 && x + i < height && y - i > 0 && y + i < width && table[x - i][y] == 'G' && table[x + i][y] == 'G' && table[x][y - i] == 'G' && table[x][y + i] == 'G') ++i;

        return new Cross(x, y, i);
    }
}

public class two_pluses {
    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        char[][] table = new char[N][M];
        int i, j;

        for(i = 0; i < N; i++) table[i] = scanner.next().toCharArray();

        Cross frstCross = null;
        Cross scndCross = null;
        Cross tempCross;

        i = 0;
        j = 0;
        int size = 0;
        while(i < N - size) {
            j = size;
            while(j < M - size) {
                if(table[i][j] == 'G') {
                    tempCross = Cross.getCross(i, j, table);

                    if(frstCross == null) {
                        frstCross = tempCross;
                    } else if(scndCross == null) {
                        if(!frstCross.overlap(tempCross)) {
                            if(frstCross.size > tempCross.size) {
                                scndCross = frstCross;
                                frstCross = tempCross;
                            } else {
                                scndCross = tempCross;
                            }
                        }
                    } else {

                    }
                }
                ++j;
            }

            i = Math.max(++i, size);
        }
    }
}
