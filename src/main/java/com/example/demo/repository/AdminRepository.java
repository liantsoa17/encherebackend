package com.example.demo.repository;

import com.example.demo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AdminRepository extends JpaRepository<Admin, Integer> {
    @Query(value = "select a from Admin a where a.email= :email and a.mdp= :mdpadmin")
    public Admin findByEmailAndMdp(@Param("email") String email, @Param("mdpadmin") String mdpadmin);
}
