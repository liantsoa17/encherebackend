package com.example.vehicule1.repository;

import com.example.vehicule1.model.AdminToken;
import com.example.vehicule1.model.NomMvt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NomMvtRepo extends JpaRepository<NomMvt,Integer> {
}
