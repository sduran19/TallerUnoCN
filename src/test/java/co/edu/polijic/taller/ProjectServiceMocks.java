package co.edu.polijic.taller;

import co.edu.polijic.taller.model.entity.Project;
import co.edu.polijic.taller.persistence.repository.ProjectRepository;
import co.edu.polijic.taller.service.ProjectService;
import co.edu.polijic.taller.service.ProjectServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProjectServiceMocks {

    @Mock
    private ProjectRepository projectRepository;
    private ProjectService projectService;

    @BeforeEach
    public void begin() {
        MockitoAnnotations.openMocks(this);
        projectService = new ProjectServiceImpl(projectRepository);

        Project project = Project.builder()
                .id(5L)
                .projectName("Test2")
                .projectIdentifier("CODE002")
                .description("TEST002").build();
        Mockito.when(projectRepository.findById(5L))
                .thenReturn(Optional.of(project));
    }

    @Test
    public void when_findById_return_project(){
        Optional<Project> project = projectService.findById(5L);
        Assertions.assertThat(project.get().getProjectIdentifier()).isEqualTo("CODE002");
    }
}
