package com.example.demo.service;



import com.example.demo.Exception.CustomException;

import java.util.List;
public interface Service <E> {

    E create(E obj) throws CustomException;

    E update(E obj) throws CustomException;

    void delete(Integer id);

    E findById(Integer id);

    Iterable<E> findAll();
    List<E> saveAll(List<E> obj);

}
