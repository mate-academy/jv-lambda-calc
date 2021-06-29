package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double DELTA = 0.0001d;
    private static Calculator testCalculator;

    @BeforeAll
    static void beforeAll() {
        testCalculator = new Calculator();
    }

    /**
     * Tests for method calculate()
     */
    @Test
    void calculate_LegalOperation_OK() {
        double firstArgument = 200.0;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = 300.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_IllegalOperation_notOK() {
        double firstArgument = 200.0;
        double secondArgument = 100.0;
        char operation = '?';
        assertThrows(IllegalStateException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for addition, first parameter : -MAX_VALUE
     */
    @Test
    void calculate_additionOfMinusDoubleMaxAndMinusDoubleMax_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '+';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_additionOfMinusDoubleMaxAndNegativeNumber_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = -Double.MAX_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfMinusDoubleMaxAndMinusDoubleMin_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '+';
        double expected = -Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfMinusDoubleMaxAndZero_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '+';
        double expected = -Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfMinusDoubleMaxAndDoubleMin_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '+';
        double expected = -Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfMinusDoubleMaxAndPositiveNumber_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = -Double.MAX_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfMinusDoubleMaxAndDoubleMax_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for addition, first parameter :  negative number
     */
    @Test
    void calculate_additionOfNegativeNumberAndMinusDoubleMax_OK() {
        double firstArgument = -200.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '+';
        double expected = -200.0 - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfNegativeNumberAndNegativeNumber_OK() {
        double firstArgument = -200.0;
        double secondArgument = -100.0;
        char operation = '+';
        double expected = -300.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfNegativeNumberAndMinusDoubleMin_OK() {
        double firstArgument = -200.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '+';
        double expected = -200.0 - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfNegativeNumberAndZero_OK() {
        double firstArgument = -200.0;
        double secondArgument = 0.0;
        char operation = '+';
        double expected = -200.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfNegativeNumberAndDoubleMin_OK() {
        double firstArgument = -200.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '+';
        double expected = -200.0 + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfNegativeNumberAndPositiveNumber_OK() {
        double firstArgument = -200.0;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = -100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfNegativeNumberAndDoubleMax_OK() {
        double firstArgument = -200.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        double expected = -200.0 + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for addition, first parameter :  -MIN_VALUE
     */
    @Test
    void calculate_additionOfMinusDoubleMinAndMinusDoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '+';
        double expected = -Double.MIN_VALUE - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfMinusDoubleMinAndNegativeNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -100.0;
        char operation = '+';
        double expected = -Double.MIN_VALUE - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfMinusDoubleMinAndMinusDoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '+';
        double expected = -Double.MIN_VALUE - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfMinusDoubleMinAndZero_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '+';
        double expected = -Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfMinusDoubleMinAndDoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '+';
        double expected = -Double.MIN_VALUE + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfMinusDoubleMinAndPositiveNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = -Double.MIN_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfMinusDoubleMinAndDoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        double expected = -Double.MIN_VALUE + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for addition, first parameter :  Zero
     */
    @Test
    void calculate_additionOfZeroAndMinusDoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '+';
        double expected = -Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfZeroAndNegativeNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = -100.0;
        char operation = '+';
        double expected = -100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfZeroAndMinusDoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '+';
        double expected = -Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfZeroAndZero_OK() {
        double firstArgument = 0.0;
        double secondArgument = 0.0;
        char operation = '+';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfZeroAndDoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '+';
        double expected = Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfZeroAndPositiveNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfZeroAndDoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        double expected = Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for addition, first parameter :  MIN_VALUE
     */
    @Test
    void calculate_additionOfDoubleMinAndMinusDoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '+';
        double expected = Double.MIN_VALUE - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfDoubleMinAndNegativeNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -100.0;
        char operation = '+';
        double expected = Double.MIN_VALUE - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfDoubleMinAndMinusDoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '+';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfDoubleMinAndZero_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 0;
        char operation = '+';
        double expected = Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfDoubleMinAndDoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        double expected = Double.MIN_VALUE + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfDoubleMinAndPositiveNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = Double.MIN_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfDoubleMinAndDoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        double expected = Double.MIN_VALUE + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for addition, first parameter :  positive number
     */
    @Test
    void calculate_additionOfPositiveNumberAndMinusDoubleMax_OK() {
        double firstArgument = 200.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '+';
        double expected = 200.0 - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfPositiveNumberAndNegativeNumber_OK() {
        double firstArgument = 200.0;
        double secondArgument = -100.0;
        char operation = '+';
        double expected = 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfPositiveNumberAndMinusDoubleMin_OK() {
        double firstArgument = 200.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '+';
        double expected = 200.0 - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfPositiveNumberAndZero_OK() {
        double firstArgument = 200.0;
        double secondArgument = 0.0;
        char operation = '+';
        double expected = 200.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfPositiveNumberAndDoubleMin_OK() {
        double firstArgument = 200.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '+';
        double expected = 200.0 + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfPositiveNumberAndPositiveNumber_OK() {
        double firstArgument = 200.0;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = 300.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfPositiveNumberAndDoubleMax_OK() {
        double firstArgument = 200.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        double expected = 200.0 + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for addition, first parameter : MAX_VALUE
     */
    @Test
    void calculate_additionOfDoubleMaxAndMinusDoubleMax_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '+';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfDoubleMaxAndNegativeNumber_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -100.0;
        char operation = '+';
        double expected = Double.MAX_VALUE - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfDoubleMaxAndMinusDoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '+';
        double expected = Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfDoubleMaxAndZero_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '+';
        double expected = Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfDoubleMaxAndDoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '+';
        double expected = Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfDoubleMaxAndPositiveNumber_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 100.0;
        char operation = '+';
        double expected = Double.MAX_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOfDoubleMaxAndDoubleMax_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '+';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for subtraction, first parameter : -MAX_VALUE
     */
    @Test
    void calculate_subtractionOfMinusDoubleMaxAndMinusDoubleMax_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '-';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfMinusDoubleMaxAndNegativeNumber_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -100.0;
        char operation = '-';
        double expected = -Double.MAX_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfMinusDoubleMaxAndMinusDoubleMin_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '-';
        double expected = -Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfMinusDoubleMaxAndZero_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '-';
        double expected = -Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfMinusDoubleMaxAndDoubleMin_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '-';
        double expected = -Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfMinusDoubleMaxAndPositiveNumber_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 100.0;
        char operation = '-';
        double expected = -Double.MAX_VALUE - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfMinusDoubleMaxAndDoubleMax_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '-';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for subtraction, first parameter :  negative number
     */
    @Test
    void calculate_subtractionOfNegativeNumberAndMinusDoubleMax_OK() {
        double firstArgument = -200.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '-';
        double expected = -200.0 + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfNegativeNumberAndNegativeNumber_OK() {
        double firstArgument = -200.0;
        double secondArgument = -100.0;
        char operation = '-';
        double expected = -100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfNegativeNumberAndMinusDoubleMin_OK() {
        double firstArgument = -200.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '-';
        double expected = -200.0 + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfNegativeNumberAndZero_OK() {
        double firstArgument = -200.0;
        double secondArgument = 0.0;
        char operation = '-';
        double expected = -200.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfNegativeNumberAndDoubleMin_OK() {
        double firstArgument = -200.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '-';
        double expected = -200.0 - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfNegativeNumberAndPositiveNumber_OK() {
        double firstArgument = -200.0;
        double secondArgument = 100.0;
        char operation = '-';
        double expected = -200.0 - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfNegativeNumberAndDoubleMax_OK() {
        double firstArgument = -200.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '-';
        double expected = -200.0 - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for subtraction, first parameter :  -MIN_VALUE
     */
    @Test
    void calculate_subtractionOfMinusDoubleMinAndMinusDoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '-';
        double expected = -Double.MIN_VALUE + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_SubtractionOfMinusDoubleMinAndNegativeNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -100.0;
        char operation = '-';
        double expected = -Double.MIN_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfMinusDoubleMinAndMinusDoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '-';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfMinusDoubleMinAndZero_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '-';
        double expected = -Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfMinusDoubleMinAndDoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '-';
        double expected = -Double.MIN_VALUE - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfMinusDoubleMinAndPositiveNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 100.0;
        char operation = '-';
        double expected = -Double.MIN_VALUE - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfMinusDoubleMinAndDoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '-';
        double expected = -Double.MIN_VALUE - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for subtraction, first parameter :  Zero
     */
    @Test
    void calculate_subtractionOfZeroAndMinusDoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '-';
        double expected = Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfZeroAndNegativeNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = -100.0;
        char operation = '-';
        double expected = 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfZeroAndMinusDoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '-';
        double expected = Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfZeroAndZero_OK() {
        double firstArgument = 0.0;
        double secondArgument = 0.0;
        char operation = '-';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfZeroAndDoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '-';
        double expected = -Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfZeroAndPositiveNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = 100.0;
        char operation = '-';
        double expected = -100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfZeroAndDoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '-';
        double expected = -Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for subtraction, first parameter :  MIN_VALUE
     */
    @Test
    void calculate_subtractionOfDoubleMinAndMinusDoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '-';
        double expected = Double.MIN_VALUE + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfDoubleMinAndNegativeNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -100.0;
        char operation = '-';
        double expected = Double.MIN_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfDoubleMinAndMinusDoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '-';
        double expected = Double.MIN_VALUE + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfDoubleMinAndZero_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '-';
        double expected = Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfDoubleMinAndDoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '-';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfDoubleMinAndPositiveNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 100.0;
        char operation = '-';
        double expected = Double.MIN_VALUE - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfDoubleMinAndDoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '-';
        double expected = Double.MIN_VALUE - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for subtraction, first parameter :  positive number
     */
    @Test
    void calculate_subtractionOfPositiveNumberAndMinusDoubleMax_OK() {
        double firstArgument = 200.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '-';
        double expected = 200.0 + Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfPositiveNumberAndNegativeNumber_OK() {
        double firstArgument = 200.0;
        double secondArgument = -100.0;
        char operation = '-';
        double expected = 300.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfPositiveNumberAndMinusDoubleMin_OK() {
        double firstArgument = 200.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '-';
        double expected = 200.0 + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfPositiveNumberAndZero_OK() {
        double firstArgument = 200.0;
        double secondArgument = 0.0;
        char operation = '-';
        double expected = 200.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfPositiveNumberAndDoubleMin_OK() {
        double firstArgument = 200.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '-';
        double expected = 200.0 - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfPositiveNumberAndPositiveNumber_OK() {
        double firstArgument = 200.0;
        double secondArgument = 100.0;
        char operation = '-';
        double expected = 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfPositiveNumberAndDoubleMax_OK() {
        double firstArgument = 200.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '-';
        double expected = 200.0 - Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for subtraction, first parameter : MAX_VALUE
     */
    @Test
    void calculate_subtractionOfDoubleMaxAndMinusDoubleMax_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '-';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_subtractionOfDoubleMaxAndNegativeNumber_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -100.0;
        char operation = '-';
        double expected = Double.MAX_VALUE + 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfDoubleMaxAndMinusDoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '-';
        double expected = Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfDoubleMaxAndZero_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '-';
        double expected = Double.MAX_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfDoubleMaxAndDoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '-';
        double expected = Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfDoubleMaxAndPositiveNumber_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 100.0;
        char operation = '-';
        double expected = Double.MAX_VALUE - 100.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfDoubleMaxAndDoubleMax_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '-';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for division, first parameter : -MAX_VALUE
     */
    @Test
    void calculate_divisionOfMinusDoubleMaxAndMinusDoubleMax_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '/';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfMinusDoubleMaxAndNegativeNumber_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -2.0;
        char operation = '/';
        double expected = Double.MAX_VALUE * 0.5;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfMinusDoubleMaxAndMinusDoubleMin_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_divisionOfMinusDoubleMaxAndZero_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_divisionOfMinusDoubleMaxAndDoubleMin_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_divisionOfMinusDoubleMaxAndPositiveNumber_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 2.0;
        char operation = '/';
        double expected = -Double.MAX_VALUE * 0.5;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfMinusDoubleMaxAndDoubleMax_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '/';
        double expected = -1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for division, first parameter :  negative number
     */
    @Test
    void calculate_divisionOfNegativeNumberAndMinusDoubleMax_OK() {
        double firstArgument = -2.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfNegativeNumberAndNegativeNumber_OK() {
        double firstArgument = -4.0;
        double secondArgument = -2.0;
        char operation = '/';
        double expected = 2.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfNegativeNumberAndMinusDoubleMin_notOK() {
        double firstArgument = -2.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_divisionOfNegativeNumberAndZero_notOK() {
        double firstArgument = -2.0;
        double secondArgument = 0;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_divisionOfNegativeNumberAndDoubleMin_notOK() {
        double firstArgument = -2.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_divisionOfNegativeNumberAndPositiveNumber_OK() {
        double firstArgument = -4.0;
        double secondArgument = 2.0;
        char operation = '/';
        double expected = -2.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfNegativeNumberAndDoubleMax_OK() {
        double firstArgument = -2.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for division, first parameter :  -MIN_VALUE
     */
    @Test
    void calculate_divisionOfMinusDoubleMinAndMinusDoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfMinusDoubleMinAndNegativeNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -2.0;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfMinusDoubleMinAndMinusDoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '/';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfMinusDoubleMinAndZero_notOK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 0;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_divisionOfMinusDoubleMinAndDoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '/';
        double expected = -1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfMinusDoubleMinAndPositiveNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 2.0;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfMinusDoubleMinAndDoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for division, first parameter :  Zero
     */
    @Test
    void calculate_divisionOfZeroAndMinusDoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfZeroAndNegativeNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = -2.0;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfZeroAndMinusDoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfZeroAndZero_notOK() {
        double firstArgument = 0.0;
        double secondArgument = 0.0;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_divisionOfZeroAndDoubleMin_OK() {
        double firstArgument = 0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfZeroAndPositiveNumber_OK() {
        double firstArgument = 0;
        double secondArgument = 2.0;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfZeroAndDoubleMax_OK() {
        double firstArgument = 0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for division, first parameter :  MIN_VALUE
     */
    @Test
    void calculate_divisionOfDoubleMinAndMinusDoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfDoubleMinAndNegativeNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -2.0;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfDoubleMinAndMinusDoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '/';
        double expected = -1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfDoubleMinAndZero_notOK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_divisionOfDoubleMinAndDoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '/';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfDoubleMinAndPositiveNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 2.0;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfDoubleMinAndDoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for division, first parameter :  positive number
     */
    @Test
    void calculate_divisionOfPositiveNumberAndMinusDoubleMax_OK() {
        double firstArgument = 4.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfPositiveNumberAndNegativeNumber_OK() {
        double firstArgument = 4.0;
        double secondArgument = -2.0;
        char operation = '/';
        double expected = -2.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfPositiveNumberAndMinusDoubleMin_notOK() {
        double firstArgument = 4.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_divisionOfPositiveNumberAndZero_notOK() {
        double firstArgument = 4.0;
        double secondArgument = 0.0;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_divisionOfPositiveNumberAndDoubleMin_notOK() {
        double firstArgument = 4.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_divisionOfPositiveNumberAndPositiveNumber_OK() {
        double firstArgument = 4.0;
        double secondArgument = 2.0;
        char operation = '/';
        double expected = 2.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfPositiveNumberAndDoubleMax_OK() {
        double firstArgument = 4.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '/';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for division, first parameter : MAX_VALUE
     */
    @Test
    void calculate_divisionOfDoubleMaxAndMinusDoubleMax_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '/';
        double expected = -1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfDoubleMaxAndNegativeNumber_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -2.0;
        char operation = '/';
        double expected = -Double.MAX_VALUE * 0.5;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfDoubleMaxAndMinusDoubleMin_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_divisionOfDoubleMaxAndZero_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_divisionOfDoubleMaxAndDoubleMin_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_divisionOfDoubleMaxAndPositiveNumber_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 2.0;
        char operation = '/';
        double expected = Double.MAX_VALUE * 0.5;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfDoubleMaxAndDoubleMax_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '/';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for multiplication, first parameter : -MAX_VALUE
     */
    @Test
    void calculate_multiplicationOfMinusDoubleMaxAndMinusDoubleMax_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_multiplicationOfMinusDoubleMaxAndNegativeNumber_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -200.0;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_multiplicationOfMinusDoubleMaxAndMinusDoubleMin_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfMinusDoubleMaxAndZero_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfMinusDoubleMaxAndDoubleMin_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfMinusDoubleMaxAndPositiveNumber_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 200.0;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_multiplicationOfMinusDoubleMaxAndDoubleMax_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for multiplication, first parameter :  negative number
     */
    @Test
    void calculate_multiplicationOfNegativeNumberAndMinusDoubleMax_notOK() {
        double firstArgument = -200.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_multiplicationOfNegativeNumberAndNegativeNumber_OK() {
        double firstArgument = -200.0;
        double secondArgument = -100.0;
        char operation = '*';
        double expected = 20000.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfNegativeNumberAndMinusDoubleMin_OK() {
        double firstArgument = -200.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfNegativeNumberAndZero_OK() {
        double firstArgument = -200.0;
        double secondArgument = 0.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfNegativeNumberAndDoubleMin_OK() {
        double firstArgument = -200.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfNegativeNumberAndPositiveNumber_OK() {
        double firstArgument = -200.0;
        double secondArgument = 100.0;
        char operation = '*';
        double expected = -20000.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfNegativeNumberAndDoubleMax_notOK() {
        double firstArgument = -200.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for multiplication, first parameter :  -MIN_VALUE
     */
    @Test
    void calculate_multiplicationOfMinusDoubleMinAndMinusDoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfMinusDoubleMinAndNegativeNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -100.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfMinusDoubleMinAndMinusDoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfMinusDoubleMinAndZero_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfMinusDoubleMinAndDoubleMin_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfMinusDoubleMinAndPositiveNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 100.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfMinusDoubleMinAndDoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for multiplication, first parameter :  Zero
     */
    @Test
    void calculate_multiplicationOfZeroAndMinusDoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfZeroAndNegativeNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = -100.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfZeroAndMinusDoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfZeroAndZero_OK() {
        double firstArgument = 0.0;
        double secondArgument = 0.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfZeroAndDoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfZeroAndPositiveNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = 100.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfZeroAndDoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for multiplication, first parameter :  MIN_VALUE
     */
    @Test
    void calculate_multiplicationOfDoubleMinAndMinusDoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfDoubleMinAndNegativeNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -200.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfDoubleMinAndMinusDoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfDoubleMinAndZero_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfDoubleMinAndDoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfDoubleMinAndPositiveNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 100.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfDoubleMinAndDoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for multiplication, first parameter :  positive number
     */
    @Test
    void calculate_multiplicationOfPositiveNumberAndMinusDoubleMax_notOK() {
        double firstArgument = 200.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_multiplicationOfPositiveNumberAndNegativeNumber_OK() {
        double firstArgument = 200.0;
        double secondArgument = -100.0;
        char operation = '*';
        double expected = -20000.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfPositiveNumberAndMinusDoubleMin_OK() {
        double firstArgument = 200.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfPositiveNumberAndZero_OK() {
        double firstArgument = 200.0;
        double secondArgument = 0.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfPositiveNumberAndDoubleMin_OK() {
        double firstArgument = 200.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfPositiveNumberAndPositiveNumber_OK() {
        double firstArgument = 200.0;
        double secondArgument = 100.0;
        char operation = '*';
        double expected = 20000.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfPositiveNumberAndDoubleMax_notOK() {
        double firstArgument = 200.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for multiplication, first parameter : MAX_VALUE
     */
    @Test
    void calculate_multiplicationOfDoubleMaxAndMinusDoubleMax_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_multiplicationOfDoubleMaxAndNegativeNumber_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -200.0;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_multiplicationOfDoubleMaxAndMinusDoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfDoubleMaxAndZero_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfDoubleMaxAndDoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '*';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfDoubleMaxAndPositiveNumber_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 100.0;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_multiplicationOfDoubleMaxAndDoubleMax_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for raising to a power, first parameter : -MAX_VALUE
     */
    @Test
    void calculate_PowerOfMinusDoubleMaxAndMinusDoubleMax_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfMinusDoubleMaxAndNegativeNumber_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -2.0;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfMinusDoubleMaxAndMinusDoubleMin_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_PowerOfMinusDoubleMaxAndZero_OK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfMinusDoubleMaxAndDoubleMin_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_PowerOfMinusDoubleMaxAndPositiveNumber_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = 2;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_PowerOfMinusDoubleMaxAndDoubleMax_notOK() {
        double firstArgument = -Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for raising to a power, first parameter :  negative number
     */
    @Test
    void calculate_PowerOfNegativeNumberAndMinusDoubleMax_OK() {
        double firstArgument = -2.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfNegativeNumberAndNegativeNumber_OK() {
        double firstArgument = -2.0;
        double secondArgument = -2.0;
        char operation = '^';
        double expected = 0.25;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfNegativeNumberAndMinusDoubleMin_notOK() {
        double firstArgument = -2.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_PowerOfNegativeNumberAndZero_OK() {
        double firstArgument = -2.0;
        double secondArgument = 0.0;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfNegativeNumberAndDoubleMin_notOK() {
        double firstArgument = -2.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_PowerOfNegativeNumberAndPositiveNumber_OK() {
        double firstArgument = -2.0;
        double secondArgument = 2.0;
        char operation = '^';
        double expected = 4.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfNegativeNumberAndDoubleMax_notOK() {
        double firstArgument = -2.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for raising to a power, first parameter :  -MIN_VALUE
     */
    @Test
    void calculate_PowerOfMinusDoubleMinAndMinusDoubleMax_notOK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_PowerOfMinusDoubleMinAndNegativeNumber_notOK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -2.0;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_PowerOfMinusDoubleMinAndMinusDoubleMin_notOK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_PowerOfMinusDoubleMinAndZero_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfMinusDoubleMinAndDoubleMin_notOK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_PowerOfMinusDoubleMinAndPositiveNumber_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = 2.0;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfMinusDoubleMinAndDoubleMax_OK() {
        double firstArgument = -Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for raising to a power, first parameter :  Zero
     */
    @Test
    void calculate_PowerOfZeroAndMinusDoubleMax_notOK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_PowerOfZeroAndNegativeNumber_notOK() {
        double firstArgument = 0.0;
        double secondArgument = -2.0;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_PowerOfZeroAndMinusDoubleMin_notOK() {
        double firstArgument = 0.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_PowerOfZeroAndZero_OK() {
        double firstArgument = 0.0;
        double secondArgument = 0.0;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfZeroAndDoubleMin_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfZeroAndPositiveNumber_OK() {
        double firstArgument = 0.0;
        double secondArgument = 2.0;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfZeroAndDoubleMax_OK() {
        double firstArgument = 0.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for raising to a power, first parameter :  MIN_VALUE
     */
    @Test
    void calculate_PowerOfDoubleMinAndMinusDoubleMax_notOK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_PowerOfDoubleMinAndNegativeNumber_notOK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -2.0;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_PowerOfDoubleMinAndMinusDoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfDoubleMinAndZero_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 0.0;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfDoubleMinAndDoubleMin_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfDoubleMinAndPositiveNumber_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = 2.0;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfDoubleMinAndDoubleMax_OK() {
        double firstArgument = Double.MIN_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    /**
     * Tests for raising to a power, first parameter :  positive number
     */
    @Test
    void calculate_PowerOfPositiveNumberAndMinusDoubleMax_OK() {
        double firstArgument = 2.0;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfPositiveNumberAndNegativeNumber_OK() {
        double firstArgument = 2.0;
        double secondArgument = -2.0;
        char operation = '^';
        double expected = 0.25;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfPositiveNumberAndMinusDoubleMin_OK() {
        double firstArgument = 2.0;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfPositiveNumberAndZero_OK() {
        double firstArgument = 2.0;
        double secondArgument = 0.0;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfPositiveNumberAndDoubleMin_OK() {
        double firstArgument = 2.0;
        double secondArgument = Double.MIN_VALUE;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfPositiveNumberAndPositiveNumber_OK() {
        double firstArgument = 2.0;
        double secondArgument = 2.0;
        char operation = '^';
        double expected = 4.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfPositiveNumberAndDoubleMax_notOK() {
        double firstArgument = 2.0;
        double secondArgument = Double.MAX_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    /**
     * Tests for raising to a power, first parameter : MAX_VALUE
     */
    @Test
    void calculate_PowerOfDoubleMaxAndMinusDoubleMax_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MAX_VALUE;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfDoubleMaxAndNegativeNumber_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -2.0;
        char operation = '^';
        double expected = 0.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfDoubleMaxAndMinusDoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = -Double.MIN_VALUE;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfDoubleMaxAndZero_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 0.0;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfDoubleMaxAndDoubleMin_OK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MIN_VALUE;
        char operation = '^';
        double expected = 1.0;
        double actual = testCalculator.calculate(firstArgument, secondArgument, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_PowerOfDoubleMaxAndPositiveNumber_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = 2.0;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }

    @Test
    void calculate_PowerOfDoubleMaxAndDoubleMax_notOK() {
        double firstArgument = Double.MAX_VALUE;
        double secondArgument = Double.MAX_VALUE;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(firstArgument, secondArgument, operation));
    }
}
