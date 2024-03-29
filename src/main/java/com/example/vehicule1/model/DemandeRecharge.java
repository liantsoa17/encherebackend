package com.example.vehicule1.model;

import lombok.Cleanup;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "demanderecharge")
public class DemandeRecharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "idutilisateur")
    Integer idUtilisateur;

    @Column(name = "valeur")
    double valeur;

    @Column(name = "etat")
    int etat;
}
