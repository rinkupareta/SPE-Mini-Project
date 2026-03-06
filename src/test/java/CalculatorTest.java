import com.devops.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testSquareRoot() {
        assertEquals(3.0, calculator.squareRoot(9), 0.0001);
        assertEquals(5.0, calculator.squareRoot(25), 0.0001); // change the test case-> to check system status
        assertEquals(0.0, calculator.squareRoot(0), 0.0001);
        assertTrue(Double.isNaN(calculator.squareRoot(-9))); // NaN for negative numbers
    }

    @Test
    void testFactorial() {
        assertEquals(1, calculator.factorial(0));  // 0! = 1
        assertEquals(1, calculator.factorial(1));
        assertEquals(120, calculator.factorial(5));
        assertEquals(3628800, calculator.factorial(10));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-5));
        assertEquals("Factorial is not defined for negative numbers", exception.getMessage());
    }

    @Test
    void testNaturalLog() {
        assertEquals(0.0, calculator.naturalLog(1), 0.0001);
        assertEquals(Math.log(10), calculator.naturalLog(10), 0.0001);

        Exception exceptionZero = assertThrows(IllegalArgumentException.class, () -> calculator.naturalLog(0));
        assertEquals("Logarithm is not defined for zero or negative numbers", exceptionZero.getMessage());

        Exception exceptionNegative = assertThrows(IllegalArgumentException.class, () -> calculator.naturalLog(-5));
        assertEquals("Logarithm is not defined for zero or negative numbers", exceptionNegative.getMessage());
    }

    @Test
    void testPower() {
        assertEquals(8.0, calculator.power(2, 3), 0.0001);
        assertEquals(1.0, calculator.power(5, 0), 0.0001);  // x^0 = 1
        assertEquals(0.25, calculator.power(2, -2), 0.0001); // 2^-2 = 0.25
        assertEquals(1.0, calculator.power(0, 0), 0.0001);  // 0^0 is typically defined as 1
        assertEquals(0.0, calculator.power(0, 5), 0.0001);  // 0^n = 0 for n > 0
    }
}