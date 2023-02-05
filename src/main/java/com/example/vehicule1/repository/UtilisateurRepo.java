package com.example.vehicule1.repository;

import com.example.vehicule1.model.Admin;
import com.example.vehicule1.model.AdminToken;
import com.example.vehicule1.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UtilisateurRepo extends JpaRepository<Utilisateur,Integer> {
    @Query(value = "select a from Utilisateur a where a.email= :email and a.mdp= :mdp")
    public Utilisateur findByEmailAndMdp(@Param("email") String email, @Param("mdp") String mdp);



}
