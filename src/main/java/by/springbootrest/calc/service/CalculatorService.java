package by.springbootrest.calc.service;

import by.springbootrest.calc.Calculator;
import by.springbootrest.calc.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

@Component
public class CalculatorService implements ICalculatorService{
    private int historyId = 1;
    private Calculator calculator;
    private Map<Integer, String> history;

    @Autowired
    public CalculatorService(Calculator calculator, Map<Integer, String> history) {
        this.calculator = calculator;
        this.history = history;
    }

    public double calculate(Operation operation) {
        double result = 0;
//        double var1 = Double.parseDouble(operation.getVar1());
//        double var2 = Double.parseDouble(operation.getVar2());
        double var1 = operation.getVar1();
        double var2 = operation.getVar2();

        switch (operation.getOperationType()) {
            case "sum" :
                result = calculator.sum(var1, var2);
                break;
            case "sub":
                result = calculator.sub(var1, var2);
                break;
            case "mult":
                result = calculator.multiple(var1, var2);
                break;
            case "div":
                result = calculator.div(var1, var2);
                break;
        }
        history.put(historyId++,new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss", Locale.ENGLISH).format(new Date()) +
                " : " + var1 + " " + operation.getOperationType() + " " + var2 + " = " + result);
        return result;
    }
}
