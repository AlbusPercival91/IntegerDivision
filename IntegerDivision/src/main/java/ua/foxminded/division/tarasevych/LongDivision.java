package ua.foxminded.division.tarasevych;

import java.util.Scanner;

public class LongDivision {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int dividend = scan.nextInt();
        int divider = scan.nextInt();
        System.out.println(Division.longDivision(dividend, divider));
        scan.close();
    }
}
