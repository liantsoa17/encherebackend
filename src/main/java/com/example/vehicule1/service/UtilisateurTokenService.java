package com.example.vehicule1.service;

import com.example.vehicule1.model.Admin;
import com.example.vehicule1.model.AdminToken;
import com.example.vehicule1.model.Utilisateur;
import com.example.vehicule1.model.UtilisateurToken;
import com.example.vehicule1.repository.AdminRepository;
import com.example.vehicule1.repository.UtilisateurTokenRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@Service
public class UtilisateurTokenService extends CrudService<UtilisateurToken, UtilisateurTokenRepo>{
    public UtilisateurTokenService(UtilisateurTokenRepo repo) {
        super(repo);
    }

    public UtilisateurToken saveToken(UtilisateurToken utilisateurToken) {
        return repo.save(utilisateurToken);
    }

    public List<UtilisateurToken> getValidToken(Integer id) {
        List<UtilisateurToken> list=repo.getValidTokenById(id);
        return list;
    }

    public UtilisateurToken getValidTokenByToken(String token) {
        return repo.getTokenByValue(token);
    }

    public UtilisateurToken logout(UtilisateurToken utilisateurToken) {
        utilisateurToken.setDateExp(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        repo.save(utilisateurToken);
        return utilisateurToken;
    }

    public UtilisateurToken checkToken(String value) {
        return repo.getTokenByValue(value);
    }

    public void unvalidOldToken(Integer id){
        repo.unvalidOldToken(id);
    }
}
