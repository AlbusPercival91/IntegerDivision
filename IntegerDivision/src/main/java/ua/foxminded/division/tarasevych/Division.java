package ua.foxminded.division.tarasevych;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Division {

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
        List<Integer> buildList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
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

            if (variable < divider) {

                while (variable < substraction && dividerLength != getDigits(dividend).size()) {
                    variable = Integer.parseInt(variable + "".concat(getDigits(dividend).get(dividerLength++).toString()
                            .replace("[", "").replace("]", "").replace(", ", "")));
                    builder.append(0);
                }
            }

            if (substraction != 0) {
                Collections.addAll(buildList, substraction, variable);
            }
        }

        if (dividerLength == getDigits(dividend).size()) {
            result = Math.abs(variable / divider);
            substraction = Math.abs(result * divider);
            variable -= Math.abs(substraction);
            builder.append(result);
            result = Integer.parseInt(builder.toString());

            if (substraction > variable) {
                Collections.addAll(buildList, substraction, variable);
            }
        }
        divisionDraw(buildList, dividend, divider, result);
        return result;
    }

    public static void divisionDraw(List<Integer> list, int dividend, int divider, int result) {
        StringBuilder stringBuilder = new StringBuilder(String.format("_%d|%d" + "\n", dividend, divider));

        stringBuilder.append(String.format(" %-" + String.valueOf(dividend).length() + "d|%s\n", list.get(0),
                String.join("", Collections.nCopies(String.valueOf(result).length(), "-"))));

        stringBuilder.append(String.format(" %-" + String.valueOf(dividend).length() + "s|%d\n",
                String.join("", Collections.nCopies(String.valueOf(list.get(0)).length(), "-")), result));

        for (int i = 1, j = 0; i < list.size(); i++, j++) {

            if (i % 2 == 1 && i < list.size() - 1) {
                stringBuilder.append("_");
            }
            stringBuilder.append(String.format("%d" + "\n", list.get(i)));

            if (i % 2 == 0) {
                stringBuilder.append(String.format("%" + j + "s" + "%s\n", "",
                        String.join("", Collections.nCopies(String.valueOf(list.get(i)).length(), "-"))));
            }
            stringBuilder.append(String.format("%" + i + "s", " "));
        }
        System.out.println(stringBuilder);
    }

}