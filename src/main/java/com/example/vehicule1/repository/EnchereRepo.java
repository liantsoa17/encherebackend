package com.example.vehicule1.repository;

import com.example.vehicule1.model.AdminToken;
import com.example.vehicule1.model.Enchere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface EnchereRepo extends JpaRepository<Enchere,Integer> {
    List<Enchere> findAllById(Integer id);
    List<Enchere> findAllByIdUtilisateur(Integer id);
    @Query(value = "select * from Enchere where  date_enchere = :date_enchere and description = :description and idcategorie = :idcategorie and idutilisateur = :id", nativeQuery = true)
    Enchere findbyAll(@Param(value = "date_enchere") Timestamp timestamp, @Param(value = "description") String description, @Param(value = "idcategorie") int idcategorie, @Param(value = "id") int id);

    @Query(value = "select max(id) from enchere", nativeQuery = true)
    Integer getMax();

}
