package com.example.demo.model;
import javax.persistence.Column;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Immutable;

import lombok.*;

import java.security.Timestamp;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Immutable
@Table(name = "V_listeEnchere_par_User")
public class V_listeEnchere_par_User {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    String nom;

    @Column(name = "date_enchere")
    @ColumnDefault("CURRENT_TIMESTAMP")
    Timestamp date_enchere;

    @Column(name = "description")
    String description;

    @Column(name = "idcategorie")
    Integer idCategorie;

    @Column(name = "prix_minimal")
    double prix_minimal;

    @Column(name = "duree")
    double duree;

    @Column(name = "idutilisateur")
    Integer idUtilisateur;

    @Column(name = "idstatus")
    Integer idStatus;

    @Column(name = "commission")
    Integer commission;


    @Column(name = "intitule")
    String intitule;


}
///create or replace view V_listeEnchere_par_User as select enchere.*,
// statutenchere.intitule from enchere join statutenchere on enchere.idstatus = statutenchere.id
