package co.edu.polijic.taller.persistence.repository;

import co.edu.polijic.taller.model.constants.StatusTask;
import co.edu.polijic.taller.model.entity.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask,Long> {

    List<ProjectTask> findByProjectIdentifier(String projectIdentifier);
    ProjectTask findByProjectIdentifierAndId(String projectIdentifier, Long id);

    @Query(value = "SELECT SUM(hours) FROM ProjectTask WHERE projectIdentifier = :projectIdentifier AND status != 'DELETED'")
    Integer totalHoursTasks(@Param("projectIdentifier") String projectIdentifier);

    @Query(value = "SELECT SUM(hours) FROM ProjectTask WHERE projectIdentifier = :projectIdentifier AND status = :status")
    Integer totalHoursTasksByStatus(@Param("projectIdentifier") String projectIdentifier,@Param("status") StatusTask status);
}
