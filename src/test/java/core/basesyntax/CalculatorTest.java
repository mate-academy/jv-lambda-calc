package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static double DELTA = 0.0001;
    private static Calculator calculator;
    private static double actual;
    private static double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionPositivePositive_Ok() {
        actual = calculator.calculate(10.1, 20.2, ADDITION);
        expected = 30.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionNegativeNegative_Ok() {
        actual = calculator.calculate(-10.1, -20.2, ADDITION);
        expected = -30.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionPositiveNegative_Ok() {
        actual = calculator.calculate(10.1, -20.2, ADDITION);
        expected = -10.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionPositiveZero_Ok() {
        actual = calculator.calculate(10.1, 0.0, ADDITION);
        expected = 10.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionZeroNegative_Ok() {
        actual = calculator.calculate(0.0, -20.0, ADDITION);
        expected = -20.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionMaxDoubleMaxDouble_NotOk() {
        assertThrows(IllegalValues.class,
                () -> calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION));
    }

    @Test
    void calculate_additionMinDoubleMinDouble_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADDITION);
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositivePositive_Ok() {
        actual = calculator.calculate(10.1, 20.2, SUBTRACTION);
        expected = -10.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionNegativeNegative_Ok() {
        actual = calculator.calculate(-10.1, -20.2, SUBTRACTION);
        expected = 10.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionPositiveNegative_Ok() {
        actual = calculator.calculate(10.1, -20.2, SUBTRACTION);
        expected = 30.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveZero_Ok() {
        actual = calculator.calculate(10.1, 0.0, SUBTRACTION);
        expected = 10.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionZeroNegative_Ok() {
        actual = calculator.calculate(0.0, -20.0, SUBTRACTION);
        expected = 20.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMaxDoubleMaxDouble_NotOk() {
        assertThrows(IllegalValues.class,
                () -> calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION));
    }

    @Test
    void calculate_subtractionMinDoubleMinDouble_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, SUBTRACTION);
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositivePositive_Ok() {
        actual = calculator.calculate(10.1, 20.2, MULTIPLICATION);
        expected = 204.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationNegativeNegative_Ok() {
        actual = calculator.calculate(-10.1, -20.2, MULTIPLICATION);
        expected = 204.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveNegative_Ok() {
        actual = calculator.calculate(10.1, -20.2, MULTIPLICATION);
        expected = -204.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveZero_Ok() {
        actual = calculator.calculate(10.1, 0.0, MULTIPLICATION);
        expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationZeroNegative_Ok() {
        actual = calculator.calculate(0.0, -20.0, MULTIPLICATION);
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMaxDoubleMaxDouble_NotOk() {
        assertThrows(IllegalValues.class,
                () -> calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION));
    }

    @Test
    void calculate_multiplicationMinDoubleMinDouble_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        double expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionPositivePositive_Ok() {
        double actual = calculator.calculate(10.1, 20.2, DIVISION);
        double expected = 0.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionNegativeNegative_Ok() {
        double actual = calculator.calculate(-10.1, -20.2, DIVISION);
        double expected = 0.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveNegative_Ok() {
        double actual = calculator.calculate(10.1, -20.2, DIVISION);
        double expected = -0.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveZero_NotOk() {
        assertThrows(DivisionByZero.class,
                () -> calculator.calculate(10.1, 0.0, DIVISION));
    }

    @Test
    void calculate_divisionPositiveMinDouble_NotOk() {
        assertThrows(IllegalValues.class,
                () -> calculator.calculate(10.1, Double.MIN_VALUE, DIVISION));
    }

    @Test
    void calculate_divisionZeroNegative_Ok() {
        double actual = calculator.calculate(0.0, -20.0, DIVISION);
        double expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionMaxDoubleMaxDouble_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        double expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionMinDoubleMinDouble_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVISION);
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToPositivePower_Ok() {
        double actual = calculator.calculate(2.0, 10.0, POWER);
        double expected = 1024.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToPositivePower_Ok() {
        double actual = calculator.calculate(-2.0, 3.0, POWER);
        double expected = -8.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToNegativePower_Ok() {
        double actual = calculator.calculate(2.0, -2.0, POWER);
        double expected = 0.25;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToNegativePower_Ok() {
        double actual = calculator.calculate(-2.0, -3.0, POWER);
        double expected = -0.125;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToZeroPower_Ok() {
        double actual = calculator.calculate(15.0, 0.0, POWER);
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToZeroPower_Ok() {
        double actual = calculator.calculate(-5.0, 0.0, POWER);
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToPositivePower_Ok() {
        double actual = calculator.calculate(0.0, 4.0, POWER);
        double expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_rootOfNegative_NotOk() {
        assertThrows(IllegalValues.class,
                () -> calculator.calculate(-9, 0.5, POWER));
    }

    @Test
    void calculate_raisingMaxDoubleToMaxDoublePower_NotOk() {
        assertThrows(IllegalValues.class,
                () -> calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, POWER));
    }

    @Test
    void calculate_IllegalOperation_NotOk() {
        assertThrows(IllegalOperation.class,
                () -> calculator.calculate(10, 20, '$'));
    }
}
