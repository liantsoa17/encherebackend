package com.example.demo.service;

import com.example.demo.model.Categorie;
import com.example.demo.repository.CategorieRepo;
import org.springframework.stereotype.Service;

@Service
public class CategorieService extends CrudService<Categorie, CategorieRepo>{
    public CategorieService(CategorieRepo repo) {
        super(repo);
    }
}
