package com.example.demo.service;

import com.example.demo.model.DemandeRecharge;
import com.example.demo.repository.DemandeRechargeRepo;
import org.springframework.stereotype.Service;

@Service
public class DemandeRechargeService extends CrudService<DemandeRecharge, DemandeRechargeRepo>{
    public DemandeRechargeService(DemandeRechargeRepo repo) {
        super(repo);
    }

}
