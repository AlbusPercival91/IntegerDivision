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
        List<Integer> digitLengthList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(String.format("_%d|%d" + "\n", dividend, divider));
        int resultLength = String.valueOf(result).length();
        digitLengthList.add(String.valueOf(concatDigits(dividend, Integer.parseInt(list.get(0).trim()))).length());
        int dif = 0;

        for (int i = 0; i < list.size(); i++) {

            if (i % 2 == 0) {

                Collections.addAll(digitLengthList, String.valueOf(list.get(i).trim()).length(),
                        String.valueOf(list.get(i + 1)).length() - 1);
            }

//            int dif = String.valueOf(concatDigits(dividend, list.get(i))).length()
//                    - String.valueOf(list.get(i)).length();

            dif = digitLengthList.get(i) - digitLengthList.get(i + 1);

            /*
             * may be remove to keep negative result??
             * 
             * dif not working properly!
             * 
             * in some cases _ exist in last variable!!
             */

            if (dif < 0) {
                dif = 0;
            }
            System.out.println(dif);

            if (i < 1) {
                int space = String.valueOf(dividend).length() - String.valueOf(list.get(i)).length();

                if (dif > 0) {
                    space = String.valueOf(dividend).length() - String.valueOf(list.get(i)).length() - 1;
                }

                stringBuilder.append(String.format("%s" + "%s" + "%s" + "%s" + "%s" + "\n",
                        String.join("", Collections.nCopies(dif, " ")), list.get(i),
                        String.join("", Collections.nCopies(space + 1, " ")), "|",
                        String.join("", Collections.nCopies(resultLength, "-"))));

                stringBuilder.append(String.format(String.format("%s" + " %s" + "%s" + "%s" + "%s" + "\n",
                        String.join("", Collections.nCopies(dif, " ")),
                        String.join("", Collections.nCopies(String.valueOf(list.get(i)).length() - 1, "-")),
                        String.join("", Collections.nCopies(space + 1, " ")), "|", result)));
            }

            if (i >= 1) {
                stringBuilder.append(
                        String.format("%s" + "%s" + "\n", String.join("", Collections.nCopies(0, " ")), list.get(i)));

                if (i % 2 == 0) {
                    stringBuilder.append(String.format(" %s" + "%s" + "\n",
                            String.join("", Collections.nCopies(0, " ")),
                            String.join("", Collections.nCopies(String.valueOf(list.get(i)).length() - 1, "-"))));
                }
            }
        }
        System.out.println(digitLengthList);
        return stringBuilder.toString();
    }
}
