package by.springbootrest.calc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public Map<Integer, String> getHistory() {
        return new LinkedHashMap<>();
    }
}
