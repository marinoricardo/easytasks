package cm.mz.easytasks.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Meta{
    private long total;
    private int page;
    @JsonProperty("per_page")
    private int perPage;
    @JsonProperty("last_page")
    private int lastPage;
}
