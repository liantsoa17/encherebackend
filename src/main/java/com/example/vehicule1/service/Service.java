package com.example.vehicule1.service;



import com.example.vehicule1.Exception.CustomException;

import java.util.List;
public interface Service <E> {

    E create(E obj) throws CustomException;

    E update(E obj) throws CustomException;

    void delete(Integer id);

    E findById(Integer id);

    Iterable<E> findAll();
    List<E> saveAll(List<E> obj);

}
