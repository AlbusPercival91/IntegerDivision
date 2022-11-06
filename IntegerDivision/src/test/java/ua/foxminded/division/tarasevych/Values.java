package ua.foxminded.division.tarasevych;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Values {

    static String testIfDividerHasOneDigitLessThanFirstVariable = "_78945|4\n" + " 4    |-----\n" + " -    |19736\n"
            + "_38\n" + " 36\n" + " --\n" + " _29\n" + "  28\n" + "  --\n" + "  _14\n" + "   12\n" + "   --\n"
            + "   _25\n" + "    24\n" + "    --\n" + "     1\n";
    static String testIfDividerHasTwoEqualDigitsGreaterThanFirstVariable = "_78945|99\n" + " 693  |---\n"
            + " ---  |797\n" + " _964\n" + "  891\n" + "  ---\n" + "  _735\n" + "   693\n" + "   ---\n" + "    42\n";
    static String testIfDividerHasTwoEqualDigitsLessThanFirstVariable = "_78945|66\n" + " 66   |----\n"
            + " --   |1196\n" + "_129\n" + "  66\n" + "  --\n" + " _634\n" + "  594\n" + "  ---\n" + "  _405\n"
            + "   396\n" + "   ---\n" + "     9\n";
    static String testIfDividerHasTwoDigitsLessThanFirstVariable = "_78945|65\n" + " 65   |----\n" + " --   |1214\n"
            + "_139\n" + " 130\n" + " ---\n" + "  _94\n" + "   65\n" + "   --\n" + "  _295\n" + "   260\n" + "   ---\n"
            + "    35\n";
    static String testIfDividerHasTwoEqualDigitsCloseLessThanFirstVariable = "_78945|77\n" + " 77   |----\n"
            + " --   |1025\n" + " _194\n" + "  154\n" + "  ---\n" + "  _405\n" + "   385\n" + "   ---\n" + "    20\n";
    static String testIfDividerAndVariableIsEquals = "_12345|1\n" + " 1    |-----\n" + " -    |12345\n" + " _2\n"
            + "  2\n" + "  -\n" + "  _3\n" + "   3\n" + "   -\n" + "   _4\n" + "    4\n" + "    -\n" + "    _5\n"
            + "     5\n" + "     -\n" + "     0\n";
    static String testIfDividerAndVariableIsEqualsWithZeroes = "_1010101|1\n" + " 1      |-------\n"
            + " -      |1010101\n" + " _01\n" + "   1\n" + "  --\n" + "   _01\n" + "     1\n" + "    --\n"
            + "     _01\n" + "       1\n" + "      --\n" + "       0\n";
    static String testIfDividerAndFewDividendDigitsIsEqualsWithZero = "_111010111|1\n" + " 1        |---------\n"
            + " -        |111010111\n" + " _1\n" + "  1\n" + "  -\n" + "  _1\n" + "   1\n" + "   -\n" + "   _01\n"
            + "     1\n" + "    --\n" + "     _01\n" + "       1\n" + "      --\n" + "       _1\n" + "        1\n"
            + "        -\n" + "        _1\n" + "         1\n" + "         -\n" + "         0\n";
    static String testIfTwoZeroesInDividendAndLastDigitEqualsDivider = "_1004|4\n" + "  8  |---\n" + " --  |251\n"
            + " _20\n" + "  20\n" + "  --\n" + "   _4\n" + "    4\n" + "    -\n" + "    0\n";
    static String testIfThreeZeroesInDividendAndLastDigitEqualsDivider = "_10004|4\n" + "  8   |----\n"
            + " --   |2501\n" + " _20\n" + "  20\n" + "  --\n" + "   _04\n" + "     4\n" + "    --\n" + "     0\n";
    static String testIfZeroesInDividendAndLastDigitEqualsDivider = "_1000404|4\n" + "  8     |------\n"
            + " --     |250101\n" + " _20\n" + "  20\n" + "  --\n" + "   _04\n" + "     4\n" + "    --\n" + "     _04\n"
            + "       4\n" + "      --\n" + "       0\n";
    static String testIfDividerEqualsAllVariablesSeparateByZero = "_120120120|12\n" + " 12       |--------\n"
            + " --       |10010010\n" + "  _012\n" + "    12\n" + "   ---\n" + "     _012\n" + "       12\n"
            + "      ---\n" + "        0\n";
    static String testIfFirstAndLastDigitEqualDividerSeparateByZero = "_1000001|1\n" + " 1      |-------\n"
            + " -      |1000001\n" + " _000001\n" + "       1\n" + "  ------\n" + "       0\n";
    static String testIfDividerNotEqualsVariablesSeparateByZero = "_1000404|5\n" + " 10     |------\n"
            + " --     |200080\n" + "  _0040\n" + "     40\n" + "   ----\n" + "       4\n";
    static String testIfDividerGreaterThanDividendWithSameDigits = "_123|1234\n" + " 0  |-\n" + " -  |0\n" + " 0\n";
    static String testIfDividendIsZero = "_0|1234\n" + " 0|-\n" + " -|0\n" + " 0\n";
    static String testIfDividerIsNegative = "_1000404|5\n" + " 10     |------\n" + " --     |200080\n" + "  _0040\n"
            + "     40\n" + "   ----\n" + "       4\n";
    static String testIfDividendIsNegative = "_78|910\n" + " 0 |-\n" + " - |0\n" + " 0\n";

    static Stream<Arguments> expectedAndActualStringProvider() {
        return Stream.of(
                arguments(testIfDividerHasOneDigitLessThanFirstVariable,
                        Draw.divisionDraw(Division.divisionCalculation(78945, 4))),
                arguments(testIfDividerHasTwoEqualDigitsGreaterThanFirstVariable,
                        Draw.divisionDraw(Division.divisionCalculation(78945, 99))),
                arguments(testIfDividerHasTwoEqualDigitsLessThanFirstVariable,
                        Draw.divisionDraw(Division.divisionCalculation(78945, 66))),
                arguments(testIfDividerHasTwoDigitsLessThanFirstVariable,
                        Draw.divisionDraw(Division.divisionCalculation(78945, 65))),
                arguments(testIfDividerHasTwoEqualDigitsCloseLessThanFirstVariable,
                        Draw.divisionDraw(Division.divisionCalculation(78945, 77))),
                arguments(testIfDividerAndVariableIsEquals, Draw.divisionDraw(Division.divisionCalculation(12345, 1))),
                arguments(testIfDividerAndVariableIsEqualsWithZeroes,
                        Draw.divisionDraw(Division.divisionCalculation(1010101, 1))),
                arguments(testIfDividerAndFewDividendDigitsIsEqualsWithZero,
                        Draw.divisionDraw(Division.divisionCalculation(111010111, 1))),
                arguments(testIfTwoZeroesInDividendAndLastDigitEqualsDivider,
                        Draw.divisionDraw(Division.divisionCalculation(1004, 4))),
                arguments(testIfThreeZeroesInDividendAndLastDigitEqualsDivider,
                        Draw.divisionDraw(Division.divisionCalculation(10004, 4))),
                arguments(testIfZeroesInDividendAndLastDigitEqualsDivider,
                        Draw.divisionDraw(Division.divisionCalculation(1000404, 4))),
                arguments(testIfDividerEqualsAllVariablesSeparateByZero,
                        Draw.divisionDraw(Division.divisionCalculation(120120120, 12))),
                arguments(testIfFirstAndLastDigitEqualDividerSeparateByZero,
                        Draw.divisionDraw(Division.divisionCalculation(1000001, 1))),
                arguments(testIfDividerNotEqualsVariablesSeparateByZero,
                        Draw.divisionDraw(Division.divisionCalculation(1000404, 5))),
                arguments(testIfDividerGreaterThanDividendWithSameDigits,
                        Draw.divisionDraw(Division.divisionCalculation(123, 1234))),
                arguments(testIfDividendIsZero, Draw.divisionDraw(Division.divisionCalculation(0, 1234))),
                arguments(testIfDividerIsNegative, Draw.divisionDraw(Division.divisionCalculation(1000404, -5))),
                arguments(testIfDividendIsNegative, Draw.divisionDraw(Division.divisionCalculation(-78, 910))));
    }
}
