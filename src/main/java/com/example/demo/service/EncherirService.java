package com.example.demo.service;

import com.example.demo.model.Encherir;
import com.example.demo.repository.EncherirRepo;
import org.springframework.stereotype.Service;

@Service
public class EncherirService extends CrudService<Encherir, EncherirRepo>{
    public EncherirService(EncherirRepo repo) {
        super(repo);
    }
}
