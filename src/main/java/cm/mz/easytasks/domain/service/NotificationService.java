package cm.mz.easytasks.domain.service;


import cm.mz.easytasks.domain.model.Notification;
import cm.mz.easytasks.domain.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> findAll(){
        return notificationRepository.findAll();
    }
}
