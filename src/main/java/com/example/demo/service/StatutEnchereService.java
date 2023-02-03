package com.example.demo.service;

import com.example.demo.model.StatutEnchere;
import com.example.demo.repository.StatutEnchereRepo;
import org.springframework.stereotype.Service;

@Service
public class StatutEnchereService extends CrudService<StatutEnchere, StatutEnchereRepo>{
    public StatutEnchereService(StatutEnchereRepo repo) {
        super(repo);
    }
}
