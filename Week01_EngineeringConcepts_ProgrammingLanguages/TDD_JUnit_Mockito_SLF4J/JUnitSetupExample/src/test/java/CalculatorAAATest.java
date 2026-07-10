import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CalculatorAAATest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: New Calculator instance created.");
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator instance cleared.");
    }

    @Test
    public void testAdd() {
        int a = 10;
        int b = 5;
        int expected = 15;

        int actual = calculator.add(a, b);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtract() {

        int a = 20;
        int b = 8;
        int expected = 12;

        int actual = calculator.subtract(a, b);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddNegativeNumbers() {

        int a = -5;
        int b = -7;
        int expected = -12;

        int actual = calculator.add(a, b);

        assertEquals(expected, actual);
    }
}