package co.edu.polijic.taller.mappers;

import co.edu.polijic.taller.model.dto.ProjectTaskDto;
import co.edu.polijic.taller.model.dto.ProjectTaskDto.ProjectTaskDtoBuilder;
import co.edu.polijic.taller.model.entity.ProjectTask;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-04T10:52:18-0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
@Component
public class ProjectTaskMapperImpl implements ProjectTaskMapper {

    @Override
    public ProjectTaskDto from(ProjectTask projectTask) {
        if ( projectTask == null ) {
            return null;
        }

        ProjectTaskDtoBuilder projectTaskDto = ProjectTaskDto.builder();

        projectTaskDto.name( projectTask.getName() );
        projectTaskDto.summary( projectTask.getSummary() );
        projectTaskDto.acceptanceCriteria( projectTask.getAcceptanceCriteria() );
        projectTaskDto.status( projectTask.getStatus() );
        projectTaskDto.priority( projectTask.getPriority() );
        projectTaskDto.hours( projectTask.getHours() );
        projectTaskDto.starDate( projectTask.getStarDate() );
        projectTaskDto.endDate( projectTask.getEndDate() );

        return projectTaskDto.build();
    }

    @Override
    public ProjectTask to(ProjectTaskDto projectTaskDto) {
        if ( projectTaskDto == null ) {
            return null;
        }

        ProjectTask projectTask = new ProjectTask();

        projectTask.setName( projectTaskDto.getName() );
        projectTask.setSummary( projectTaskDto.getSummary() );
        projectTask.setAcceptanceCriteria( projectTaskDto.getAcceptanceCriteria() );
        projectTask.setStatus( projectTaskDto.getStatus() );
        projectTask.setPriority( projectTaskDto.getPriority() );
        projectTask.setHours( projectTaskDto.getHours() );
        projectTask.setStarDate( projectTaskDto.getStarDate() );
        projectTask.setEndDate( projectTaskDto.getEndDate() );

        return projectTask;
    }
}
