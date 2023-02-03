package com.example.demo.service;

import com.example.demo.model.Commission;
import com.example.demo.repository.CommissionRepo;
import org.springframework.stereotype.Service;

@Service
public class CommissionService extends CrudService<Commission, CommissionRepo>{
    public CommissionService(CommissionRepo repo) {
        super(repo);
    }
}
