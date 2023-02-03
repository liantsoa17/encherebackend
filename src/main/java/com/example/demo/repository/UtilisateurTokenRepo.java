package com.example.demo.repository;

// import com.example.demo.model.AdminToken;
import com.example.demo.model.UtilisateurToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UtilisateurTokenRepo extends JpaRepository<UtilisateurToken,Integer> {
    @Query(value = "SELECT a from UtilisateurToken a where idUtilisateur= :idUtilisateur and a.dateExp>now()",nativeQuery = true)
    public List<UtilisateurToken> getValidTokenById(@Param(value = "idUtilisateur") Integer idUtilisateur);

    @Query(value = "select * from UtilisateurToken a where a.tokenvalue= :value and a.date>now()",nativeQuery = true)
    public UtilisateurToken getTokenByValue(@Param(value = "value") String value);

    @Transactional
    @Modifying
    @Query(value = "UPDATE UtilisateurToken set date=now() where idUtilisateur= :idUtilisateur",nativeQuery = true)
    public void unvalidOldToken(@Param(value = "idUtilisateur") Integer idUtilisateur);
}
