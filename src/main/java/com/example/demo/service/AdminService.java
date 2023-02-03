package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService extends CrudService<Admin, AdminRepository>{
    public AdminService(AdminRepository repo) {
        super(repo);
    }


    public Admin login(String email, String mdpadmin) {
        return repo.findByEmailAndMdp(email, mdpadmin);
    }


    public Admin getById(Integer id) {
        Optional<Admin> admin=repo.findById(id);
        return admin.orElse(null);
    }
}
