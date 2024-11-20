/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package calcTests;
import com.mthree.c403softwaredevelopmentusingjavaproject.exercises.junit.calculator.Calc;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author khali
 */
public class DivFloorTest {
    
    @Test
    public void testDivFloor() {
        Calc c1 = new Calc();
        int divFloorOutput = c1.divFloor(50, 20);
        assertEquals(2, divFloorOutput);
    }
    
}
