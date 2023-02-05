package com.example.vehicule1.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Data
@Entity
@Table(name = "encherir")
public class Encherir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "idutilisateur")
    Integer idutilisateur;

    @Column(name = "idenchere")
    Integer idEnchere;

    @Column(name = "prix_encherir")
    double prix_encherir;

    @Column(name = "dateEncherir")
    @ColumnDefault("CURRENT_TIMESTAMP")
    Timestamp dateEncherir;



    @Transient
    Utilisateur utilisateur;
}
