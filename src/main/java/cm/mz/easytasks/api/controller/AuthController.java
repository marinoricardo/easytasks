package cm.mz.easytasks.api.controller;

import cm.mz.easytasks.api.dto.LoginRequest;
import cm.mz.easytasks.api.dto.LoginResponse;
import cm.mz.easytasks.api.dto.RegisterUser;
import cm.mz.easytasks.domain.model.User;
import cm.mz.easytasks.domain.service.AuthService;
import cm.mz.easytasks.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterUser request) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setRole(request.getRole());
        user.setLoginAttempts(0);
        userService.save(user);
        Map<String, String> map = new HashMap<>();
        return ResponseEntity.ok(map);
    }

}
