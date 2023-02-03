package com.example.demo.service;

import com.example.demo.model.Notifications;
import com.example.demo.repository.NotificationsRepo;
import org.springframework.stereotype.Service;

@Service
public class NotificationsService extends CrudService<Notifications, NotificationsRepo>{
    public NotificationsService(NotificationsRepo repo) {
        super(repo);
    }
}
