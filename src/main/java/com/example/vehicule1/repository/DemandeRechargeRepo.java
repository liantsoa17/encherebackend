package com.example.vehicule1.repository;

import com.example.vehicule1.model.AdminToken;
import com.example.vehicule1.model.DemandeRecharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DemandeRechargeRepo extends JpaRepository<DemandeRecharge,Integer> {
    @Query(value = "select * from demanderecharge where etat = 0", nativeQuery = true)
    List<DemandeRecharge> findwhereEtat();
}
