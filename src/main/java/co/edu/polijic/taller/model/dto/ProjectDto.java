package co.edu.polijic.taller.model.dto;

import co.edu.polijic.taller.model.entity.Backlog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Builder
@AllArgsConstructor
@ToString
@Data
public class ProjectDto {
    @NotEmpty(message = "No puede estar en blanco")
    private String projectName;
    @Length(min = 5,max = 7)
    @NotEmpty(message = "No puede estar en blanco")
    private String projectIdentifier;
    @NotEmpty(message = "No puede estar en blanco")
    private String description;
    private Date startDate;
    private Date endDate;
}
