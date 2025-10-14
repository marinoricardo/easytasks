package cm.mz.easytasks.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean active = false;

    @Column(name = "first_login", nullable = false)
    private Boolean firstLogin = false;

    @Column(length = 255)
    private String code;

    @JsonProperty("role_id")
    @Column(name = "role_id")
    private String role;

    @Column(name = "login_attempts", nullable = false)
    private int loginAttempts;

    @Column(name = "remember_token", length = 100)
    private String rememberToken;

    @JsonProperty("created_at")
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
