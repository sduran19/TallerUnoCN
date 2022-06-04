package co.edu.polijic.taller;

import co.edu.polijic.taller.model.entity.Project;
import co.edu.polijic.taller.persistence.repository.ProjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ProjectRepositoryMockTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test void when_findAll_return_ListProject(){
        Project project = Project.builder()
                .projectName("Test")
                .projectIdentifier("CODE001")
                .description("TEST001").build();

        projectRepository.save(project);
        List<Project> projects = projectRepository.findAll();
        Assertions.assertThat(projects.size()).isEqualTo(1);

    }
}
