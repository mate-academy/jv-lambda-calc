package core.basesyntax;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;

public class CalculatorImpl {

    private static final HashMap<Character, DoubleBinaryOperator> calculator;

    static {
        calculator = new HashMap<>();
        calculator.put('+', Double::sum);
        calculator.put('-', (a, b) -> a - b);
        calculator.put('*', (a, b) -> a * b);
        calculator.put('/', (a, b) -> a / b);
        calculator.put('^', Math::pow);
    }

    public double executor(Double a, Character operation, Double b) {
        if ((operation == '/' && b == 0) || (operation == '^' && a == 0 && b < 0)) {
            throw new IllegalArgumentException("Wrong operation!");
        }
        return calculator.get(operation).applyAsDouble(a, b);
    }
}
