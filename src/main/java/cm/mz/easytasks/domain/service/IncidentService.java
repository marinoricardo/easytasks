package cm.mz.easytasks.domain.service;

import cm.mz.easytasks.domain.model.Incident;
import cm.mz.easytasks.domain.repository.IncidentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidentService {
    private final IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    public List<Incident> findAllByUserId(Long userId) {
        return new ArrayList<>();
    }

    public List<Incident> findAll(){
        return incidentRepository.findTop8ByOrderByCreatedAtDesc();
    }
}
