//https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class jumping_on_the_clouds_revisited  {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }

        int E = 100;
        int i = 0;
        while((i = (i + k) % n) != 0) E -= (c[i] == 1) ? 3 : 1;
        System.out.println(E - (c[0] == 1 ? 3 : 1));
    }
}
