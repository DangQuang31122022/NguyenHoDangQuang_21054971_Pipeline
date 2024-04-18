//import expression.DerivativeFilter;
import expression.Expression;
import pipes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tạo pipeline
        Pipe<String, List<Expression>> splitPipe = new SplitPipe(); // tách chuỗi thành biểu thức
        Pipe<List<Expression>, List<Expression>> derivativePipe = new DerivativePipe(); // tính đạo hàm
        Pipe<List<Expression>, List<Double>> evaluatePipe = new EvaluatePipe(2.0); // giả sử x = 2.0

        Pipe<String, List<Double>> pipeline = splitPipe.add(derivativePipe).add(evaluatePipe);

        // Sử dụng pipeline
        String expression = "2x^3 + 3x^2 - 5x + 7"; // giả sử biểu thức là "2x^3 + 3x^2 - 5x + 7"
        List<Double> results = pipeline.process(expression);

        // In kết quả
        Double sum = 0.0;
        for (Double result : results) {
            System.out.println(result);
            // tổng
            sum += result;
        }
        System.out.println("Sum: " + sum);
    }
}
