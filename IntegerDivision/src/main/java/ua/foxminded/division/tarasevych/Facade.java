package ua.foxminded.division.tarasevych;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Facade {

    protected Facade() {

    }

    public static String divisionDraw(IntegerData data) {
        List<Integer> involvedList = new ArrayList<>();
        List<Integer> subtractList = new ArrayList<>();
        List<Integer> leftSpaceList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder("_" + data.getDividend() + "|" + data.getDivider() + "\n");
        int resultLength = String.valueOf(data.getResult()).length();
        involvedList
                .add(Division.concatDigits(data.getDividend(), Integer.parseInt(data.getBuildList().get(0).trim())));
        subtractList
                .add(Division.concatDigits(data.getDividend(), Integer.parseInt(data.getBuildList().get(0).trim())));
        int spaceLeft = 0;

        for (int i = 0; i < data.getBuildList().size(); i++) {
            spaceLeft = makeSpaceLeft(data, involvedList, subtractList, leftSpaceList, spaceLeft, i);

            if (i < 1) {
                drawHeader(data, involvedList, leftSpaceList, stringBuilder, resultLength, spaceLeft, i);
            }

            if (i >= 1) {
                int countZero = zeroCounter(data, i);
                spaceLeft = drawPostHeader(data, stringBuilder, spaceLeft, countZero, i);
            }

            if (involvedList.get(i) - involvedList.get(i + 1) == 0 && involvedList.get(involvedList.size() - 1) != 0
                    && i % 2 == 0) {
                spaceLeft++;
            }
        }
        return stringBuilder.toString();
    }

    private static int makeSpaceLeft(IntegerData data, List<Integer> involvedList, List<Integer> subtractList,
            List<Integer> leftSpaceList, int spaceLeft, int i) {
        if (i % 2 == 0) {
            Collections.addAll(involvedList, Integer.parseInt(data.getBuildList().get(i).replace("_", "").trim()),
                    Integer.parseInt(data.getBuildList().get(i + 1).replace("_", "").trim()));
            Collections.addAll(subtractList, involvedList.get(i + 1), involvedList.get(i) - involvedList.get(i + 1));
        }
        leftSpaceList
                .add(String.valueOf(involvedList.get(i)).length() - String.valueOf(subtractList.get(i + 1)).length());
        spaceLeft += leftSpaceList.get(i);
        return spaceLeft;
    }

    private static int makeSpaceMiddle(IntegerData data, List<Integer> leftSpaceList, int i) {
        int spaceMiddle = String.valueOf(data.getDividend()).length()
                - String.valueOf(data.getBuildList().get(i)).length();

        if (leftSpaceList.get(i) > 0) {
            spaceMiddle = String.valueOf(data.getDividend()).length()
                    - String.valueOf(data.getBuildList().get(i)).length() - 1;
        }
        return spaceMiddle;
    }

    private static void drawHeader(IntegerData data, List<Integer> involvedList, List<Integer> leftSpaceList,
            StringBuilder stringBuilder, int resultLength, int spaceLeft, int i) {
        int spaceMiddle = makeSpaceMiddle(data, leftSpaceList, i);
        int underLines = String.valueOf(data.getBuildList().get(i)).length() - 1;
        int spaceLeftCorrection = String.valueOf(involvedList.get(i)).length()
                - String.valueOf(involvedList.get(i + 1)).length();

        if (String.valueOf(involvedList.get(i)).length() > String.valueOf(involvedList.get(i + 1)).length()) {
            underLines = String.valueOf(data.getBuildList().get(i)).length();
        }

        stringBuilder.append(String.join("", Collections.nCopies(spaceLeft, " ")) + data.getBuildList().get(i)
                + String.join("", Collections.nCopies(spaceMiddle + 1, " ")) + "|"
                + String.join("", Collections.nCopies(resultLength, "-")) + "\n");

        stringBuilder.append(" " + String.join("", Collections.nCopies(spaceLeft - spaceLeftCorrection, " "))
                + String.join("", Collections.nCopies(underLines, "-"))
                + String.join("", Collections.nCopies(spaceMiddle + 1, " ")) + "|" + data.getResult() + "\n");
    }

    private static int zeroCounter(IntegerData data, int i) {
        int countZero = 0;

        if (data.getBuildList().get(i).startsWith(" ") && data.getBuildList().get(i - 1).startsWith("_0")) {
            String[] zeroArray = data.getBuildList().get(i - 1).replace("_", "").split("");

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

    private static int drawPostHeader(IntegerData data, StringBuilder stringBuilder, int spaceLeft, int countZero,
            int i) {
        String value = String.join("", Collections.nCopies(countZero, " ")) + data.getBuildList().get(i);

        if (value.contains("_") && i == data.getBuildList().size() - 1) {
            value = data.getBuildList().get(data.getBuildList().size() - 1).replace("_", " ");
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
}