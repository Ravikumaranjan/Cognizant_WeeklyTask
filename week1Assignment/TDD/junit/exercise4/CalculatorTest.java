import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    // Setup Method
    @Before
    public void setUp() {
        System.out.println("Setting up Calculator...");
        calculator = new Calculator();
    }

    // Test using AAA Pattern
    @Test
    public void testAddition() {

        // Arrange
        int num1 = 10;
        int num2 = 20;

        // Act
        int result = calculator.add(num1, num2);

        // Assert
        assertEquals(30, result);
    }

    // Another Test
    @Test
    public void testSubtraction() {

        // Arrange
        int num1 = 20;
        int num2 = 10;

        // Act
        int result = calculator.subtract(num1, num2);

        // Assert
        assertEquals(10, result);
    }

    // Teardown Method
    @After
    public void tearDown() {
        System.out.println("Cleaning up...");
        calculator = null;
    }
}