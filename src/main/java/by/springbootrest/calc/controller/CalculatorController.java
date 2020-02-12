package by.springbootrest.calc.controller;

import by.springbootrest.calc.entity.Operation;
import by.springbootrest.calc.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calc")
public class CalculatorController {
    private CalculatorService calcService;

    @Autowired
    public CalculatorController(CalculatorService calcService) {
        this.calcService = calcService;
    }

    @PostMapping
    public double calculate(@RequestParam("var1") Double var1,
                            @RequestParam("var2") Double var2,
                            @RequestParam("operationType") String operationType) {

        return calcService.calculate(new Operation(var1, var2, operationType));
    }
}
