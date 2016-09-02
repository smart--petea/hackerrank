//https://www.hackerrank.com/challenges/minimum-distances
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class MinimumDistances {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> hMap = new HashMap<Integer, Integer>();

        int minDistance = Integer.MAX_VALUE;
        int temp;
        int tempDistance;
        for(int i = 0; i < n; i++) {
            temp = in.nextInt();

            if(hMap.get(temp) == null) {
                hMap.put(temp, i);
                continue;
            } 

            tempDistance = i - hMap.get(temp);
            hMap.put(temp, i);
            if(tempDistance < minDistance) {
                minDistance = tempDistance;
            }
        }

        if(minDistance == Integer.MAX_VALUE) minDistance = -1;
        System.out.println(minDistance);
    }
}
