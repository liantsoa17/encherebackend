package com.example.demo.service;

import com.example.demo.model.NomMvt;
import com.example.demo.repository.NomMvtRepo;
import org.springframework.stereotype.Service;

@Service
public class NomMvtService extends CrudService<NomMvt, NomMvtRepo>{
    public NomMvtService(NomMvtRepo repo) {
        super(repo);
    }
}
