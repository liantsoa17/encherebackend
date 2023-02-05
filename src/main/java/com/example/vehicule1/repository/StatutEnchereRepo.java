package com.example.vehicule1.repository;


import com.example.vehicule1.model.StatutEnchere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutEnchereRepo extends JpaRepository<StatutEnchere,Integer> {
}
