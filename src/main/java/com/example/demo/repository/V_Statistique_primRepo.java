package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.V_Statistique_prim;

public interface V_Statistique_primRepo extends JpaRepository<V_Statistique_prim, Integer> {
    @Query(value = "select count(id) id,idcategorie,nom from V_Statistique_prim group by idcategorie,nom", nativeQuery = true)
    List<V_Statistique_prim> findStatistique();
}
