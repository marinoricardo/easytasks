package cm.mz.easytasks.api.dto;

import cm.mz.easytasks.domain.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponse {
    @JsonProperty("access_token")
    private String token;
    @JsonProperty("token_type")
    private String tokenType = "Bearer";
    @JsonProperty("expires_in")
    private long expiresIn;
    private User user;
}
