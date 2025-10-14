package cm.mz.easytasks.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiResponse <T> {
    private Meta meta;
    private T data;
}

