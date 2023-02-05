package com.example.vehicule1.repository;

import com.example.vehicule1.model.AdminToken;
import com.example.vehicule1.model.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationsRepo extends JpaRepository<Notifications,Integer> {
}
