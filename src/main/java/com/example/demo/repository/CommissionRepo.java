package com.example.demo.repository;

import com.example.demo.model.*;


import org.springframework.data.jpa.repository.*;

public interface CommissionRepo extends JpaRepository<Commission,Integer> {
    @Query(value = "select * from commision order by pourcentage desc limit 1", nativeQuery = true)
    Commission findCommission();
}
