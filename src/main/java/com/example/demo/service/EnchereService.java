package com.example.demo.service;

import com.example.demo.connectBase.ConnectBase;
import com.example.demo.model.*;
import com.example.demo.repository.EnchereRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Service;


@Service
public class EnchereService extends CrudService<Enchere, EnchereRepo>{
    public EnchereService(EnchereRepo repo) {
        super(repo);
    }
    public List<V_Statistique_prim> statistique() throws Exception{
        ConnectBase con = new ConnectBase();
        Connection connection = con.Connect();
        String requete = "select * from V_Statistique_prim";
        PreparedStatement stmt = connection.prepareStatement(requete);
        ResultSet resultat = stmt.executeQuery();
        Vector<V_Statistique_prim> list_Enchere = new Vector<V_Statistique_prim>();
        V_Statistique_prim enchere = null;
        while(resultat.next()){
            enchere = new V_Statistique_prim();
            enchere.setId(resultat.getInt("id"));
            enchere.setIdcategorie(resultat.getInt("idcategorie"));
            enchere.setNom(resultat.getString("nom"));
            list_Enchere.add(enchere);
        }
        return list_Enchere;
    }

    public List<V_Statistique_sec> statistiqueparUser() throws Exception{
        ConnectBase con = new ConnectBase();
        Connection connection = con.Connect();
        String requete = "select * from V_Statistique_sec";
        PreparedStatement stmt = connection.prepareStatement(requete);
        ResultSet resultat = stmt.executeQuery();
        Vector<V_Statistique_sec> list_Enchere = new Vector<V_Statistique_sec>();
        V_Statistique_sec enchere = null;
        while(resultat.next()){
            enchere = new V_Statistique_sec();
            enchere.setId(resultat.getInt("id"));
            enchere.setIdutilisateur(resultat.getInt("idutilisateur"));
            enchere.setNom(resultat.getString("nom"));
            list_Enchere.add(enchere);
        }
        return list_Enchere;
    }

    public List<V_listeEnchere_par_User> findEncherebyId(String id) throws Exception{
        ConnectBase con = new ConnectBase();
        Connection connection = con.Connect();
        String requete = "select * from V_listeEnchere_par_User where idutilisateur = "+id;
        PreparedStatement stmt = connection.prepareStatement(requete);
        ResultSet resultat = stmt.executeQuery();
        Vector<V_listeEnchere_par_User> list_Enchere = new Vector<V_listeEnchere_par_User>();
        V_listeEnchere_par_User enchere = null;
        while(resultat.next()){
            enchere = new V_listeEnchere_par_User();
            enchere.setId(resultat.getInt("id"));
            enchere.setCommission(resultat.getInt("commission"));
            enchere.setDescription(resultat.getString("description"));
            enchere.setDuree(resultat.getDouble("duree"));
            enchere.setIdCategorie(resultat.getInt("idcategorie"));
            enchere.setIdUtilisateur(resultat.getInt("idutilisateur"));
            enchere.setNom(resultat.getString("nom"));
            enchere.setPrix_minimal(resultat.getDouble("prix_minimal"));
            enchere.setIntitule(resultat.getString("intitule"));
            list_Enchere.add(enchere);
        }
        return list_Enchere;
    }
}
