package com.example.vehicule1.service;

import com.example.vehicule1.model.Admin;
import com.example.vehicule1.model.AdminToken;
import com.example.vehicule1.repository.AdminRepository;
import com.example.vehicule1.repository.AdminTokenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;


@Service
public class AdminTokenService extends CrudService<AdminToken, AdminTokenRepository>{
    public AdminTokenService(AdminTokenRepository repo) {
        super(repo);
    }

    public AdminToken saveToken(AdminToken adminToken) {
        return repo.save(adminToken);
    }

    public List<AdminToken> getValidToken(Integer idAdmin) {
        List<AdminToken> list=repo.getValidTokenById(idAdmin);
        return list;
    }

    public AdminToken getValidTokenByToken(String token) {
        return repo.getTokenByValue(token);
    }

    public AdminToken logout(AdminToken adminToken) {
        adminToken.setDateExp(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        repo.save(adminToken);
        return adminToken;
    }

    public AdminToken checkToken(String value) {
        return repo.getTokenByValue(value);
    }

    public void unvalidOldToken(Integer idAdmin){
        repo.unvalidOldToken(idAdmin);
    }
}
