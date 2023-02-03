package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;

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

}
