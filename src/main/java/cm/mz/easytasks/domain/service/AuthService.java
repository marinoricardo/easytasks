package cm.mz.easytasks.domain.service;

import cm.mz.easytasks.api.dto.LoginResponse;
import cm.mz.easytasks.domain.model.User;
import cm.mz.easytasks.domain.repository.UserRepository;
import cm.mz.easytasks.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public LoginResponse login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Senha incorreta");
        }

        String token = jwtUtil.generateToken(user.getId(), user.getEmail());
        LoginResponse response = new LoginResponse();
        response.setUser(user);
        response.setToken(token);
        response.setExpiresIn(jwtUtil.getExpiration());
        return response;
    }

}
