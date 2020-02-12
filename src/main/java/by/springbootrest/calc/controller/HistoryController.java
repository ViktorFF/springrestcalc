package by.springbootrest.calc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/history")
public class HistoryController {
    private Map<Integer, String> history;

    @Autowired
    public HistoryController(Map<Integer, String> history) {
        this.history = history;
    }

    @GetMapping
    public Map<Integer, String> getHistory() {
        return history;
    }
}
