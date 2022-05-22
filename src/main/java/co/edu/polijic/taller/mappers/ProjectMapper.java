package co.edu.polijic.taller.mappers;

import co.edu.polijic.taller.model.dto.ProjectDto;
import co.edu.polijic.taller.model.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    //@Mapping(target = "backlogId",ignore = true)
    ProjectDto from(Project project);
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "backlog",ignore = true)
    Project to(ProjectDto projectDto);
}
