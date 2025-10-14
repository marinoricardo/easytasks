package cm.mz.easytasks.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterUser {
    private String name;
    private String email;
    private String password;
    @JsonProperty("role_id")
    private String role;
}
