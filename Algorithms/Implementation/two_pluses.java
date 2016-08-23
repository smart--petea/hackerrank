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

    public static int getMaximum() {
	int prod = 0;
	int prodFinal = 0;

	Cross tmp = crosses.removeFirst(); 
	ListIterator<Cross> li = crosses.listIterator();

	while(crosses.isEmpty() == false) {
		tmp = crosses.removeFirst();
		li = crosses.listIterator();
		
		while(li.hasNext()) {
			prod = tmp.size * li.next().size;
			if(prod > prodFinal) {
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
