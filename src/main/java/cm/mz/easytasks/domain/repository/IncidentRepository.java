package cm.mz.easytasks.domain.repository;

import cm.mz.easytasks.domain.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Integer> {
    List<Incident> findTop8ByOrderByStartDesc();
    List<Incident> findTop8ByOrderByCreatedAtDesc();


}
