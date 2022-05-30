package co.edu.polijic.taller.model.dto;

import co.edu.polijic.taller.model.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Builder
@AllArgsConstructor
@ToString
@Data
public class BacklogDto {
    //@NotEmpty(message = "No puede estar en blanco")
    //private String projectIdentifier;
    private Long projectId;

    public BacklogDto() {
    }
}
