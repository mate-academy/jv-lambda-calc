package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static Calculator calculator = new Calculator();
    private static double firstVariable = 10;
    private static double secondVariable = 5;

    @Test
    void additionWithNegativeValues_Ok() {
        double expectedResult = -15;
        double actualResult = calculator.calculate(-firstVariable, -secondVariable,'+');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void additionWithPositiveAndNegativeValues_Ok() {
        double expectedResult = -5;
        double actualResult = calculator.calculate(-firstVariable, secondVariable,'+');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void additionWithZero_Ok() {
        double expectedResult = 5;
        double actualResult = calculator.calculate(0, secondVariable,'+');
        assertEquals(expectedResult, actualResult);
        expectedResult = 10;
        actualResult = calculator.calculate(firstVariable, 0,'+');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void additionWithMaxValue_NotOk() {
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(firstVariable, Double.MAX_VALUE,'+'));
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(Double.MAX_VALUE, secondVariable,'+'));
    }

    @Test
    void subtractionWithMinValue_NotOk() {
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(firstVariable, Double.MIN_VALUE,'-'));
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(Double.MIN_VALUE, secondVariable,'-'));
    }

    @Test
    void divisionWithMinValue_NotOk() {
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(firstVariable, Double.MIN_VALUE,'/'));
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(Double.MIN_VALUE, secondVariable,'/'));
    }

    @Test
    void multiplyWithMaxValue_NotOk() {
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(firstVariable, Double.MAX_VALUE,'*'));
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(Double.MAX_VALUE, secondVariable,'*'));
    }

    @Test
    void raisingToAPowerWithMaxValue_NotOk() {
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(firstVariable, Double.MAX_VALUE,'^'));
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(Double.MAX_VALUE, secondVariable,'^'));
    }

    @Test
    void raisingZeroToAPower_Ok() {
        double expectedResult = 1;
        double actualResult = calculator.calculate(firstVariable, 0,'^');
        assertEquals(expectedResult, actualResult);
        expectedResult = 0;
        actualResult = calculator.calculate(0, secondVariable,'^');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void raisingToAPowerWithNegativeValues_NotOk() {
        double expectedResult = -100000.0;
        double actualResult = calculator.calculate(-firstVariable, secondVariable,'^');
        assertEquals(expectedResult, actualResult);
        expectedResult = 1.0E-5;
        actualResult = calculator.calculate(firstVariable, -secondVariable,'^');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void correctAddition_Ok() {
        double expectedResult = 15;
        double actualResult = calculator.calculate(firstVariable, secondVariable,'+');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void correctSubtraction_Ok() {
        double expectedResult = 5;
        double actualResult = calculator.calculate(firstVariable, secondVariable,'-');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void correctDivision_Ok() {
        double expectedResult = 2;
        double actualResult = calculator.calculate(firstVariable, secondVariable,'/');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void correctMultiplication_Ok() {
        double expectedResult = 50;
        double actualResult = calculator.calculate(firstVariable, secondVariable,'*');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void correctRaisingToAPower_Ok() {
        double expectedResult = 100000;
        double actualResult = calculator.calculate(firstVariable, secondVariable,'^');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void correctOperation_NotOk() {
        assertThrows(NotValidOperationException.class, ()
                -> calculator.calculate(firstVariable, secondVariable,'d'));
    }

    @Test
    void zeroDivision_NotOk() {
        assertThrows(ArithmeticException.class, () ->
            calculator.calculate(firstVariable, 0,'/'));
    }
}
