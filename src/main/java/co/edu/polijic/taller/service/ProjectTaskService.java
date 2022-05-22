package co.edu.polijic.taller.service;

import co.edu.polijic.taller.model.constants.StatusTask;
import co.edu.polijic.taller.model.dto.ProjectTaskDto;
import co.edu.polijic.taller.model.entity.ProjectTask;

import java.util.List;

public interface ProjectTaskService {

    ProjectTask save(ProjectTask projectTask);
    ProjectTask save(ProjectTaskDto projectTaskDto);

    List<ProjectTask> findAll();
    List<ProjectTask> findByProjectIdentifier(String projectIdentifier);
    Integer totalHoursTasks(String projectIdentifier);
    Integer totalHoursTasksByStatus(String projectIdentifier, StatusTask statusTask);
    ProjectTask deleteTask(Long idTask, String projectIdentifier);
}
