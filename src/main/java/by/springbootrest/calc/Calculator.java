package by.springbootrest.calc;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public double sum(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double multiple(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        if (b != 0) {
            return a / b;
        }
        return 0;
    }
}
