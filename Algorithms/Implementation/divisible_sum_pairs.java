//https://www.hackerrank.com/challenges/divisible-sum-pairs
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class divisible_sum_pairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int rems[] = new int[k];
        Arrays.fill(rems, 0);

        int sum = 0;
        rems[a[0] % k] = 1;
        for(int i = 1; i < a.length; i++) {
            int rem = a[i] % k;
            sum += rems[(k - rem) % k];
            rems[rem] += 1;
        }

        System.out.println(sum);
    }
}
