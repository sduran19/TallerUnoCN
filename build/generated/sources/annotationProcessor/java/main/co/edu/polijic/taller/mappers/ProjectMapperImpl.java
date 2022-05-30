package co.edu.polijic.taller.mappers;

import co.edu.polijic.taller.model.dto.ProjectDto;
import co.edu.polijic.taller.model.dto.ProjectDto.ProjectDtoBuilder;
import co.edu.polijic.taller.model.entity.Project;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-30T14:08:10-0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectDto from(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDtoBuilder projectDto = ProjectDto.builder();

        projectDto.projectName( project.getProjectName() );
        projectDto.projectIdentifier( project.getProjectIdentifier() );
        projectDto.description( project.getDescription() );
        projectDto.startDate( project.getStartDate() );
        projectDto.endDate( project.getEndDate() );

        return projectDto.build();
    }

    @Override
    public Project to(ProjectDto projectDto) {
        if ( projectDto == null ) {
            return null;
        }

        Project project = new Project();

        project.setProjectName( projectDto.getProjectName() );
        project.setProjectIdentifier( projectDto.getProjectIdentifier() );
        project.setDescription( projectDto.getDescription() );
        project.setStartDate( projectDto.getStartDate() );
        project.setEndDate( projectDto.getEndDate() );

        return project;
    }
}
