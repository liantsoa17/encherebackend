package com.example.vehicule1.service;

import com.example.vehicule1.model.NomMvt;
import com.example.vehicule1.repository.NomMvtRepo;
import org.springframework.stereotype.Service;

@Service
public class NomMvtService extends CrudService<NomMvt, NomMvtRepo>{
    public NomMvtService(NomMvtRepo repo) {
        super(repo);
    }
}
