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
        int subtraction = 0;
        int variable = Integer.parseInt(getAllDigits(dividend).subList(0, dividerLength).toString().replace("[", "")
                .replace("]", "").replace(", ", ""));

        while (dividerLength != getAllDigits(dividend).size()) {
            result = Math.abs(variable / divider);
            builder.append(result);
            subtraction = Math.abs(result * divider);
            variable = Integer.parseInt(Math.abs(variable - subtraction) + "".concat(getAllDigits(dividend)
                    .get(dividerLength++).toString().replace("[", "").replace("]", "").replace(", ", "")));

            if (variable < divider) {
                while (variable < subtraction && dividerLength != getAllDigits(dividend).size()) {
                    variable = Integer.parseInt(variable + "".concat(getAllDigits(dividend).get(dividerLength++)
                            .toString().replace("[", "").replace("]", "").replace(", ", "")));
                    builder.append(0);
                }
            }

            if (subtraction != 0) {
                Collections.addAll(buildList, " " + subtraction, "_" + variable);
            }
        }

        if (dividerLength == getAllDigits(dividend).size()) {
            result = Math.abs(variable / divider);
            subtraction = Math.abs(result * divider);
            variable -= Math.abs(subtraction);
            builder.append(result);
            result = Integer.parseInt(builder.toString());

            if (subtraction > variable) {
                Collections.addAll(buildList, " " + subtraction, " " + variable);
            }
        }
        return converToView(buildList, dividend, divider, result);
    }

    public static String converToView(List<String> list, int dividend, int divider, int result) {
        List<Integer> involvedList = new ArrayList<>();
        List<Integer> subtractList = new ArrayList<>();
        List<Integer> leftSpaceList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(String.format("_%d|%d" + "\n", dividend, divider));
        int resultLength = String.valueOf(result).length();
        involvedList.add(concatDigits(dividend, Integer.parseInt(list.get(0).trim())));
        subtractList.add(concatDigits(dividend, Integer.parseInt(list.get(0).trim())));
        int spaceLeft = 0;

        for (int i = 0; i < list.size(); i++) {

            if (i % 2 == 0) {
                Collections.addAll(involvedList, Integer.parseInt(list.get(i).replace("_", "").trim()),
                        Integer.parseInt(list.get(i + 1).replace("_", "").trim()));
                Collections.addAll(subtractList, involvedList.get(i + 1),
                        involvedList.get(i) - involvedList.get(i + 1));
            }
            leftSpaceList.add(
                    String.valueOf(involvedList.get(i)).length() - String.valueOf(subtractList.get(i + 1)).length());
            spaceLeft += leftSpaceList.get(i);

            if (i < 1) {
                int spaceMiddle = String.valueOf(dividend).length() - String.valueOf(list.get(i)).length();

                if (leftSpaceList.get(i) > 0) {
                    spaceMiddle = String.valueOf(dividend).length() - String.valueOf(list.get(i)).length() - 1;
                }
                stringBuilder.append(String.format("%s" + "%s" + "%s" + "%s" + "%s" + "\n",
                        String.join("", Collections.nCopies(spaceLeft, " ")), list.get(i),
                        String.join("", Collections.nCopies(spaceMiddle + 1, " ")), "|",
                        String.join("", Collections.nCopies(resultLength, "-"))));

                stringBuilder.append(String.format(String.format("%s" + " %s" + "%s" + "%s" + "%s" + "\n",
                        String.join("", Collections.nCopies(spaceLeft, " ")),
                        String.join("", Collections.nCopies(String.valueOf(list.get(i)).length() - 1, "-")),
                        String.join("", Collections.nCopies(spaceMiddle + 1, " ")), "|", result)));
            }

            if (i >= 1) {
                String value = list.get(i);

                if (list.get(list.size() - 1).contains("_")) {
                    value = list.get(list.size() - 1).replace("_", " ");
                }

                stringBuilder.append(
                        String.format("%s" + "%s" + "\n", String.join("", Collections.nCopies(spaceLeft, " ")), value));

                if (i % 2 == 0) {
                    stringBuilder.append(
                            String.format(" %s" + "%s" + "\n", String.join("", Collections.nCopies(spaceLeft, " ")),
                                    String.join("", Collections.nCopies(String.valueOf(value).length() - 1, "-"))));
                }
            }

            if (involvedList.get(i) - involvedList.get(i + 1) == 0 && involvedList.get(involvedList.size() - 1) != 0
                    && i % 2 == 0) {
                spaceLeft++;
            }
        }
        return stringBuilder.toString();
    }
}
