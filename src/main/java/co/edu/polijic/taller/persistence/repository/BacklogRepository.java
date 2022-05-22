package co.edu.polijic.taller.persistence.repository;

import co.edu.polijic.taller.model.entity.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog,Long>{
}
