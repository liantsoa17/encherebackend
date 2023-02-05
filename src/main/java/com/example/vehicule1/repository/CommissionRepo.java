package com.example.vehicule1.repository;

import com.example.vehicule1.model.AdminToken;
import com.example.vehicule1.model.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommissionRepo extends JpaRepository<Commission,Integer> {
    @Query(value = "select * from commision order by pourcentage desc limit 1", nativeQuery = true)
    Commission findCommission();
}
