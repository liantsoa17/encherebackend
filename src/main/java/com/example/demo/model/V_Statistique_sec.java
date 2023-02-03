package com.example.demo.model;
import javax.persistence.Column;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Immutable
@Table(name = "V_Statistique_sec")
public class V_Statistique_sec {
    @Id
    @Column(name = "id")
    Integer id;

    @Column(name = "idutilisateur")
    int idutilisateur;

    @Column(name = "nom")
    String nom;
}
