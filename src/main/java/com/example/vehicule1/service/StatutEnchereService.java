package com.example.vehicule1.service;

import com.example.vehicule1.model.StatutEnchere;
import com.example.vehicule1.repository.StatutEnchereRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatutEnchereService extends CrudService<StatutEnchere, StatutEnchereRepo>{
    public StatutEnchereService(StatutEnchereRepo repo) {
        super(repo);
    }
    public List<StatutEnchere> getAll(){
        return this.repo.findAll();
    }
}
