/**
 * BuggyCalculator.java
 *
 * PURPOSE FOR TASK 4:
 * This file contains intentional code review issues so you can test an AI
 * reviewer (e.g. CodeRabbit) on a real PR. After the AI reviews it, note:
 *   - What did it catch?
 *   - What did it miss?
 *   - What was noise (unnecessary or wrong comments)?
 *
 * INTENTIONAL ISSUES PLANTED IN THIS FILE:
 *   1. Division by zero — divide() does not check for a zero divisor
 *   2. Poor variable naming — single-letter variables with no context
 *   3. Missing null check — processInput() will throw NullPointerException
 *   4. Magic numbers — hardcoded 100 and 0.15 with no explanation
 *   5. Swallowed exception — catch block does nothing (silent failure)
 *   6. Wrong comparison — uses == to compare String objects
 *   7. No unit tests — the class has no test coverage at all
 *
 * A good reviewer (human or AI) should flag most of these.
 */
public class BuggyCalculator {

    // ------------------------------------------------------------------ //
    //  Issue 4: magic numbers — what does 100 mean? what is 0.15?
    // ------------------------------------------------------------------ //
    private static final double x = 100;
    private static final double y = 0.15;

    /**
     * Adds two numbers.
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts b from a.
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides a by b.
     *
     * Issue 1: No check for b == 0. If the caller passes 0, this throws
     * ArithmeticException for integers, or silently returns Infinity for
     * doubles — both are bugs in a calculator context.
     */
    public double divide(double a, double b) {
        return a / b; // BUG: should check b != 0 before dividing
    }

    /**
     * Applies a discount to a price.
     *
     * Issue 4 (again): the discount rate is the magic constant y (0.15),
     * and the "max price" is the magic constant x (100). Neither is
     * documented or named meaningfully.
     */
    public double applyDiscount(double price) {
        if (price > x) {
            return price - (price * y);
        }
        return price;
    }

    /**
     * Processes a string input and returns a numeric result.
     *
     * Issue 3: If input is null, input.trim() throws NullPointerException.
     * Issue 5: The catch block is completely empty — if parsing fails,
     *          the method silently returns 0.0 with no warning to the caller.
     */
    public double processInput(String input) {
        String trimmed = input.trim(); // BUG: no null check on input
        try {
            return Double.parseDouble(trimmed);
        } catch (NumberFormatException e) {
            // BUG: exception is swallowed — caller never knows parsing failed
        }
        return 0.0;
    }

    /**
     * Checks whether the calculator is in "tax mode."
     *
     * Issue 2: variable named 'm' — completely opaque.
     * Issue 6: String comparison with == instead of .equals().
     *          In Java, == checks reference equality, not value equality.
     *          This will return false even when the strings look identical.
     */
    public boolean isTaxMode(String mode) {
        String m = mode; // BUG: poor naming, just use 'mode' directly
        return m == "TAX"; // BUG: should be m.equals("TAX")
    }

    /**
     * Computes compound interest.
     *
     * Issue 4: rate, periods — all magic numbers passed in with no
     * validation. Negative rate or zero periods are not handled.
     */
    public double compoundInterest(double principal, double rate, int periods) {
        // No validation: what if rate is negative? what if periods is 0?
        double r = rate;
        int n = periods;
        return principal * Math.pow(1 + r, n);
    }

    public static void main(String[] args) {
        BuggyCalculator calc = new BuggyCalculator();

        // This will NOT throw for doubles — it silently returns Infinity.
        // A reviewer should flag that this is misleading behaviour.
        System.out.println("10 / 0 = " + calc.divide(10, 0));

        // This will throw NullPointerException at runtime.
        // System.out.println(calc.processInput(null));

        // This will always print false due to the == bug.
        System.out.println("TAX mode? " + calc.isTaxMode("TAX"));
    }
}
