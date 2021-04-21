package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER = '^';
    private static final char NOT_CORRECT_OPERATOR = '\\';
    private static final double DELTA = 1e-6;
    private static Calculator calculator;

    @BeforeAll
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void calculate_additionWithTwoPositiveValues_Ok() {
        double sum = calculator.calculator(
                0.1, 0.1, ADDITION);
        double correctResult = 0.2;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void calculate_additionWithTwoNegativeValues_Ok() {
        double sum = calculator.calculator(
                -0.3, -0.3, ADDITION);
        double correctResult = -0.6;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void calculate_additionWithPositiveAndNegativeValues_Ok() {
        double sum = calculator.calculator(
                -0.3, 0.1, ADDITION);
        double correctResult = -0.1999999;
        Assertions.assertEquals(correctResult, sum, DELTA);
    }

    @Test
    public void calculate_additionWithZeroInDifferentPlace_Ok() {
        double sumOne = calculator.calculator(
                0.0, -0.3, ADDITION);
        double sumTwo = calculator.calculator(
                0.1, 0.0, ADDITION);
        double correctResultOne = -0.3;
        double correctResultTwo = 0.1;

        Assertions.assertEquals(sumOne, correctResultOne);
        Assertions.assertEquals(sumTwo, correctResultTwo);

    }

    @Test
    public void calculate_additionMinAndMaxValues_Ok() {
        double sum = calculator.calculator(
                Double.MIN_VALUE, Double.MAX_VALUE, ADDITION);
        double correctResult = 1.7976931348623157E308;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void calculate_subtractionWithTwoPositiveValues_Ok() {
        double sum = calculator.calculator(
                0.1, 0.1, SUBTRACTION);
        double correctResult = 0.0;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void calculate_subtractionWithTwoNegativeValues_Ok() {
        double sum = calculator.calculator(
                -0.3, -0.3, SUBTRACTION);
        double correctResult = 0.0;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void calculate_subtractionWithPositiveAndNegativeValues_Ok() {
        double sum = calculator.calculator(
                -0.3, 0.1, SUBTRACTION);
        double correctResult = -0.4;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void calculate_subtractionWithZeroInDifferentPlace_Ok() {
        double sumOne = calculator.calculator(
                0.0, -0.3, SUBTRACTION);
        double sumTwo = calculator.calculator(
                0.1, 0.0, SUBTRACTION);
        double correctResultOne = 0.3;
        double correctResultTwo = 0.1;

        Assertions.assertEquals(sumOne, correctResultOne);
        Assertions.assertEquals(sumTwo, correctResultTwo);
    }

    @Test
    public void calculate_subtractionMinAndMaxValues_Ok() {
        double sum = calculator.calculator(
                Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACTION);
        double correctResult = Double.MIN_VALUE - Double.MAX_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void calculate_divisionWithTwoPositiveValues_Ok() {
        double sum = calculator.calculator(
                0.1, 0.1, DIVISION);
        double correctResult = 1;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void calculate_divisionWithTwoNegativeValues_Ok() {
        double sum = calculator.calculator(
                -0.3, -0.3, DIVISION);
        double correctResult = 1;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void calculate_divisionWithPositiveAndNegativeValues_Ok() {
        double sum = calculator.calculator(
                -0.3, 0.1, DIVISION);
        double correctResult = -2.9999999;
        Assertions.assertEquals(correctResult, sum, DELTA);
    }

    @Test
    public void calculate_divisionWithZeroInDifferentPlace_NotOk() {
        double sum = calculator.calculator(
                0.0, -0.3, DIVISION);
        double correctResult = -0.0;

        Assertions.assertEquals(correctResult, sum);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.calculator(
                    0.1, 0.0, DIVISION);
        });

    }

    @Test
    public void calculate_divisionMinAndMaxValues_Ok() {
        double sum = calculator.calculator(
                Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        double correctResult = 1;
        Assertions.assertEquals(correctResult, sum);

        double sumOne = calculator.calculator(Double.MIN_VALUE, Double.MIN_VALUE, DIVISION);
        Assertions.assertEquals(correctResult, sumOne);
    }

    @Test
    public void calculate_multiplicationWithTwoPositiveValues_Ok() {
        double sum = calculator.calculator(
                0.1, 0.1, MULTIPLICATION);
        double correctResult = 0.01;
        Assertions.assertEquals(correctResult, sum, DELTA);
    }

    @Test
    public void calculate_multiplicationWithTwoNegativeValues_Ok() {
        double sum = calculator.calculator(
                -0.3, -0.3, MULTIPLICATION);
        double correctResult = 0.09;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void calculate_multiplicationWithPositiveAndNegativeValues_Ok() {
        double sum = calculator.calculator(
                -0.3, 0.1, MULTIPLICATION);
        double correctResult = -0.03;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void calculate_multiplicationWithZeroInDifferentPlace_Ok() {
        double sumOne = calculator.calculator(
                0.0, -0.3, MULTIPLICATION);
        double sumTwo = calculator.calculator(
                0.1, 0.0, MULTIPLICATION);
        double correctResultOne = -0.0;
        double correctResultTwo = 0.0;

        Assertions.assertEquals(correctResultOne, sumOne);
        Assertions.assertEquals(correctResultTwo, sumTwo);

    }

    @Test
    public void calculate_multiplicationMinAndMaxValues_Ok() {
        double sum = calculator.calculator(
                1000, Double.MAX_VALUE, MULTIPLICATION);
        double correctResult = Double.POSITIVE_INFINITY;
        Assertions.assertEquals(correctResult, sum);

        double sumOne = calculator.calculator(0.1, Double.MIN_VALUE, MULTIPLICATION);
        double correctResultOne = 0.0;
        Assertions.assertEquals(correctResultOne, sumOne);
    }

    @Test
    public void calculate_positiveValueToPositivePower_Ok() {
        double sum = calculator.calculator(
                0.1, 1.3, POWER);
        double correctResult = 0.0501187234;
        Assertions.assertEquals(correctResult, sum, DELTA);
    }

    @Test
    public void calculate_negativeValueToPositivePower_Ok() {
        double sum = calculator.calculator(
                -0.3, 5, POWER);
        double correctResult = -0.00243;
        Assertions.assertEquals(correctResult, sum, DELTA);
    }

    @Test
    public void calculate_positiveValueToNegativePower_Ok() {
        double sum = calculator.calculator(
                0.1, -1.3, POWER);
        double correctResult = 19.9526231;
        Assertions.assertEquals(correctResult, sum, DELTA);
    }

    @Test
    public void calculate_negativeValueToNegativePower_Ok() {
        double sum = calculator.calculator(
                -0.3, -5, POWER);
        double correctResult = -411.522634;
        Assertions.assertEquals(correctResult, sum, DELTA);
    }

    @Test
    public void calculate_positiveValueToZeroPower_Ok() {
        double sum = calculator.calculator(
                0.1, 0.0, POWER);
        double correctResult = 1.0;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void calculate_negativeValueToZeroPower_Ok() {
        double sum = calculator.calculator(
                -0.3, 0.0, POWER);
        double correctResult = Math.pow(-1.3, 0.0);
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void calculate_zeroValueToPower_Ok() {
        double sum = calculator.calculator(
                0.0, 1.3, POWER);
        double correctResult = Math.pow(0.0, 1.3);
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void calculate_illegalOperation_NotOk() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            calculator.calculator(
                    0.1, 1.3, NOT_CORRECT_OPERATOR);
        });
    }
}
