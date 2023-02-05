package com.example.vehicule1.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Entity
@Table(name = "enchere")
public class Enchere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "date_enchere",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    LocalDateTime date_enchere;

    @Column(name = "nom")
    String nom;

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
    double commission;

    @Transient
    StatutEnchere statutEnchere;

    @Transient
    Photo photo;

}
