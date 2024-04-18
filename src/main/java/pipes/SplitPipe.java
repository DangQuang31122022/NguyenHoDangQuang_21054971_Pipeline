package pipes;

import expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class SplitPipe implements Pipe<String, List<Expression>>{
    @Override
    public List<Expression> process(String expression) {
        expression = expression.replace(" - ", " + -");
        String[] elements = expression.split(" \\+ ");
        List<Expression> expressions = new ArrayList<>();
        for (String element : elements) {
            Expression exp = Expression.parseExpression(element);
            expressions.add(exp);
        }
        return expressions;
    }

}
