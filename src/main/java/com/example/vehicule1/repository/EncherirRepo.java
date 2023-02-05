package com.example.vehicule1.repository;

import com.example.vehicule1.model.AdminToken;
import com.example.vehicule1.model.Encherir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EncherirRepo extends JpaRepository<Encherir,Integer> {
    List<Encherir> findByIdEnchere(Integer id);

    List<Encherir> findByIdutilisateur(Integer id);

    @Query(value = "select date_encherir,idEnchere,idUtilisateur,max(prix_encherir) as prix_encherir from encherir where idEnchere= :idenchere",nativeQuery = true)
    Encherir getMax(@Param(value = "idenchere") Integer idenchere);

    @Query(value = "select max(prix_encherir) from encherir where idEnchere= :idenchere",nativeQuery = true)
    Double getMaxValue(@Param(value = "idenchere") Integer idenchere);

}
