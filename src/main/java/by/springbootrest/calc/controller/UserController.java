package by.springbootrest.calc.controller;

import by.springbootrest.calc.dto.TokenDTO;
import by.springbootrest.calc.entity.User;
import by.springbootrest.calc.exception.RegistrationException;
import by.springbootrest.calc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping(path = "/reg")
    public ResponseEntity<User> registration(@RequestBody User user) {
        User regUser = userService.registration(user);

        if (regUser == null) throw new RegistrationException();
        return new ResponseEntity<>(regUser, HttpStatus.CREATED);
    }

    @PostMapping(path = "/auth")
    public ResponseEntity<Integer> authentication(@RequestBody User user) {
        int token;
        User authUser = userService.authentication(user);

        if (authUser == null || userService.getTokens().containsValue(authUser)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        token = new Random().nextInt();
        userService.getTokens().put(token, authUser);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @DeleteMapping(path = "/logout")
    public ResponseEntity logout(@RequestBody TokenDTO tokenDTO) {
        if(!userService.getTokens().containsKey(tokenDTO.getToken())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        userService.getTokens().remove(tokenDTO.getToken());
        return new ResponseEntity(HttpStatus.OK);
    }
}
