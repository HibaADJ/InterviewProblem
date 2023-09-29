import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MathFunctionCalculator {

    private final Map<String, BiFunction<Integer, Integer, Integer>> possibleOperations;
    private String outputResult = "";

    public MathFunctionCalculator() {
        possibleOperations = new HashMap<>();
        possibleOperations.put("-", (a, b) -> a - b);
        possibleOperations.put("*", (a, b) -> a * b);
        possibleOperations.put("/", (a, b) -> a / b);
        possibleOperations.put("+", (a, b) -> a + b);
    }

    public String mathFunction(int Number1, int Number2, int Number3) {

        for (Map.Entry<String, BiFunction<Integer, Integer, Integer>> entry : possibleOperations.entrySet()) {
            if (entry.getValue().apply(Number1, Number2) == Number3) {
                outputResult = outputResult.concat(entry.getKey());
            }
        }

        return outputResult == "" ? "None" : outputResult;
    }

    public static void main(String[] args) {
        // Test cases
        MathFunctionCalculator test1 = new MathFunctionCalculator();
        System.out.println(test1.mathFunction(1, 2, 3));
        MathFunctionCalculator test2 = new MathFunctionCalculator();
        System.out.println(test2.mathFunction(2, 2, 4));
        MathFunctionCalculator test3 = new MathFunctionCalculator();
        System.out.println(test3.mathFunction(3, -3, -9));
        MathFunctionCalculator test4 = new MathFunctionCalculator();
        System.out.println(test4.mathFunction(1, 2, -1));
        MathFunctionCalculator test5 = new MathFunctionCalculator();
        System.out.println(test5.mathFunction(3, 3, 1));
        MathFunctionCalculator test6 = new MathFunctionCalculator();
        System.out.println(test6.mathFunction(7, 1, 11));

    }
}
