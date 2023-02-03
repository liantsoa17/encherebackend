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
@Table(name = "V_Statistique_prim")
public class V_Statistique_prim {
    @Id
    @Column(name = "id")
    Integer id;

    @Column(name = "idcategorie")
    int idcategorie;

    @Column(name = "nom")
    String nom;

    //select count(enchere.id) id,idcategorie,categorie.nom from enchere join categorie on enchere.idcategorie = categorie.id  group by idcategorie,categorie.nom
}
