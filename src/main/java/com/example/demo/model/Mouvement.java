package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "mouvement")
public class Mouvement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "idutilisateur")
    Integer idUtilisateur;

    @Column(name = "idnommvt")
    Integer idNomMvt;

    @Column(name = "credit")
    double credit;

    @Column(name = "debit")
    double debit;
}
