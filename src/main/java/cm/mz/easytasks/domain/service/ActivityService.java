package cm.mz.easytasks.domain.service;

import cm.mz.easytasks.domain.model.Activity;
import cm.mz.easytasks.domain.repository.ActivityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> findAllIncidents(){
        return activityRepository.findAll();
    }

    public Page<Activity> findAll(Pageable pageable){
        return activityRepository.findAll(pageable);
    }

    public Page<Activity> findByNameContainingIgnoreCase(String name,Pageable pageable){
        return activityRepository.findByNameContainingIgnoreCase(name, pageable);
    }
    public Page<Activity> findByStatusContainingIgnoreCase(String status,Pageable pageable){
        return activityRepository.findByStatusContainingIgnoreCase(status, pageable);
    }
    public Page<Activity> findByStatusAndName(String name,String status,Pageable pageable){
        return activityRepository.findByNameContainingIgnoreCaseAndStatusContainingIgnoreCase(name,status, pageable);
    }
}
