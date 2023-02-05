package com.example.vehicule1.service;

import com.example.vehicule1.model.Notifications;
import com.example.vehicule1.repository.NotificationsRepo;
import org.springframework.stereotype.Service;

@Service
public class NotificationsService extends CrudService<Notifications, NotificationsRepo>{
    public NotificationsService(NotificationsRepo repo) {
        super(repo);
    }
}
