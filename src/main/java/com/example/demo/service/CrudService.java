package com.example.demo.service;

import com.example.demo.Exception.CustomException;
import org.springframework.data.jpa.repository.JpaRepository;
import  java.util.List;

public class CrudService <E,  R extends JpaRepository<E, Integer>> implements Service<E> {
    protected final R repo;

    public CrudService(R repo) {
        this.repo = repo;
    }

    @Override
    public E create(E obj) throws CustomException {
        return repo.save(obj);
    }

    @Override
    public E update(E obj) throws CustomException {
        return repo.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public E findById(Integer id) {
        return repo.findById(id).orElse(null);
    }


    @Override
    public Iterable<E> findAll() {
        return repo.findAll();
    }
    @Override
    public List<E>saveAll(List<E> iterable){
        return repo.saveAll(iterable);
    }
}
