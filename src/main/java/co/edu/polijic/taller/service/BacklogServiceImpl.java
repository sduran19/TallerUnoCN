package co.edu.polijic.taller.service;

import co.edu.polijic.taller.mappers.BacklogMapper;
import co.edu.polijic.taller.model.dto.BacklogDto;
import co.edu.polijic.taller.model.entity.Backlog;
import co.edu.polijic.taller.persistence.repository.BacklogRepository;
import co.edu.polijic.taller.persistence.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BacklogServiceImpl implements BacklogService{

    private final BacklogRepository backlogRepository;
    private final ProjectRepository projectRepository;
    private final BacklogMapper backlogMapper = Mappers.getMapper(BacklogMapper.class);

    @Override
    public Backlog save(Backlog backlog) {
        return backlogRepository.save(backlog);
    }

    @Override
    public Backlog save(BacklogDto backlogDto) {
        Backlog backlog = backlogMapper.to(backlogDto);
        backlog.setProject(projectRepository.getById(backlogDto.getProjectId()));
        return backlogRepository.save(backlog);
    }

    @Override
    public List<Backlog> findAll() {
        return backlogRepository.findAll();
    }
}
