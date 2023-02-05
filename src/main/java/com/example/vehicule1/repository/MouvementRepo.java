package com.example.vehicule1.repository;

import com.example.vehicule1.model.AdminToken;
import com.example.vehicule1.model.Mouvement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MouvementRepo extends JpaRepository<Mouvement,Integer> {
    @Query(value = "select sum(debit)-sum(credit) from mouvement where idUtilisateur= :idutilisateur",nativeQuery = true)
    double getMoney(@Param(value = "idutilisateur") Integer idutilisateur);

    public void deleteByIdNomMvtAndIdUtilisateur(Integer idNomMvt,Integer idUtilisateur);

    public void deleteByIdNomMvtAndIdEnchereAndAndCredit(Integer nom,Integer idEnchere,Double credit);
}
