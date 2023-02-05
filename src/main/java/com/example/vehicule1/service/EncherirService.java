package com.example.vehicule1.service;

import com.example.vehicule1.model.Encherir;
import com.example.vehicule1.repository.EncherirRepo;
import com.example.vehicule1.repository.UtilisateurRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncherirService extends CrudService<Encherir, EncherirRepo>{
    private final UtilisateurRepo utilisateurRepo;
    public EncherirService(EncherirRepo repo, UtilisateurRepo utilisateurRepo) {
        super(repo);
        this.utilisateurRepo = utilisateurRepo;
    }
    public List<Encherir> findByIdEnchere(Integer id){
        List<Encherir> rep=repo.findByIdEnchere(id);
        for(int i=0;i<rep.size();i++){
            rep.get(i).setUtilisateur(utilisateurRepo.findById(rep.get(i).getIdutilisateur()).get());
        }
        return rep;
    }
    public Double getMax(Integer id){
        return  repo.getMaxValue(id);
    }
    public void save(Encherir e){
        repo.save(e);
    }
}
