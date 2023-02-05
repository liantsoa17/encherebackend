package com.example.vehicule1.controller;

import com.example.vehicule1.model.*;
import com.example.vehicule1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class AnotherController {
    @Autowired
    AdminService adminService;

    @Autowired
    AdminTokenService adminTokenService;

    @Autowired
    CommissionService commissionService;

    @Autowired
    DemandeRechargeService demandeRechargeService;

    @Autowired
    EnchereService enchereService;

    @Autowired
    EncherirService encherirService;

    @Autowired
    MouvementService mouvementService;

    @Autowired
    NomMvtService nomMvtService;

    @Autowired
    NotificationsService notificationsService;

    @Autowired
    StatutEnchereService statutEnchereService;

    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    UtilisateurTokenService utilisateurTokenService;

    @Autowired
    EnchereFaitService enchereFaitService;

    @Autowired
    CategorieService categorieService;




    @GetMapping(  "/enchere")
    public List<Enchere> getEnchere(){
        return enchereService.getAllEnchere();
    }


    @PostMapping( "/rechercher")
    public List<Enchere> getRechercher(@RequestBody Search s,@RequestHeader("token") String value)throws SQLException {
        System.out.println("TONGA ATO OOOO");
        return enchereService.search(enchereService.getSearch(s));
    }

    @CrossOrigin
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test(@RequestBody InputEncherir inputEncherir){
        Encherir encherir=new Encherir();
        System.out.println("ireto ooo "+inputEncherir.getInput()+" "+inputEncherir.getIdEnchere());
        encherir.setPrix_encherir(Double.valueOf(inputEncherir.getInput()));
        encherir.setIdEnchere(Integer.valueOf(inputEncherir.getIdEnchere()));
        encherirService.save(encherir);
        return "";
    }

    @PostMapping(  "/rencherir")
    public String encherir(@RequestHeader("token") String value,@RequestBody InputEncherir inputEncherir){
        String rep="";
        double input=Double.valueOf(inputEncherir.getInput());
        Integer idEnchere=Integer.valueOf(inputEncherir.getIdEnchere());
        Integer idUtilisateur=utilisateurTokenService.checkToken(value).getUtilisateur().getId();
        //Integer idUtilisateur=utilisateurTokenService.checkToken(inputEncherir.getToken()).getUtilisateur().getId();
        Double max=encherirService.getMax(idEnchere);
        Enchere enchere=enchereService.getEnchereById(idEnchere);

        if(max==null||max<enchere.getPrix_minimal()){
            max=enchere.getPrix_minimal();
        }
        if(enchere.getIdUtilisateur()==idUtilisateur){
            rep="Ceci est votre enchere vous ne pouves pas rencherir";
        }
        else if(enchere.getIdStatus()==2){
            rep="Cette enchere est déjà terminée";
        }
        else if(max>input){
            rep="L'argent deboucher doit etre superieur au prix d' enchere minimum";
        }
        else if(input>mouvementService.getMoney(idUtilisateur)){
            rep="Votre fond n'est pas suffisant pour cette requete";
        }
        else{
            Encherir encherir=new Encherir();
            encherir.setPrix_encherir(input);
            encherir.setIdEnchere(idEnchere);
            encherir.setIdutilisateur(idUtilisateur);
            encherirService.save(encherir);
            Mouvement mouv=new Mouvement();
            mouv.setIdNomMvt(10);
            mouv.setCredit(input);
            mouv.setDebit(0);
            mouv.setIdUtilisateur(idUtilisateur);
            mouvementService.save(mouv);
            System.out.println("Ito max ooo "+max);
            mouvementService.deleteByIdNomMvtAndIdEnchere(10,idEnchere,max);
            rep="Vous avez rencheri avec succes";

        }
        return rep;

    }
    @GetMapping("/test")
    public void test(){
        mouvementService.deleteByIdNomMvtAndIdEnchere(10,2,210000.0);
    }


    @PostMapping(  "/mesencheres")
    public List<Enchere> mesEncheres(@RequestHeader("token") String value){
        Integer idUtilisateur=utilisateurTokenService.checkToken(value).getUtilisateur().getId();
        // Integer idUtilisateur=1;
        return  enchereService.getEnchereByUser(idUtilisateur);
    }

    @GetMapping(  "/historique/{id}")
    public List<Encherir> historique(@PathVariable("id") Integer id){
        return encherirService.findByIdEnchere(id);
    }

    @GetMapping("/encherefait")
    public List<EnchereFait> enchereFait(@RequestHeader("token") String value){
        Integer idUtilisateur=utilisateurTokenService.checkToken(value).getUtilisateur().getId();
        return enchereFaitService.getEnchereFait(idUtilisateur);
    }
    @GetMapping("/categorie")
    public List<Categorie> categorie(){
        return categorieService.getAll();
    }
    @GetMapping("/statutenchere")
    public List<StatutEnchere> statut(){
        return statutEnchereService.getAll();
    }


}
