package com.example.demo.service;

import com.example.demo.model.Mouvement;
import com.example.demo.repository.MouvementRepo;
import org.springframework.stereotype.Service;

@Service
public class MouvementService extends CrudService<Mouvement, MouvementRepo>{
    public MouvementService(MouvementRepo repo) {
        super(repo);
    }
}
