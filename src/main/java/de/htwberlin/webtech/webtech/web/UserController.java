package de.htwberlin.webtech.webtech.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import de.htwberlin.webtech.webtech.persistence.UserEntity;
import de.htwberlin.webtech.webtech.service.UserService;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/v1/register")
    public ResponseEntity<UserEntity> register(@RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/api/v1/login")
    public ResponseEntity<UserEntity> login(@RequestBody UserEntity user) {
        UserEntity loggedInUser = userService.login(user.getEmail(), user.getPassword());
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        }
        return ResponseEntity.status(401).build();  // Unauthorized
    }
}
