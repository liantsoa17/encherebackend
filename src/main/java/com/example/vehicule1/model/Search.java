package com.example.vehicule1.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Data
public class Search {
    String date_debut;
    String idCategorie;
    String idStatut;
    String prix;
    String mot_cle;

}
