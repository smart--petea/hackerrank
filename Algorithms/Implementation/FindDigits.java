//www.hackerrank.com/challenges/find-digits
import java.util.Scanner;

public class FindDigits {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for(int i = 0; i < tests; i++) {
            process();
        }
    }

    private static void process() {
        Scanner in = new Scanner(System.in);
        String number = in.next();
        int num_len = number.length();

        if(num_len == 1) {
            System.out.println(1);
            return;
        }

        int counter[] = new int[10];
        int temp;
        int sum = 0;
        for(int i = 0; i < num_len; i++) {
            temp = getInt(number, i);
            sum += temp;
            ++counter[temp];
        }

        //1
        int finalCount = counter[1];

        //2
        int lastDigit = getInt(number, number.length() - 1);
        if(lastDigit  % 2 == 0) {
            finalCount += counter[2];
        }

        //3
        if(sum % 3 == 0) {
            finalCount += counter[3];
        }

        //4
        int secondDigit = getInt(number, number.length() - 2);
        if((secondDigit * 2 + lastDigit) % 4 == 0) {
            finalCount += counter[4];
        }

        //5
        if(lastDigit % 5 == 0) {
            finalCount += counter[5];
        }

        //6
        if((sum % 3 == 0) && (lastDigit % 2 == 0)) {
            finalCount += counter[6];
        }

        //7
        int i = number.length() - 1;
        int seven_sum = 0;
        while(i >= 0) {
            int group = getInt(number, i);
            if(--i >= 0) {
                group += getInt(number, i) * 10 + group;
            }

            if(--i >= 0) {
                group += getInt(number, i) * 100 + group;
            }

            seven_sum += (i % 2 == 0 ? 1 : -1) * group;
        }
        if(seven_sum % 7 == 0) {
            finalCount += counter[7];
        }

        //8
        int thirdDigit = num_len >= 3 ? getInt(number, number.length() - 3) : 0;
        if((thirdDigit * 4 + secondDigit * 2 + lastDigit) % 8 == 0) {
            finalCount += counter[8];
        }

        //9
        if(sum % 9 == 0) {
            finalCount += counter[9];
        }

        System.out.println(finalCount);
    }

    public static int getInt(String str, int index) {
        return str.charAt(index) - 48;
    }
}
