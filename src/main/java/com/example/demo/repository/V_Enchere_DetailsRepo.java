package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.*;
public interface V_Enchere_DetailsRepo extends JpaRepository<V_Enchere_Details,Integer> {
    @Query(value = " select * from Enchere_Details where  idutilisateur = :idutilisateur", nativeQuery = true)
    List<V_Enchere_Details> findbyAll(@Param(value = "idutilisateur") int idutilisateur);
}
