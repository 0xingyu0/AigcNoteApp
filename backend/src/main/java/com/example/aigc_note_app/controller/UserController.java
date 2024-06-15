package main.java.com.example.aigc_note_app.controller;

import main.java.com.example.aigc_note_app.model.User;
import main.java.com.example.aigc_note_app.service.JwtUtil;
import main.java.com.example.aigc_note_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        UserDetails userDetails = userService.authenticateUser(loginRequest);
        String token = jwtUtil.generateToken(userDetails.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
