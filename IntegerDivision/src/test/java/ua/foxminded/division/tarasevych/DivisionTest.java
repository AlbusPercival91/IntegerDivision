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
    
    @Test
    void test_12345() {
        assertEquals("_12345|1\n"
                + " 1    |-----\n"
                + " -    |12345\n"
                + " _2\n"
                + "  2\n"
                + "  -\n"
                + "  _3\n"
                + "   3\n"
                + "   -\n"
                + "   _4\n"
                + "    4\n"
                + "    -\n"
                + "    _5\n"
                + "     5\n"
                + "     -\n"
                + "     0\n", Division.longDivision(12345, 1));
    }
    
    
    
    @Test
    void test_1010101() {
        assertEquals("_1010101|1\n"
                + " 1      |-------\n"
                + " -      |1010101\n"
                + " _01\n"
                + "   1\n"
                + "  --\n"
                + "   _01\n"
                + "     1\n"
                + "    --\n"
                + "     _01\n"
                + "       1\n"
                + "      --\n"
                + "       0\n", Division.longDivision(1010101, 1));
    }
    
    @Test
    void test_111010111() {
        assertEquals("_111010111|1\n"
                + " 1        |---------\n"
                + " -        |111010111\n"
                + " _1\n"
                + "  1\n"
                + "  -\n"
                + "  _1\n"
                + "   1\n"
                + "   -\n"
                + "   _01\n"
                + "     1\n"
                + "    --\n"
                + "     _01\n"
                + "       1\n"
                + "      --\n"
                + "       _1\n"
                + "        1\n"
                + "        -\n"
                + "        _1\n"
                + "         1\n"
                + "         -\n"
                + "         0\n", Division.longDivision(111010111, 1));
    }
    
    @Test
    void test_1004() {
        assertEquals("_1004|4\n"
                + "  8  |---\n"
                + " --  |251\n"
                + " _20\n"
                + "  20\n"
                + "  --\n"
                + "   _4\n"
                + "    4\n"
                + "    -\n"
                + "    0\n", Division.longDivision(1004, 4));
    }
    
    @Test
    void test_10004() {
        assertEquals("_10004|4\n"
                + "  8   |----\n"
                + " --   |2501\n"
                + " _20\n"
                + "  20\n"
                + "  --\n"
                + "   _04\n"
                + "     4\n"
                + "    --\n"
                + "     0\n", Division.longDivision(10004, 4));
    }
    
    @Test
    void test_1000404() {
        assertEquals("_1000404|4\n"
                + "  8     |------\n"
                + " --     |250101\n"
                + " _20\n"
                + "  20\n"
                + "  --\n"
                + "   _04\n"
                + "     4\n"
                + "    --\n"
                + "     _04\n"
                + "       4\n"
                + "      --\n"
                + "       0\n", Division.longDivision(1000404, 4));
    }
    
    @Test
    void test_100404() {
        assertEquals("_100404|4\n"
                + "  8    |-----\n"
                + " --    |25101\n"
                + " _20\n"
                + "  20\n"
                + "  --\n"
                + "   _4\n"
                + "    4\n"
                + "    -\n"
                + "    _04\n"
                + "      4\n"
                + "     --\n"
                + "      0\n", Division.longDivision(100404, 4));
    }
    
    @Test
    void test_120120120() {
        assertEquals("_120120120|12\n"
                + " 12       |--------\n"
                + " --       |10010010\n"
                + "  _012\n"
                + "    12\n"
                + "   ---\n"
                + "     _012\n"
                + "       12\n"
                + "      ---\n"
                + "        0\n", Division.longDivision(120120120, 12));
    }
    
    @Test
    void test_1000001() {
        assertEquals("_1000001|1\n"
                + " 1      |-------\n"
                + " -      |1000001\n"
                + " _000001\n"
                + "       1\n"
                + "  ------\n"
                + "       0\n", Division.longDivision(1000001, 1));
    }
    
    @Test
    void test_1000404_5() {
        assertEquals("_1000404|5\n"
                + " 10     |------\n"
                + " --     |200080\n"
                + "  _0040\n"
                + "     40\n"
                + "   ----\n"
                + "       4\n", Division.longDivision(1000404, 5));
    }
   
}
