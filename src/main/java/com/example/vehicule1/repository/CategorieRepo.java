package com.example.vehicule1.repository;

import com.example.vehicule1.model.AdminToken;
import com.example.vehicule1.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepo extends JpaRepository<Categorie,Integer> {
}
