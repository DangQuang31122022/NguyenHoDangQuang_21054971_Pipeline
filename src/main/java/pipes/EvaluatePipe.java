package pipes;

import expression.Expression;

import java.util.List;
import java.util.stream.Collectors;

public class EvaluatePipe implements Pipe<List<Expression>, List<Double>> {
    private final double x;

    public EvaluatePipe(double x) {
        this.x = x;
    }

    @Override
    public List<Double> process(List<Expression> expressions) {
        return expressions.stream()
                .map(expression -> expression.evaluate(x))
                .collect(Collectors.toList());
    }
}
