package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import  java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom")
    String nom;

    @Column(name = "prenom")
    String prenom;

    @Column(name = "mdp")
    String mdp;

    @Column(name = "email")
    String email;

    @Column(name = "date_naissance")
    Date date_naissance;
}
