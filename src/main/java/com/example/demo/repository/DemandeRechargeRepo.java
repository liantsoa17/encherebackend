package com.example.demo.repository;

import com.example.demo.model.DemandeRecharge;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DemandeRechargeRepo extends JpaRepository<DemandeRecharge,Integer> {
    @Query(value = "select * from demanderecharge where etat = 0", nativeQuery = true)
    List<DemandeRecharge> findwhereEtat();

}
