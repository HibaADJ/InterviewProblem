import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathFunctionCalculatorTest {

    private MathFunctionCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new MathFunctionCalculator();
    }

    @Test
    public void testAdditionAndMultiplication() {
        String output = calculator.mathFunction(2, 2, 4);
        assertTrue(output.contains("+"));
        assertTrue(output.contains("*"));
        assertFalse(output.contains("-"));
        assertFalse(output.contains("/"));
        assertFalse(output.contains("None"));
    }

    @Test
    public void testSubtraction() {
        String output = calculator.mathFunction(5, 3, 2);
        assertTrue(output.contains("-"));
        assertFalse(output.contains("*"));
        assertFalse(output.contains("+"));
        assertFalse(output.contains("/"));
        assertFalse(output.contains("None"));
    }

    @Test
    public void testDivision() {
        String output = calculator.mathFunction(10, 2, 5);
        assertTrue(output.contains("/"));
        assertFalse(output.contains("*"));
        assertFalse(output.contains("+"));
        assertFalse(output.contains("-"));
        assertFalse(output.contains("None"));
    }

    @Test
    public void testNone() {
        String output = calculator.mathFunction(1, 2, 5);
        assertEquals("None", output);
    }
}
