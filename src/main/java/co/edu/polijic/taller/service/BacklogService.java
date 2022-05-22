package co.edu.polijic.taller.service;

import co.edu.polijic.taller.model.dto.BacklogDto;
import co.edu.polijic.taller.model.entity.Backlog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BacklogService {

    Backlog save(Backlog backlog);
    Backlog save(BacklogDto backlogDto);
    List<Backlog> findAll();
}
