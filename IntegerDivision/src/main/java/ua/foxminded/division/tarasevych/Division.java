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

    static int concatDigits(int dividend, int conditionBreak) {
        int result = 0;

        for (Integer i : getAllDigits(dividend)) {
            result = 10 * result + i;

            if (result >= conditionBreak) {
                break;
            }
        }
        return result;
    }

    public static IntegerData divisionCalculation(int dividend, int divider) {
        IntegerData data = new IntegerData();
        data.setDividend(Math.abs(dividend));
        data.setDivider(Math.abs(divider));
        StringBuilder resultBuilder = new StringBuilder();
        StringBuilder zero = new StringBuilder();
        int dividerLength = String.valueOf(data.getDivider()).length();
        int subtraction = 0;
        int variable = 0;

        if (data.getDivider() == 0) {
            throw new ArithmeticException("/ by zero");
        }

        if (data.getDividend() >= data.getDivider()) {
            variable = Integer.parseInt(getAllDigits(data.getDividend()).subList(0, dividerLength).toString()
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
                filterCollectedData(data, zero, subtraction, variable);
            }

            if (dividerLength == getAllDigits(data.getDividend()).size()) {
                data.setResult(variable / data.getDivider());
                subtraction = data.getResult() * data.getDivider();
                variable -= subtraction;
                resultBuilder.append(data.getResult());
                data.setResult(Integer.parseInt(resultBuilder.toString()));

                filterCollectedData(data, zero, subtraction, variable);
            }
            return data;
        } else {
            collectData(data, zero, subtraction, variable);
            return data;
        }
    }

    private static void filterCollectedData(IntegerData data, StringBuilder zero, int subtraction, int variable) {
        if (subtraction > 0) {
            collectData(data, zero, subtraction, variable);
        }
    }

    private static void collectData(IntegerData data, StringBuilder zero, int subtraction, int variable) {
        if (!zero.isEmpty()) {
            Collections.addAll(data.getBuildList(), " " + subtraction, "_" + zero + variable);
            zero.delete(0, zero.length());
        } else {
            Collections.addAll(data.getBuildList(), " " + subtraction, "_" + variable);
        }
    }
}
