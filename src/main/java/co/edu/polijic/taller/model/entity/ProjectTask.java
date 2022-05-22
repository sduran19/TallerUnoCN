package co.edu.polijic.taller.model.entity;

import co.edu.polijic.taller.model.constants.StatusTask;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyect_tasks")
public class ProjectTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "No puede estar en blanco")
    private String name;
    @NotEmpty(message = "No puede estar en blanco")
    private String summary;
    private String acceptanceCriteria;
    @Enumerated(EnumType.STRING)
    private StatusTask status;
    @Min(1)
    @Max(5)
    private int priority;
    @Min(1)
    @Max(8)
    @Positive
    private Double hours;
    private Date starDate;
    private Date endDate;
    @Column(name = "project_identifier",updatable = false)
    private String projectIdentifier;
    @ManyToOne(fetch=FetchType.EAGER , cascade=CascadeType.ALL)
    @JoinColumn(name = "backlogs_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","projectTasks"},ignoreUnknown = true)
    private Backlog backlog;

}
