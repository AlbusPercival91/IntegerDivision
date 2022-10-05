package ua.foxminded.division.tarasevych;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Division {
    List<String> longDivisionList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dividend = scan.nextInt();
        int divider = scan.nextInt();
        divisionEngine(dividend, divider);
        scan.close();
    }

    public static List<Integer> getDigits(int dividend) {
        List<Integer> digitArray = new ArrayList<>();

        while (dividend > 0) {
            digitArray.add(dividend % 10);
            dividend = dividend / 10;
        }
        Collections.reverse(digitArray);
        return digitArray;
    }

    public static int divisionEngine(int dividend, int divider) {
        StringBuilder builder = new StringBuilder();
        int initDividerLength = String.valueOf(divider).length();
        int dividerLength = String.valueOf(divider).length();
        int result = 0;
        int substraction = 0;
        int variable = Integer.parseInt(getDigits(dividend).subList(0, dividerLength).toString().replace("[", "")
                .replace("]", "").replace(", ", ""));

        while (dividerLength != getDigits(dividend).size()) {
            result = Math.abs(variable / divider);
            builder.append(result);
            substraction = Math.abs(result * divider);
            variable = Integer.parseInt(Math.abs(variable - substraction) + "".concat(getDigits(dividend)
                    .get(dividerLength++).toString().replace("[", "").replace("]", "").replace(", ", "")));

            if (variable < divider && variable <= substraction && initDividerLength < getDigits(dividend).size() - 1) {

                while (variable < substraction) {
                    variable = Integer.parseInt(variable + "".concat(getDigits(dividend).get(dividerLength++).toString()
                            .replace("[", "").replace("]", "").replace(", ", "")));
                    builder.append(0);
                }
            }

            if (substraction != 0) {
                System.out.println(substraction + "\n" + variable);
            }

        }

        if (dividerLength == getDigits(dividend).size()) {
            result = Math.abs(variable / divider);
            substraction = Math.abs(result * divider);
            variable -= Math.abs(substraction);
            builder.append(result);
            result = Integer.parseInt(builder.toString());

            if (substraction > variable) {
                System.out.println(substraction + "\n" + variable);
            }
        }
        System.out.println("= " + result);

        return result;
    }

}