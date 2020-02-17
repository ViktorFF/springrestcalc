package by.springbootrest.calc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @JsonIgnore
    private static long icrId = 1;
    private String id = String.valueOf(icrId++);
    private String nickname;
    private String login;
    private String password;
}
