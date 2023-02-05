package com.example.vehicule1.service;

import com.example.vehicule1.model.Categorie;
import com.example.vehicule1.repository.CategorieRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService extends CrudService<Categorie, CategorieRepo>{
    public CategorieService(CategorieRepo repo) {
        super(repo);
    }
    public List<Categorie> getAll(){
        return repo.findAll();
    }
}
