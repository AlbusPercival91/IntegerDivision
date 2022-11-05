package ua.foxminded.division.tarasevych;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Division {

    private Division() {

    }

    private static List<Integer> getAllDigits(int dividend) {
        List<Integer> digitArray = new ArrayList<>();

        while (dividend > 0) {
            digitArray.add(dividend % 10);
            dividend = dividend / 10;
        }
        Collections.reverse(digitArray);
        return digitArray;
    }

    private static int concatDigits(int dividend, int conditionBreak) {
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
        IntegerData data = new IntegerData();
        data.setDividend(Math.abs(dividend));
        data.setDivider(Math.abs(divider));
        List<String> buildList = new ArrayList<>();
        StringBuilder resultBuilder = new StringBuilder();
        StringBuilder zero = new StringBuilder();
        int dividerLength = String.valueOf(data.getDivider()).length();
        int subtraction = 0;

        if (data.getDivider() == 0) {
            throw new ArithmeticException("/ by zero");
        }

        if (data.getDividend() >= data.getDivider() && data.getDividend() != 0 && data.getDivider() != 0) {
            int variable = Integer.parseInt(getAllDigits(data.getDividend()).subList(0, dividerLength).toString()
                    .replace("[", "").replace("]", "").replace(", ", ""));

            while (dividerLength != getAllDigits(data.getDividend()).size()) {
                data.setResult(variable / data.getDivider());
                resultBuilder.append(data.getResult());
                subtraction = data.getResult() * data.getDivider();
                variable = Integer.parseInt(variable - subtraction + "".concat(getAllDigits(data.getDividend())
                        .get(dividerLength++).toString().replace("[", "").replace("]", "").replace(", ", "")));

                while (variable < data.getDivider() && dividerLength != getAllDigits(data.getDividend()).size()) {

                    if (variable == 0) {
                        zero.append("0");
                    }
                    variable = Integer.parseInt(variable + "".concat(getAllDigits(data.getDividend())
                            .get(dividerLength++).toString().replace("[", "").replace("]", "").replace(", ", "")));
                    resultBuilder.append(0);
                }
                filterData(buildList, zero, variable, subtraction);
            }

            if (dividerLength == getAllDigits(data.getDividend()).size()) {
                data.setResult(variable / data.getDivider());
                subtraction = data.getResult() * data.getDivider();
                variable -= subtraction;
                resultBuilder.append(data.getResult());
                data.setResult(Integer.parseInt(resultBuilder.toString()));

                filterData(buildList, zero, variable, subtraction);
            }
            return convertToView(buildList, data);
        } else {
            collectData(buildList, zero, 0, 0);
            return convertToView(buildList, data);
        }
    }

    private static void collectData(List<String> dataList, StringBuilder zero, int variable, int subtraction) {
        if (!zero.isEmpty()) {
            Collections.addAll(dataList, " " + subtraction, "_" + zero + variable);
            zero.delete(0, zero.length());
        } else {
            Collections.addAll(dataList, " " + subtraction, "_" + variable);
        }
    }

    private static void filterData(List<String> dataList, StringBuilder zero, int variable, int subtraction) {
        if (subtraction > 0) {
            collectData(dataList, zero, variable, subtraction);
        }
    }

    private static String convertToView(List<String> list, IntegerData data) {
        List<Integer> involvedList = new ArrayList<>();
        List<Integer> subtractList = new ArrayList<>();
        List<Integer> leftSpaceList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder("_" + data.getDividend() + "|" + data.getDivider() + "\n");
        int resultLength = String.valueOf(data.getResult()).length();
        involvedList.add(concatDigits(data.getDividend(), Integer.parseInt(list.get(0).trim())));
        subtractList.add(concatDigits(data.getDividend(), Integer.parseInt(list.get(0).trim())));
        int spaceLeft = 0;

        for (int i = 0; i < list.size(); i++) {
            spaceLeft = makeSpaceLeft(list, involvedList, subtractList, leftSpaceList, spaceLeft, i);

            if (i < 1) {
                int spaceMiddle = String.valueOf(data.getDividend()).length() - String.valueOf(list.get(i)).length();

                if (leftSpaceList.get(i) > 0) {
                    spaceMiddle = String.valueOf(data.getDividend()).length() - String.valueOf(list.get(i)).length()
                            - 1;
                }
                int underLines = String.valueOf(list.get(i)).length() - 1;
                int spaceLeftCorr = String.valueOf(involvedList.get(i)).length()
                        - String.valueOf(involvedList.get(i + 1)).length();

                if (String.valueOf(involvedList.get(i)).length() > String.valueOf(involvedList.get(i + 1)).length()) {
                    underLines = String.valueOf(list.get(i)).length();
                }

                stringBuilder.append(String.join("", Collections.nCopies(spaceLeft, " ")) + list.get(i)
                        + String.join("", Collections.nCopies(spaceMiddle + 1, " ")) + "|"
                        + String.join("", Collections.nCopies(resultLength, "-")) + "\n");

                stringBuilder.append(" " + String.join("", Collections.nCopies(spaceLeft - spaceLeftCorr, " "))
                        + String.join("", Collections.nCopies(underLines, "-"))
                        + String.join("", Collections.nCopies(spaceMiddle + 1, " ")) + "|" + data.getResult() + "\n");
            }

            if (i >= 1) {
                int countZero = zeroCounter(list, i);
                String value = String.join("", Collections.nCopies(countZero, " ")) + list.get(i);

                spaceLeft = makePostHeader(list, stringBuilder, spaceLeft, i, countZero, value);
            }

            if (involvedList.get(i) - involvedList.get(i + 1) == 0 && involvedList.get(involvedList.size() - 1) != 0
                    && i % 2 == 0) {
                spaceLeft++;
            }
        }
        return stringBuilder.toString();
    }

    private static int makeSpaceLeft(List<String> list, List<Integer> involvedList, List<Integer> subtractList,
            List<Integer> leftSpaceList, int spaceLeft, int i) {
        if (i % 2 == 0) {
            Collections.addAll(involvedList, Integer.parseInt(list.get(i).replace("_", "").trim()),
                    Integer.parseInt(list.get(i + 1).replace("_", "").trim()));
            Collections.addAll(subtractList, involvedList.get(i + 1), involvedList.get(i) - involvedList.get(i + 1));
        }
        leftSpaceList
                .add(String.valueOf(involvedList.get(i)).length() - String.valueOf(subtractList.get(i + 1)).length());
        spaceLeft += leftSpaceList.get(i);
        return spaceLeft;
    }

    private static int makePostHeader(List<String> list, StringBuilder stringBuilder, int spaceLeft, int i,
            int countZero, String value) {

        if (value.contains("_") && i == list.size() - 1) {
            value = list.get(list.size() - 1).replace("_", " ");
        }
        stringBuilder.append(String.join("", Collections.nCopies(spaceLeft, " ")) + value + "\n");

        if (i % 2 == 0) {
            stringBuilder.append(" " + String.join("", Collections.nCopies(spaceLeft, " "))
                    + String.join("", Collections.nCopies(String.valueOf(value).length() - 1, "-")) + "\n");

            if (countZero > 0) {
                spaceLeft += countZero;
            }
        }
        return spaceLeft;
    }

    private static int zeroCounter(List<String> list, int i) {
        int countZero = 0;

        if (list.get(i).startsWith(" ") && list.get(i - 1).startsWith("_0")) {
            String[] zeroArray = list.get(i - 1).replace("_", "").split("");

            for (String s : zeroArray) {
                if (s.equals("0")) {
                    countZero++;
                } else if (!s.equals("0")) {
                    break;
                }
            }
        }
        return countZero;
    }
}
