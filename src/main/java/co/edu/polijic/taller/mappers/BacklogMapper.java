package co.edu.polijic.taller.mappers;

import co.edu.polijic.taller.model.dto.BacklogDto;
import co.edu.polijic.taller.model.entity.Backlog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BacklogMapper {

    @Mapping(target = "projectId",ignore = true)
    BacklogDto from(Backlog backlog);
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "project",ignore = true)
    @Mapping(target = "projectTasks",ignore = true)
    @Mapping(target = "projectIdentifier",ignore = true)
    Backlog to(BacklogDto backlogDto);
}
