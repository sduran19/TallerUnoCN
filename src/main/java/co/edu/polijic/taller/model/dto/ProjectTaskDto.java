package co.edu.polijic.taller.model.dto;

import co.edu.polijic.taller.model.constants.StatusTask;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Date;

@Builder
@AllArgsConstructor
@ToString
@Data
public class ProjectTaskDto {
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
    //private String projectIdentifier;
    private Long backlogId;
}
