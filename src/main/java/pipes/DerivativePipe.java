package pipes;

import expression.Expression;

import java.util.List;
import java.util.stream.Collectors;

public class DerivativePipe implements Pipe<List<Expression>, List<Expression>> {
    @Override
    public List<Expression> process(List<Expression> expressions) {
        return expressions.stream()
                .map(expression -> {
                    int newBase = expression.getBase() * expression.getExponent();
                    int newExponent = expression.getExponent() - 1;
                    return new Expression(newBase, newExponent);
                })
                .collect(Collectors.toList());
    }
}
