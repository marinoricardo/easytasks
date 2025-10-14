package cm.mz.easytasks.domain.repository;

import cm.mz.easytasks.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> getUserById(String id);
    Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
