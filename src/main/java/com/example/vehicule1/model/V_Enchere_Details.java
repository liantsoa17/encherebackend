package com.example.vehicule1.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "Enchere_Details")
public class V_Enchere_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "commission")
    int commission;

    @Column(name = "date_enchere")
    Timestamp date_enchere;

    @Column(name = "description")
    String description;

    @Column(name = "duree")
    double duree;

    @Column(name = "idcategorie")
    int idcategorie;

    @Column(name = "idstatus")
    int idstatus;

    @Column(name = "idutilisateur")
    int idutilisateur;

    @Column(name = "nom")
    String nom;

    @Column(name = "prix_minimal")
    double prix_minimal;

    @Column(name = "intitule")
    String intitule;

    @Column(name = "nomcategoirie")
    String nomcategoirie;
}
