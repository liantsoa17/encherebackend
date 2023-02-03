package com.example.demo.repository;

import com.example.demo.model.Mouvement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MouvementRepo extends JpaRepository<Mouvement,Integer> {
}
