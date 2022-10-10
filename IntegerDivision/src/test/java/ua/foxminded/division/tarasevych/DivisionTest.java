package ua.foxminded.division.tarasevych;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivisionTest {

    @Test
    void test_4() {
        assertEquals("_78945|4\n"
                + " 4    |-----\n"
                + " -    |19736\n"
                + " 38\n"
                + " 36\n"
                + " --\n"
                + "  29\n"
                + "  28\n"
                + "  --\n"
                + "   14\n"
                + "   12\n"
                + "   --\n"
                + "    25\n"
                + "    24\n"
                + "    --\n"
                + "     1\n"
                + "", Division.longDivision(78945, 4));
    }
    
    @Test
    void test_99() {
        assertEquals("_78945|99\n"
                + " 693  |---\n"
                + " ---  |797\n"
                + "  964\n"
                + "  891\n"
                + "  ---\n"
                + "   735\n"
                + "   693\n"
                + "   ---\n"
                + "    42\n"
                + "", Division.longDivision(78945, 99));
    }
}
