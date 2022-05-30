package co.edu.polijic.taller.service;

import co.edu.polijic.taller.mappers.BacklogMapper;
import co.edu.polijic.taller.mappers.ProjectTaskMapper;
import co.edu.polijic.taller.model.constants.StatusTask;
import co.edu.polijic.taller.model.dto.ProjectTaskDto;
import co.edu.polijic.taller.model.entity.ProjectTask;
import co.edu.polijic.taller.persistence.repository.BacklogRepository;
import co.edu.polijic.taller.persistence.repository.ProjectTaskRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectTaskServiceImpl implements ProjectTaskService{

    private final ProjectTaskRepository projectTaskRepository;
    private final BacklogRepository backlogRepository;
    private final ProjectTaskMapper projectTaskMapper = Mappers.getMapper(ProjectTaskMapper.class);

    @Override
    public ProjectTask save(ProjectTask projectTask) {
        return projectTaskRepository.save(projectTask);
    }

    @Override
    public ProjectTask save(ProjectTaskDto projectTaskDto) {
        ProjectTask projectTask = projectTaskMapper.to(projectTaskDto);
        projectTask.setProjectIdentifier(backlogRepository.getById(projectTaskDto.getBacklogId()).getProjectIdentifier());
        projectTask.setBacklog(backlogRepository.getById(projectTaskDto.getBacklogId()));
        return projectTaskRepository.save(projectTask);
    }

    @Override
    public List<ProjectTask> findAll() {
        return projectTaskRepository.findAll();
    }

    @Override
    public List<ProjectTask> findByProjectIdentifier(String projectIdentifier) {
        return projectTaskRepository.findByProjectIdentifier(projectIdentifier);
    }

    @Override
    public Integer totalHoursTasks(String projectIdentifier) {
        return projectTaskRepository.totalHoursTasks(projectIdentifier);
    }

    @Override
    public Integer totalHoursTasksByStatus(String projectIdentifier, StatusTask statusTask) {
        return projectTaskRepository.totalHoursTasksByStatus(projectIdentifier,statusTask);
    }

    @Override
    public ProjectTask deleteTask(Long idTask, String projectIdentifier) {
        ProjectTask projectTask = projectTaskRepository.findByProjectIdentifierAndId(projectIdentifier,idTask);
        projectTask.setStatus(StatusTask.DELETED);
        return projectTaskRepository.save(projectTask);
    }
}
