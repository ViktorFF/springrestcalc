package by.springbootrest.calc.dto;

import by.springbootrest.calc.entity.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorDTO {
    private Integer token;
    private Operation operation;
}
