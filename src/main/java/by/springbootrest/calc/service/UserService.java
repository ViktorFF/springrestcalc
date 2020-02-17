package by.springbootrest.calc.service;

import by.springbootrest.calc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserService implements IUserService{
    private Map<String, User> loginUsers;   // <Login, User>
    private Map<String, User> idUsers;      // <Id, User>
    private Map<Integer, User> tokens;      // <Token, User>

    @Autowired
    public UserService(@Qualifier(value = "getLoginUser") Map<String, User> loginUsers,
                       @Qualifier(value = "getIdUser") Map<String, User> idUsers,
                       Map<Integer, User> tokens) {
        this.loginUsers = loginUsers;
        this.idUsers = idUsers;
        this.tokens = tokens;
    }

    public Map<Integer, User> getTokens() {
        return tokens;
    }

    public User registration(User newUser) {
        if (!loginUsers.isEmpty()) {
            for (String key: loginUsers.keySet()) {
                if (key.equals(newUser.getLogin())) {
                    return null;
                }
            }
        }
        loginUsers.put(newUser.getLogin(), newUser);
        idUsers.put(newUser.getId(), newUser);
        return newUser;
    }

    public User authentication(User newUser) {
        String login = newUser.getLogin();
        String password = newUser.getPassword();
        if (loginUsers.isEmpty()) {
            return null;
        }
        if (loginUsers.containsKey(login)) {
            if (loginUsers.get(login).getPassword().equals(password))
                return loginUsers.get(login);
        }
        return null;
    }

    public String oldValue(String field, User user){
        switch (field) {
            case "nickname":
                return user.getNickname();
            case "login":
                return user.getLogin();
            case "password":
                return user.getPassword();
        }
        return "";
    }

    public void setNewValue(String field, String newValue, User user) {
        switch (field) {
            case "nickname":
                user.setNickname(newValue);
                break;
            case "login":
                user.setLogin(newValue);
                break;
            case "password":
                user.setPassword(newValue);
                break;
        }
    }
}
