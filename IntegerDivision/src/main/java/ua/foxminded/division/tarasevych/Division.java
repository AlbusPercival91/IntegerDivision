package ua.foxminded.division.tarasevych;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Division {
    static List<Integer> varLengthDifList = new ArrayList<>();

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

    public static int concatDigits(int dividend, int conditionBreak) {
        int result = 0;

        for (Integer i : getAllDigits(dividend)) {
            result = 10 * result + i;

            if (result >= conditionBreak) {
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
            int variableLength = String.valueOf(variable - substraction).length();
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
                Collections.addAll(varLengthDifList, String.valueOf(substraction).length() - variableLength, 0);
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
                Collections.addAll(varLengthDifList,
                        String.valueOf(substraction).length() - String.valueOf(variable).length(), 0);
            }
        }
        System.out.println(varLengthDifList.toString());
        return converToView(buildList, dividend, divider, result);
    }

    public static String converToView(List<Integer> list, int dividend, int divider, int result) {
        StringBuilder stringBuilder = new StringBuilder(String.format("_%d|%d" + "\n", dividend, divider));
        int resultLength = String.valueOf(result).length();
        int i = 0;
        int j = 0;
        int sum = 0;

        while (i < list.size() && j < varLengthDifList.size()) {
            int dif = String.valueOf(concatDigits(dividend, list.get(i))).length()
                    - String.valueOf(list.get(i)).length();

            int space = String.valueOf(dividend).length() - String.valueOf(list.get(i)).length();

            if (dif > 0) {
                space = String.valueOf(dividend).length() - String.valueOf(list.get(i)).length() - 1;
            }

            if (i < 1) {
                stringBuilder.append(String.format(" %s" + "%d" + "%s" + "%s" + "%s" + "\n",
                        String.join("", Collections.nCopies(dif, " ")), list.get(i),
                        String.join("", Collections.nCopies(space, " ")), "|",
                        String.join("", Collections.nCopies(resultLength, "-"))));

                stringBuilder.append(String.format(String.format(" %s" + "%s" + "%s" + "%s" + "%d" + "\n",
                        String.join("", Collections.nCopies(dif, " ")),
                        String.join("", Collections.nCopies(String.valueOf(list.get(i)).length(), "-")),
                        String.join("", Collections.nCopies(space, " ")), "|", result)));
            }

            if (i >= 1) {
                sum += varLengthDifList.get(j++);
                stringBuilder.append(String.format(" %s" + "%d" + "\n", String.join("", Collections.nCopies(sum, " ")),
                        list.get(j)));
            }
            System.out.println(sum);
            i++;
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