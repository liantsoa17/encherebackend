package com.example.vehicule1.service;

import com.example.vehicule1.model.Commission;
import com.example.vehicule1.repository.CommissionRepo;
import org.springframework.stereotype.Service;

@Service
public class CommissionService extends CrudService<Commission, CommissionRepo>{
    public CommissionService(CommissionRepo repo) {
        super(repo);
    }
}
