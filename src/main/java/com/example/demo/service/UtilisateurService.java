package com.example.demo.service;

// import com.example.demo.model.Admin;
import com.example.demo.model.Utilisateur;
// import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.UtilisateurRepo;
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
