package com.example.demo.repository;

// import com.example.demo.model.Admin;
// import com.example.demo.model.AdminToken;
import com.example.demo.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepo extends JpaRepository<Utilisateur,Integer> {
    @Query(value = "select a from Utilisateur a where a.email= :email and a.mdp= :mdp")
    public Utilisateur findByEmailAndMdp(@Param("email") String email, @Param("mdp") String mdp);
}
