public class Calculator {
    public static String[] calc(int num, int result, int maxOp) {
        int totalCombinations = calculateTotalCombinations(num, maxOp);
        String[] expressions = new String[totalCombinations];
        calculate(num, result, maxOp, "", expressions, 0);
        return expressions;
    }

    private static int calculateTotalCombinations(int num, int maxOp) {
        if (maxOp == 0) {
            return 1;
        }
        return 4 * calculateTotalCombinations(num, maxOp - 1);
    }

    private static int calculate(int num, int target, int remainingOps, String expression, String[] expressions, int index) {
        if (target == num && remainingOps == 0) {
            expressions[index++] = expression;
            return index;
        }

        if (remainingOps > 0) {
            index = calculate(num, target - num, remainingOps - 1, expression + "*" + num, expressions, index);
            index = calculate(num, target - num, remainingOps - 1, expression + "+" + num, expressions, index);
            index = calculate(num, num - target, remainingOps - 1, expression + "-" + num, expressions, index);
            if (target % num == 0) {
                index = calculate(num, target / num, remainingOps - 1, expression + "/" + num, expressions, index);
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int num = 3;
        int result = 36;
        int maxOp = 4;

        String[] expressions = calc(num, result, maxOp);
        for (String expr : expressions) {
            if (expr != null) {
                System.out.println(expr);
            }
        }
    }
}