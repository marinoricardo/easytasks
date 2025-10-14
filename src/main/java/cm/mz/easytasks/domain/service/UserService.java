package cm.mz.easytasks.domain.service;

import cm.mz.easytasks.domain.model.User;
import cm.mz.easytasks.domain.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Page<User> findAllWithPagination(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User findById(String id) {
        return this.userRepository.getUserById(id).orElseThrow();
    }


    public void  save(User user) {
        userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
