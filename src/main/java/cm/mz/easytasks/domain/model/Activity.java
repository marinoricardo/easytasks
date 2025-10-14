package cm.mz.easytasks.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "activities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @JsonProperty("user_id")
    @Column(name = "user_id")
    private String user;
    private String name;
    private String manager;
    @JsonProperty("status_id")
    @Column(name = "status_id")
    private String status;
    private String owner;
    @JsonProperty("start_date")
    @Column(name = "start_date")
    private String startDate;
    @JsonProperty("due_date")
    @Column(name = "due_date")
    private String dueDate;
    @JsonProperty("final_date")
    @Column(name = "final_date")
    private String finalDate;
    @JsonProperty("status_situation")
    @Column(name = "status_situation")
    private String statusSituation;
    private String document;
    private String observation;
    @JsonProperty("tipo_actividade")
    @Column(name = "tipo_actividade")
    private String type;
    @JsonProperty("created_at")
    @Column(name = "created_at")
    private String createdAt;

}
