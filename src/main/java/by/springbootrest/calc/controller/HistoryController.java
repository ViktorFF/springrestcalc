package by.springbootrest.calc.controller;

import by.springbootrest.calc.dto.TokenDTO;
import by.springbootrest.calc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/history")
public class HistoryController {
    private Map<Integer, String> history;
    private UserService userService;

    @Autowired
    public HistoryController(Map<Integer, String> history, UserService userService) {
        this.history = history;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Map<Integer, String>> getHistory(@RequestBody TokenDTO tokenDTO) {
        if(!userService.getTokens().containsKey(tokenDTO.getToken())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(history, HttpStatus.OK);
    }
}
