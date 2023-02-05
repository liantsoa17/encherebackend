package com.example.vehicule1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vehicule1.model.Photo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PhotoRepo extends JpaRepository<Photo,Integer> {
    @Query(value = " select * from photo where idenchere = :idenchere", nativeQuery = true)
    List<Photo> findbyAll(@Param(value = "idenchere") int idenchere);
}

