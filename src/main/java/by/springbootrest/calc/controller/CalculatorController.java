package by.springbootrest.calc.controller;

import by.springbootrest.calc.dto.CalculatorDTO;
import by.springbootrest.calc.service.CalculatorService;
import by.springbootrest.calc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/calc")
public class CalculatorController {
    private CalculatorService calcService;
    private UserService userService;

    @Autowired
    public CalculatorController(CalculatorService calcService, UserService userService) {
        this.calcService = calcService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Double> calculate(@RequestBody CalculatorDTO calculatorDTO) {
        if(!userService.getTokens().containsKey(calculatorDTO.getToken())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(calcService.calculate(calculatorDTO.getOperation()), HttpStatus.OK);
    }
}
