package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Calculator {
    public static double calculate(double value1, char operator, double value2) {
        if (value2 == 0 && operator == '/') {
            throw new ArithmeticException("Can't divide by zero");
        }

        Map<Character, BinaryOperator<Double>> funcInterfaces = new HashMap<>();
        funcInterfaces.put('+', (v1, v2) -> v1 + v2);
        funcInterfaces.put('-', (v1, v2) -> v1 - v2);
        funcInterfaces.put('*', (v1, v2) -> v1 * v2);
        funcInterfaces.put('/', (v1, v2) -> v1 / v2);
        funcInterfaces.put('^', (v1, v2) -> Math.pow(v1, v2));

        if (!funcInterfaces.containsKey(operator)) {
            throw new IllegalArgumentException("Illegal arithmetical operator: " + operator);
        }
        double result = funcInterfaces.get(operator).apply(value1, value2);
        System.out.printf("%8.3f %c %8.3f = %8.3f", value1, operator, value2, result);
        return result;
    }

    public static void main(String[] args) {
        calculate(1, '+' , 2);
    }
}
