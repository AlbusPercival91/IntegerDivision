package ua.foxminded.division.tarasevych;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivisionTest {

    @Test
    void divisionEngine_Test_One_Divider() {
        assertEquals(19736, Division.divisionEngine(78945, 4));
        assertEquals(11277, Division.divisionEngine(78945, 7));
        assertEquals(8771, Division.divisionEngine(78945, 9));
    }
    
    @Test
    void divisionEngine_Test_Two_Divider() {
        assertEquals(5638, Division.divisionEngine(78945, 14));
        assertEquals(1578, Division.divisionEngine(78945, 50));
        assertEquals(1127, Division.divisionEngine(78945, 70));
        assertEquals(1012, Division.divisionEngine(78945, 78));
        assertEquals(986, Division.divisionEngine(78945, 80));
        assertEquals(797, Division.divisionEngine(78945, 99));
    }
    
    @Test
    void divisionEngine_Test_Three1_Divider() {
        assertEquals(544, Division.divisionEngine(78945, 145));
    }
    
    @Test
    void divisionEngine_Test_Three2_Divider() {
        assertEquals(157, Division.divisionEngine(78945, 500));
    }
    
    @Test
    void divisionEngine_Test_Three3_Divider() {
        assertEquals(112, Division.divisionEngine(78945, 700));
    }
    
    @Test
    void divisionEngine_Test_Three4_Divider() {
        assertEquals(100, Division.divisionEngine(78945, 788)); // if next var < divider - > not working!!!!!!
    }
    
    @Test
    void divisionEngine_Test_Three5_Divider() {
        assertEquals(100, Division.divisionEngine(78945, 789));
    }
    
    @Test
    void divisionEngine_Test_Three6_Divider() {
        assertEquals(101, Division.divisionEngine(78945, 781));
    }
    
    @Test
    void divisionEngine_Test_Three7_Divider() {
        assertEquals(87, Division.divisionEngine(78945, 900));
    }
    
    @Test
    void divisionEngine_Test_Four1_Divider() {
        assertEquals(54, Division.divisionEngine(78945, 1450));
    }
    
    @Test
    void divisionEngine_Test_Four2_Divider() {
        assertEquals(15, Division.divisionEngine(78945, 5000));
    }
    
    @Test
    void divisionEngine_Test_Four3_Divider() {
        assertEquals(11, Division.divisionEngine(78945, 7000));
    }
    
    @Test
    void divisionEngine_Test_Four4_Divider() {
        assertEquals(10, Division.divisionEngine(78945, 7880));
    }
    
    @Test
    void divisionEngine_Test_Four5_Divider() {
        assertEquals(10, Division.divisionEngine(78945, 7894));
    }
    
    @Test
    void divisionEngine_Test_Four6_Divider() {
        assertEquals(9, Division.divisionEngine(78945, 7895));
    }
    
    @Test
    void divisionEngine_Test_Four7_Divider() {
        assertEquals(8, Division.divisionEngine(78945, 9000));
    }
    
    @Test
    void divisionEngine_Test_Five_Divider() {
        assertEquals(5, Division.divisionEngine(78945, 14500));
        assertEquals(1, Division.divisionEngine(78945, 50000));
        assertEquals(1, Division.divisionEngine(78945, 70000));
        assertEquals(1, Division.divisionEngine(78945, 78800));
        assertEquals(1, Division.divisionEngine(78945, 78945));
        assertEquals(0, Division.divisionEngine(78945, 78950));
        assertEquals(0, Division.divisionEngine(78945, 90000));
        
    }
    
    @Test
    void divisionEngine_Test_Six_Divider() {
        assertEquals(999999/9, Division.divisionEngine(999999, 9));
        assertEquals(999999/99, Division.divisionEngine(999999, 99));
        assertEquals(999999/999, Division.divisionEngine(999999, 999));
        assertEquals(999999/9999, Division.divisionEngine(999999, 9999));
        assertEquals(999999/99999, Division.divisionEngine(999999, 99999));
        assertEquals(999999/999999, Division.divisionEngine(999999, 999999));
        assertEquals(999999/5, Division.divisionEngine(999999, 5));
        assertEquals(999999/90, Division.divisionEngine(999999, 90));
        assertEquals(999999/150, Division.divisionEngine(999999, 150));
        assertEquals(999999/1679, Division.divisionEngine(999999, 1679));
        assertEquals(999999/12345, Division.divisionEngine(999999, 12345));
        assertEquals(999999/123456, Division.divisionEngine(999999, 123456));
        assertEquals(999999/654321, Division.divisionEngine(999999, 654321));
        assertEquals(999999/54321, Division.divisionEngine(999999, 54321));

    }
   

}
