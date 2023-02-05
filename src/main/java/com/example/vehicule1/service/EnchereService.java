package com.example.vehicule1.service;

import com.example.vehicule1.execute.Connexion;
import com.example.vehicule1.model.Enchere;
import com.example.vehicule1.model.Search;
import com.example.vehicule1.repository.EnchereRepo;
import com.example.vehicule1.repository.PhotoRepo;
import com.example.vehicule1.repository.StatutEnchereRepo;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.vehicule1.connectBase.ConnectBase;
import com.example.vehicule1.model.*;

import java.sql.PreparedStatement;
import java.util.Vector;


@Service
public class EnchereService extends CrudService<Enchere, EnchereRepo>{
    public final StatutEnchereRepo statutEnchereRepo;
    public final PhotoRepo photoRepo;
    public EnchereService(EnchereRepo repo, StatutEnchereRepo statutEnchereRepo, PhotoRepo photoRepo) {
        super(repo);
        this.statutEnchereRepo = statutEnchereRepo;
        this.photoRepo = photoRepo;
    }


    public List<Enchere> getAllEnchere(){
        List<Enchere> rep=repo.findAll();
        for(int i=0;i<rep.size();i++){
           rep.get(i).setStatutEnchere(statutEnchereRepo.findById(rep.get(i).getIdStatus()).get());
           rep.get(i).setPhoto(photoRepo.findbyAll(rep.get(i).getId()).get(0));
        }
        return rep;
    }
    public  Enchere getEnchereById(Integer idEnchere){
        Enchere rep=repo.findById(idEnchere).get();
        /*List<Enchere> rep=repo.findAllById(idEnchere);
        for(int i=0;i<rep.size();i++){
            rep.get(i).setStatutEnchere(statutEnchereRepo.findById(rep.get(i).getIdStatus()).get());
        }*/
        rep.setStatutEnchere(statutEnchereRepo.findById(rep.getIdStatus()).get());

        return rep;
    }
    public  List<Enchere> getEnchereByUser(Integer idUser){
        List<Enchere> rep=repo.findAllByIdUtilisateur(idUser);
        for(int i=0;i<rep.size();i++){
            rep.get(i).setStatutEnchere(statutEnchereRepo.findById(rep.get(i).getIdStatus()).get());
            rep.get(i).setPhoto(photoRepo.findbyAll(rep.get(i).getId()).get(0));
        }
        return rep;
    }

    public List<Enchere> search(String query) throws SQLException {
        List<Enchere> rep=new ArrayList<>();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            con=new Connexion().getconnect();
            st= con.createStatement();
            rs=st.executeQuery(query);
            while (rs.next()){
                Enchere ench=new Enchere();
                ench.setId(rs.getInt("id"));

                ench.setDate_enchere( rs.getTimestamp("date_enchere").toLocalDateTime());
                ench.setNom(rs.getString("nom"));
                ench.setIdStatus(rs.getInt("idstatus"));
                ench.setIdCategorie(rs.getInt("idcategorie"));
                ench.setIdUtilisateur(rs.getInt("idutilisateur"));
                ench.setPrix_minimal(rs.getDouble("prix_minimal"));
                ench.setCommission(rs.getDouble("commission"));
                ench.setDescription(rs.getString("description"));
                ench.setDuree(rs.getDouble("duree"));
                ench.setPhoto(photoRepo.findbyAll(ench.getId()).get(0));
                //ench.setStatutEnchere(statutEnchereRepo.getReferenceById(ench.getIdStatus()));
                rep.add(ench);
            }
        }
        catch (Exception e){

        }
        finally {
            if(con!=null){
                con.close();
            }
            if (st!=null){
                st.close();
            }
            if(rs!=null){
                rs.close();
            }
        }
        return rep;
    }
    public String getSearch(Search s){
        String rep="select * from enchere where 1=1";
        if( s.getIdStatut().equals("")==false){
            rep+=" and idstatus="+s.getIdStatut();
        }
        if( s.getIdCategorie().equals("")==false){
            rep+=" and idcategorie"+s.getIdCategorie();
        }
        if( s.getDate_debut().equals("")==false){
            rep+=" and date_enchere='"+s.getDate_debut()+"'";
        }
        if( s.getPrix().equals("")==false){
            rep+=" and prix_minimal="+s.getPrix();
        }
        if(s.getMot_cle().equals("")==false){
            rep+=" and description LIKE '%"+s.getMot_cle()+"%'";
        }
        System.out.println("voici la requete "+rep);
        return rep;
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
