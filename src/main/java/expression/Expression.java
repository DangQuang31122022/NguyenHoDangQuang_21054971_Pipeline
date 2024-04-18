package expression;

import java.util.function.Function;

public class Expression {
    private int base;
    private int exponent;

    public Expression(int base, int exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    // Convert a string element to an Expression object
    public static Expression parseExpression(String element) {
        int base;
        int exponent;

        if (element.contains("x")) {
            String[] parts = element.split("x");
            base = Integer.parseInt(parts[0].trim());

            if (parts.length > 1 && parts[1].contains("^")) {
                exponent = Integer.parseInt(parts[1].split("\\^")[1].trim());
            } else {
                exponent = 1; // default value if no exponent is present
            }
        } else {
            base = Integer.parseInt(element.trim());
            exponent = 0; // default value for constants
        }

        return new Expression(base, exponent);
    }
    // Evaluate the expression at a given value of x
    public double evaluate(double x) {
        return base * Math.pow(x, exponent);
    }
}
