package com.example.demo.repository;

import com.example.demo.model.AdminToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AdminTokenRepository extends JpaRepository<AdminToken,Integer> {
    @Query(value = "SELECT a from AdminToken a where idamin= :idAdmin and a.dateExp>now()",nativeQuery = true)
    public List<AdminToken> getValidTokenById(@Param(value = "idAdmin") Integer idAdmin);

    @Query(value = "select * from AdminToken a where a.tokenvalue= :value and a.date>now()",nativeQuery = true)
    public AdminToken getTokenByValue(@Param(value = "value") String value);

    @Transactional
    @Modifying
    @Query(value = "UPDATE AdminToken set date=now() where idadmin= :idAdmin",nativeQuery = true)
    public void unvalidOldToken(@Param(value = "idAdmin") Integer idAdmin);

}
