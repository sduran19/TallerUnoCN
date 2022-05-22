package co.edu.polijic.taller.service;

import co.edu.polijic.taller.model.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    Project save(Project project);

    List<Project> findAll();
}
