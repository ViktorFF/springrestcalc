package by.springbootrest.calc.config;

import by.springbootrest.calc.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class AppConfig {

    @Bean
    public Map<Integer, User> getTokens() {
        return new HashMap<>();
    }

    @Bean
    public Map<Integer, String> getHistory() {
        return new LinkedHashMap<>();
    }

    @Bean
    public Map<String, User> getLoginUser() {
        return new LinkedHashMap<>();
    }

    @Bean
    public Map<String, User> getIdUser() {
        return new LinkedHashMap<>();
    }
}
