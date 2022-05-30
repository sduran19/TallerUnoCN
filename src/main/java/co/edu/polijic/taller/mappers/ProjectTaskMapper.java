package co.edu.polijic.taller.mappers;

import co.edu.polijic.taller.model.dto.ProjectTaskDto;
import co.edu.polijic.taller.model.entity.ProjectTask;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectTaskMapper {

    @Mapping(target = "backlogId",ignore = true)
    ProjectTaskDto from(ProjectTask projectTask);
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "backlog",ignore = true)
    @Mapping(target = "projectIdentifier",ignore = true)
    ProjectTask to(ProjectTaskDto projectTaskDto);
}
