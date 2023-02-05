package com.example.vehicule1.service;

import com.example.vehicule1.model.Mouvement;
import com.example.vehicule1.repository.MouvementRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MouvementService extends CrudService<Mouvement, MouvementRepo>{
    public MouvementService(MouvementRepo repo) {
        super(repo);
    }
    public double getMoney(Integer id){
        return  repo.getMoney(id);
    }
    public void save(Mouvement m){
            repo.save(m);
    }
    public void deleteByNomMvt(Integer idNomMvt,Integer idUtilisateur){
        repo.deleteByIdNomMvtAndIdUtilisateur(idNomMvt,idUtilisateur);
    }
    @Transactional
    public void deleteByIdNomMvtAndIdEnchere(Integer nom,Integer idEnchere,Double credit){
        repo.deleteByIdNomMvtAndIdEnchereAndAndCredit(nom,idEnchere,credit);
    }
}
