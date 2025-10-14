package cm.mz.easytasks.infrastructure.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.UUID;
import java.security.Key;

@Component
public class JwtUtil {

    private final String SECRET = "SUA_CHAVE_SECRETA_SUPER_SEGURA_QUE_DEVE_SER_GRANDE";
    private final long EXPIRATION = 1000 * 60 * 60 * 10; // 10 horas

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String userId, String email) {
        return Jwts.builder()
                .setSubject(email)
                .setId(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key)
                .compact();
    }

    public long getExpiration() {
        return EXPIRATION;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public String getEmailFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}