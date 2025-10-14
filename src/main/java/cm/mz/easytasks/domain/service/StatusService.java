package cm.mz.easytasks.domain.service;

import cm.mz.easytasks.domain.model.Status;
import cm.mz.easytasks.domain.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> findAll() {
        return statusRepository.findAll();
    }
}
