package com.example.vehicule1.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehicule1.Exception.CustomException;
import com.example.vehicule1.model.*;
import com.example.vehicule1.repository.*;
import com.example.vehicule1.service.*;

@RestController
@CrossOrigin
public class Controller {
    @Autowired
    UtilisateurService UtilisateurService;

    @Autowired
    AdminService AdminService;

    @Autowired
    EnchereService EnchereService;

    @Autowired
    EnchereRepo EnchereRepo;

    @Autowired
    PhotoRepo PhotoRepo;

    @Autowired
    CommissionRepo CommissionRepo;

    @Autowired
    CategorieService categorieService;

    @Autowired
    V_Enchere_DetailsRepo V_listEncherRepo;


    @Autowired
    DemandeRechargeRepo DemandeRechargeRepo;


    @GetMapping("/saveUtilisateur/{nom}&{prenom}&{date_naissance}&{email}&{mdp}")
    private Utilisateur getKilometrage(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom,
                                       @PathVariable("date_naissance") String date_naissance, @PathVariable("email") String email,
                                       @PathVariable("mdp") String mdp) throws CustomException {
        Utilisateur user = new Utilisateur();
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setDate_naissance(Date.valueOf(date_naissance));
        user.setEmail(email);
        user.setMdp(mdp);
        UtilisateurService.create(user);
        Utilisateur utilisateur = UtilisateurService.login(user.getEmail(), user.getMdp());
        return utilisateur;
    }

    @GetMapping("/LoginAdmin/{email}&{mdp}")
    private Admin LoginAdmin(@PathVariable("email") String email, @PathVariable("mdp") String mdp) {
        Admin admin = AdminService.login(email, mdp);
        return admin;
    }

    @GetMapping("/AjoutEnchere/{nom}&{description}&{idcategorie}&{prix_minimal}&{duree}&{idutilisateur}")
    private Enchere AjoutEnchere(@PathVariable("nom") String nom, @PathVariable("description") String description,
                                 @PathVariable("idcategorie") String idcategorie, @PathVariable("prix_minimal") String prix_minimal,
                                 @PathVariable("duree") String duree, @PathVariable("idutilisateur") String idutilisateur)
            throws CustomException {
        Enchere enchere = new Enchere();
        Commission commission = CommissionRepo.findCommission();
        enchere.setNom(nom);
        enchere.setDescription(description);
        enchere.setIdCategorie(Integer.parseInt(idcategorie));
        enchere.setPrix_minimal(Double.parseDouble(prix_minimal));
        enchere.setDuree(Double.parseDouble(duree));
        enchere.setIdUtilisateur(Integer.parseInt(idutilisateur));
        enchere.setIdStatus(1);
        enchere.setDate_enchere(LocalDateTime.now());
        enchere.setCommission((int) commission.getPourcentage());
        EnchereService.create(enchere);
       Integer max=EnchereRepo.getMax();
       Enchere rep=EnchereRepo.findById(max).get();
        return rep;
    }

    @GetMapping("/Lister_enchere/{idutilisateur}")
    private List<V_listeEnchere_par_User> ListEnchere(@PathVariable("idutilisateur") String idutilisateur) throws Exception{
        List<V_listeEnchere_par_User> liste_enchere = EnchereService.findEncherebyId(idutilisateur);
        return  liste_enchere;
    }

    @GetMapping("/LoginUser/{email}&{mdp}")
    private Utilisateur LoginUser(@PathVariable("email") String email, @PathVariable("mdp") String mdp) {
        Utilisateur utilisateur = UtilisateurService.login(email, mdp);
        return utilisateur;
    }

    @GetMapping("/getCategorieAll")
    private Iterable<Categorie> getCategorieAll() {
        Iterable<Categorie> categorie = categorieService.findAll();
        return categorie;
    }

    @PostMapping("/InsertPhoto")
    private void InsertPhoto(@RequestBody Photo image) {
        System.out.println("TONGA ATO VE ZA IO PLS");
        PhotoRepo.save(image);
    }

    @GetMapping("/getEnchereAll/{idutilisateur}")
    private List<V_Enchere_Details> GetV_listEnchereAvecImageService(@PathVariable("idutilisateur") int idutilisateur){
        List<V_Enchere_Details> enchere = V_listEncherRepo.findbyAll(idutilisateur);
        return enchere ;
    }

    @GetMapping("/getPhotoParEnchere/{idenchere}")
    private List<Photo> getPhotoParEnchere(@PathVariable("idenchere") int idenchere){
        List<Photo> photo = PhotoRepo.findbyAll(idenchere);
        return photo ;
    }

    @PostMapping("/rechargerCompte")
    private void rechargerCompte(@RequestBody DemandeRecharge compte) {
        DemandeRechargeRepo.save(compte);
    }

}
