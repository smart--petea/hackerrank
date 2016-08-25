//https://www.hackerrank.com/challenges/two-pluses
//
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

class Cross {
    private static LinkedList<Cross> crosses = new LinkedList<Cross>();
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

	table = new char[N][M];

        for(int i = 0; i < N; i++) {
	 table[i] = scanner.next().toCharArray();
	}
    }

    public static int process() {
        fillTable();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(table[i][j] == 'G') {
		    generateCrosses(i, j);
		}
	    }
	}

        return getMaximum();
    }

    public boolean overlap(Cross crs) {
	int minn = Math.min(crs.size, size);
	int maxx = Math.max(crs.size, size);
	int sumSize = crs.size + size;

	int idiff = Math.abs(crs.i - i);
	int jdiff = Math.abs(crs.j - j);

	return (idiff == 0 && jdiff < sumSize) || (jdiff == 0 && idiff < sumSize)  || (idiff < minn && jdiff < maxx) || (idiff < maxx && jdiff  < minn);
    }

    public static int getMaximum() {
	int prod = 0;
	int prodFinal = 0;

	Cross tmp = crosses.removeFirst(); 
	Cross tmpFromLst;
	ListIterator<Cross> li = crosses.listIterator();

	while(crosses.isEmpty() == false) {
		tmp = crosses.removeFirst();
		li = crosses.listIterator();
		
		while(li.hasNext()) {
			tmpFromLst = li.next();
			if(tmp.overlap(tmpFromLst)) continue;

			prod = (4 * tmp.size - 3) * (4  * tmpFromLst.size - 3);
			if(prod > prodFinal) {
				System.out.println("(" + tmp.i + "," + tmp.j + "-"+ tmp.size + ") (" + tmpFromLst.i + "," + tmpFromLst.j + "-" + tmpFromLst.size + ") - " + prod);
				prodFinal = prod;
			}
		}
	}

	return prodFinal;
    }

    Cross(int x, int y, int sz) {
        i = x;
        j = y;
        size = sz;
    }

    public int aria() {
	return 4*i - 3;
	}

    private static void generateCrosses(int x, int y) {
        int i = 0;

	//System.out.print(x);
	//System.out.print(' ');
	//System.out.println(y);

        while(x - i >= 0 && x + i < N && y - i >= 0 && y + i < M && table[x - i][y] == 'G' && table[x + i][y] == 'G' && table[x][y - i] == 'G' && table[x][y + i] == 'G') {
		 crosses.add(new Cross(x, y, ++i));
		//System.out.println(i);
	}
    }
}

public class two_pluses {
    static public void main(String[] args) {
        System.out.println(Cross.process());
    }
}
