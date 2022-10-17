package ua.foxminded.division.tarasevych;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Division {

    private Division() {

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
        List<String> buildList = new ArrayList<>();
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
                Collections.addAll(buildList, " " + substraction, "_" + variable);
            }
        }

        if (dividerLength == getAllDigits(dividend).size()) {
            result = Math.abs(variable / divider);
            substraction = Math.abs(result * divider);
            variable -= Math.abs(substraction);
            builder.append(result);
            result = Integer.parseInt(builder.toString());

            if (substraction > variable) {
                Collections.addAll(buildList, " " + substraction, " " + variable);
            }
        }
        return converToView(buildList, dividend, divider, result);
    }

    public static String converToView(List<String> list, int dividend, int divider, int result) {
        List<Integer> involvedList = new ArrayList<>();
        List<Integer> subtractList = new ArrayList<>();
        List<Integer> shiftList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(String.format("_%d|%d" + "\n", dividend, divider));
        int resultLength = String.valueOf(result).length();
        involvedList.add(concatDigits(dividend, Integer.parseInt(list.get(0).trim())));
        subtractList.add(concatDigits(dividend, Integer.parseInt(list.get(0).trim())));
        int sumDif = 0;

        for (int i = 0; i < list.size(); i++) {

            if (i % 2 == 0) {
                Collections.addAll(involvedList, Integer.parseInt(list.get(i).replace("_", "").trim()),
                        Integer.parseInt(list.get(i + 1).replace("_", "").trim()));
                Collections.addAll(subtractList, involvedList.get(i + 1),
                        involvedList.get(i) - involvedList.get(i + 1));
            }

            shiftList.add(
                    String.valueOf(involvedList.get(i)).length() - String.valueOf(subtractList.get(i + 1)).length());

            if (i < 1) {
                sumDif += shiftList.get(i);
                int space = String.valueOf(dividend).length() - String.valueOf(list.get(i)).length();

                if (shiftList.get(i) > 0) {
                    space = String.valueOf(dividend).length() - String.valueOf(list.get(i)).length() - 1;
                }

                stringBuilder.append(String.format("%s" + "%s" + "%s" + "%s" + "%s" + "\n",
                        String.join("", Collections.nCopies(shiftList.get(i), " ")), list.get(i),
                        String.join("", Collections.nCopies(space + 1, " ")), "|",
                        String.join("", Collections.nCopies(resultLength, "-"))));

                stringBuilder.append(String.format(String.format("%s" + " %s" + "%s" + "%s" + "%s" + "\n",
                        String.join("", Collections.nCopies(shiftList.get(i), " ")),
                        String.join("", Collections.nCopies(String.valueOf(list.get(i)).length() - 1, "-")),
                        String.join("", Collections.nCopies(space + 1, " ")), "|", result)));
            }

            if (i >= 1) {
                sumDif += shiftList.get(i);
                stringBuilder.append(String.format("%s" + "%s" + "\n",
                        String.join("", Collections.nCopies(sumDif, " ")), list.get(i)));

                if (i % 2 == 0) {
                    stringBuilder.append(String.format(" %s" + "%s" + "\n",
                            String.join("", Collections.nCopies(sumDif, " ")),
                            String.join("", Collections.nCopies(String.valueOf(list.get(i)).length() - 1, "-"))));
                }
            }
        }
        return stringBuilder.toString();
    }
}
