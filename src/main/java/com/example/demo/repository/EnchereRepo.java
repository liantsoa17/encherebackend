package com.example.demo.repository;

import com.example.demo.model.Enchere;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnchereRepo extends JpaRepository<Enchere,Integer> {
    @Query(value = "select * from Enchere where  date_enchere = :date_enchere and description = :description and idcategorie = :idcategorie and idutilisateur = :id", nativeQuery = true)
    Enchere findbyAll(@Param(value = "date_enchere") Timestamp timestamp,@Param(value = "description") String description,@Param(value = "idcategorie") int idcategorie,@Param(value = "id") int id);
}