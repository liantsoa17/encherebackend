package com.example.demo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.example.demo.connectBase.ConnectBase;
import com.example.demo.model.V_Enchere_Details;
import com.example.demo.repository.V_Enchere_DetailsRepo;

public class V_Enchere_DetailsService  extends CrudService<V_Enchere_Details, V_Enchere_DetailsRepo>{
    public V_Enchere_DetailsService(V_Enchere_DetailsRepo repo) {
        super(repo);
    }
    public List<V_Enchere_Details> V_listEnchereAvecImageparId(String idutilisateur) throws Exception{
        ConnectBase con = new ConnectBase();
        Connection connection = con.Connect();
        String requete = "select * from V_listEnchereAvecImage where  idutilisateur = "+idutilisateur;
        PreparedStatement stmt = connection.prepareStatement(requete);
        ResultSet resultat = stmt.executeQuery();
        Vector<V_Enchere_Details> list_Enchere = new Vector<V_Enchere_Details>();
        V_Enchere_Details enchere = null;
        while(resultat.next()){
            enchere = new V_Enchere_Details();
            enchere.setId(resultat.getInt("id"));
            enchere.setCommission(resultat.getInt("commission"));
            enchere.setDate_enchere(resultat.getTimestamp("date_enchere"));
            enchere.setDescription(resultat.getString("description"));
            enchere.setDuree(resultat.getDouble("duree"));
            enchere.setIdcategorie(resultat.getInt("idcategorie"));
            enchere.setIdstatus(resultat.getInt("idstatus"));
            enchere.setIdutilisateur(resultat.getInt("idutilisateur"));
            enchere.setNom(resultat.getString("nom"));
            enchere.setPrix_minimal(resultat.getDouble("prix_minimal"));
            enchere.setIntitule(resultat.getString("intitule"));
            enchere.setNomcategoirie(resultat.getString("base64"));
            list_Enchere.add(enchere);
        }
        return list_Enchere;
    }
}
