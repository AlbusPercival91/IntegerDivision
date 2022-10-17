package ua.foxminded.division.tarasevych;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivisionTest {

    @Test
    void test_4() {
        assertEquals("_78945|4\n"
                + " 4    |-----\n"
                + " -    |19736\n"
                + "_38\n"
                + " 36\n"
                + " --\n"
                + " _29\n"
                + "  28\n"
                + "  --\n"
                + "  _14\n"
                + "   12\n"
                + "   --\n"
                + "   _25\n"
                + "    24\n"
                + "    --\n"
                + "     1\n", Division.longDivision(78945, 4));
    }
    
    @Test
    void test_99() {
        assertEquals("_78945|99\n"
                + " 693  |---\n"
                + " ---  |797\n"
                + " _964\n"
                + "  891\n"
                + "  ---\n"
                + "  _735\n"
                + "   693\n"
                + "   ---\n"
                + "    42\n", Division.longDivision(78945, 99));
    }
    
    @Test
    void test_66() {
        assertEquals("_78945|66\n"
                + " 66   |----\n"
                + " --   |1196\n"
                + "_129\n"
                + "  66\n"
                + "  --\n"
                + " _634\n"
                + "  594\n"
                + "  ---\n"
                + "  _405\n"
                + "   396\n"
                + "   ---\n"
                + "     9\n", Division.longDivision(78945, 66));
    }
    
    @Test
    void test_65() {
        assertEquals("_78945|65\n"
                + " 65   |----\n"
                + " --   |1214\n"
                + "_139\n"
                + " 130\n"
                + " ---\n"
                + "  _94\n"
                + "   65\n"
                + "   --\n"
                + "  _295\n"
                + "   260\n"
                + "   ---\n"
                + "    35\n", Division.longDivision(78945, 65));
    }
    
    @Test
    void test_77() {
        assertEquals("_78945|77\n"
                + " 77   |----\n"
                + " --   |1025\n"
                + " _194\n"
                + "  154\n"
                + "  ---\n"
                + "  _405\n"
                + "   385\n"
                + "   ---\n"
                + "    20\n", Division.longDivision(78945, 77));
    }
}
