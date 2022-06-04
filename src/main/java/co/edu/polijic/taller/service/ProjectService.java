package co.edu.polijic.taller.service;

import co.edu.polijic.taller.model.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProjectService {

    Project save(Project project);

    List<Project> findAll();

    Optional<Project> findById(Long id);
}
