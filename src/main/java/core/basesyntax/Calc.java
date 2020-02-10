package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Calc {
    private static Map<Character, BinaryOperator<Double>> operations;

    public static void main(String[] args) {
        operations = new HashMap<>();
        operations.put('+', Double::sum);
        operations.put('-', (x, y) -> x - y);
        operations.put('*', (x, y) -> x * y);
        operations.put('/', (x, y) -> x / y);
        operations.put('p', Math::pow);
    }

    public double calculate(Double x, Double y, Character operator) {
        return operations.get(operator).apply(x, y);
    }
}
