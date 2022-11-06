package ua.foxminded.division.tarasevych;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class DrawTest {

    @ParameterizedTest
    @MethodSource("ua.foxminded.division.tarasevych.ArgumentValues#expectedAndActualStringProvider")
    void testWithMultiArgMethodSource(String expected, String actual) {
        assertEquals(expected, actual);
    }

    @Test
    void testIfDividerIsZero() {
        Exception arithmeticException = assertThrows(Exception.class,
                () -> Draw.divisionDraw(Division.divisionCalculation(78, 0)));
        assertEquals("/ by zero", arithmeticException.getMessage());
    }

    @Test
    void testIfDividerAndDividendIsZero() {
        Exception arithmeticException = assertThrows(Exception.class,
                () -> Draw.divisionDraw(Division.divisionCalculation(0, 0)));
        assertEquals("/ by zero", arithmeticException.getMessage());
    }

    @Test
    void testIfNegativeDividendAndDividerIsZero() {
        Exception arithmeticException = assertThrows(Exception.class,
                () -> Draw.divisionDraw(Division.divisionCalculation(-12345, 0)));
        assertEquals("/ by zero", arithmeticException.getMessage());
    }

}
