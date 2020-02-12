package by.springbootrest.calc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private static long icrId = 1;
    private long id = icrId++;
    private String nickname;
    private String login;
    private String password;
}
