package ua.foxminded.division.tarasevych;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Division {

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int dividend = scan.nextInt();
        int divider = scan.nextInt();
        System.out.println(longDivision(dividend, divider));
        scan.close();
    }

    public static List<Integer> getAllDigits(int dividend) {
        List<Integer> digitArray = new ArrayList<>();

        while (dividend > 0) {
            digitArray.add(dividend % 10);
            dividend = dividend / 10;
        }
        Collections.reverse(digitArray);
        return digitArray;
    }

    public static int getDigits(int dividend, int conditionNotLess) {
        int result = 0;

        for (Integer i : getAllDigits(dividend)) {
            result = 10 * result + i;

            if (result >= conditionNotLess) {
                break;
            }
        }
        return result;
    }

    public static String longDivision(int dividend, int divider) {
        List<Integer> buildList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int dividerLength = String.valueOf(divider).length();
        int result = 0;
        int substraction = 0;
        int variable = Integer.parseInt(getAllDigits(dividend).subList(0, dividerLength).toString().replace("[", "")
                .replace("]", "").replace(", ", ""));

        while (dividerLength != getAllDigits(dividend).size()) {
            result = Math.abs(variable / divider);
            builder.append(result);
            substraction = Math.abs(result * divider);
            variable = Integer.parseInt(Math.abs(variable - substraction) + "".concat(getAllDigits(dividend)
                    .get(dividerLength++).toString().replace("[", "").replace("]", "").replace(", ", "")));

            if (variable < divider) {

                while (variable < substraction && dividerLength != getAllDigits(dividend).size()) {
                    variable = Integer.parseInt(variable + "".concat(getAllDigits(dividend).get(dividerLength++)
                            .toString().replace("[", "").replace("]", "").replace(", ", "")));
                    builder.append(0);
                }
            }

            if (substraction != 0) {
                Collections.addAll(buildList, substraction, variable);
            }
        }

        if (dividerLength == getAllDigits(dividend).size()) {
            result = Math.abs(variable / divider);
            substraction = Math.abs(result * divider);
            variable -= Math.abs(substraction);
            builder.append(result);
            result = Integer.parseInt(builder.toString());

            if (substraction > variable) {
                Collections.addAll(buildList, substraction, variable);
            }
        }
        return convertLongDivision(buildList, dividend, divider, result);
    }

    public static String convertLongDivision(List<Integer> list, int dividend, int divider, int result) {
        StringBuilder stringBuilder = new StringBuilder(String.format("_%d|%d" + "\n", dividend, divider));
        int dividendLength = String.valueOf(dividend).length();

        for (int i = 0; i < list.size(); i++) {
            int dif = String.valueOf(getDigits(dividend, list.get(i))).length() - String.valueOf(list.get(i)).length();
            int variableSize = String.valueOf(list.get(i)).length();
            int resultSize = String.valueOf(result).length();

            if (i < 1) {
                stringBuilder.append(String.format(" %s" + "%d" + "%s" + "%s" + "%s" + "\n",
                        String.join("", Collections.nCopies(dif, " ")), list.get(i),
                        String.join("", Collections.nCopies(dividendLength - variableSize - 1, " ")), "|",
                        String.join("", Collections.nCopies(resultSize, "-"))));

                stringBuilder.append(String.format(String.format(" %s" + "%s" + "%s" + "%s" + "%d" + "\n",
                        String.join("", Collections.nCopies(dif, " ")),
                        String.join("", Collections.nCopies(String.valueOf(list.get(0)).length(), "-")),
                        String.join("", Collections.nCopies(dividendLength - variableSize - 1, " ")), "|", result)));
            }
            if (i >= 1) {
                stringBuilder.append(String.format(" %d" + "\n", list.get(i)));
            }
        }
        return stringBuilder.toString();
    }
}

//if (i >= 1) {
//    if (i % 2 == 1 && i < list.size() - 1) {
//        stringBuilder.append("_");
//    }
//
//    if (i == list.size() - 1) {
//        stringBuilder.append(" ");
//    }
//    stringBuilder.append(String.format("%d" + "\n", list.get(i)));
//
//    if (i % 2 == 0) {
//        j--;
//        stringBuilder.append(String.format("%" + j + "s" + "%s\n", "",
//                String.join("", Collections.nCopies(String.valueOf(list.get(j)).length(), "-"))));
//
//    }
//    stringBuilder.append(String.format("%" + j + "s", ""));
//}