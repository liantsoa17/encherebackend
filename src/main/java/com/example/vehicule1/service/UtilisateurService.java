package com.example.vehicule1.service;

import com.example.vehicule1.model.Admin;
import com.example.vehicule1.model.Utilisateur;
import com.example.vehicule1.repository.AdminRepository;
import com.example.vehicule1.repository.UtilisateurRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService extends CrudService<Utilisateur, UtilisateurRepo>{
    public UtilisateurService(UtilisateurRepo repo) {
        super(repo);
    }

    public Utilisateur login(String email, String mdp) {
        return repo.findByEmailAndMdp(email, mdp);
    }


    public Utilisateur getById(Integer id) {
        Optional<Utilisateur> user=repo.findById(id);
        return user.orElse(null);
    }
}
