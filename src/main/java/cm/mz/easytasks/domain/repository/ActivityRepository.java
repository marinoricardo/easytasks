package cm.mz.easytasks.domain.repository;

import cm.mz.easytasks.domain.model.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Page<Activity> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Activity> findByStatusContainingIgnoreCase(String status, Pageable pageable);
    Page<Activity> findByNameContainingIgnoreCaseAndStatusContainingIgnoreCase(
            String name, String status, Pageable pageable);


}
