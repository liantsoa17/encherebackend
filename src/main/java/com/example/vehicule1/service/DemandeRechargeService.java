package com.example.vehicule1.service;

import com.example.vehicule1.model.DemandeRecharge;
import com.example.vehicule1.repository.DemandeRechargeRepo;
import org.springframework.stereotype.Service;

@Service
public class DemandeRechargeService extends CrudService<DemandeRecharge, DemandeRechargeRepo>{
    public DemandeRechargeService(DemandeRechargeRepo repo) {
        super(repo);
    }
}
