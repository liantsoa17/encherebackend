package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Exception.CustomException;
import com.example.demo.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.AdminService;
import com.example.demo.service.CategorieService;
import com.example.demo.service.CommissionService;
import com.example.demo.service.EnchereService;
import com.example.demo.service.DemandeRechargeService;
import com.example.demo.service.*;
import com.example.demo.repository.*;



@Controller
public class AllController {

    @Autowired
    AdminService AdminService;

    @Autowired
    CategorieService CategorieService;

    @Autowired
    EnchereService EnchereService;

    @Autowired
    CommissionService CommissionService;

    @Autowired
    DemandeRechargeRepo DemandeRechargeRepo;

    @Autowired
    DemandeRechargeService DemandeRechargeService;

    @Autowired
    MouvementService MouvementService;


    @Autowired
    EnchereRepo EnchereRepo;


    @Autowired
    V_Statistique_primRepo V_Statistique_primRepo;
    
   

    @RequestMapping(value = "/index")
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = "/loginAdmin")
    public String Seconnecter(HttpServletRequest request,Model m){
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        Admin admin = AdminService.login(email, mdp);
        if(admin!=null){
            return "acceuil";
        }return "index";
    }
    @RequestMapping(value = "/Categorie")
    public String Categorie(Model m){
        Iterable<Categorie> listCategorie = CategorieService.findAll();
        m.addAttribute("listCategorie", listCategorie);
        return "Categorie";
    }
    @RequestMapping(value = "/newCategorie")
    public String newCategorie(HttpServletRequest request,Model m) throws CustomException{
        String categorie = request.getParameter("categorie");
        Categorie cat = new Categorie();
        cat.setNom(categorie);
        CategorieService.create(cat);
        Iterable<Categorie> listCategorie = CategorieService.findAll();
        m.addAttribute("listCategorie", listCategorie);
        return "Categorie";
    }
    @RequestMapping(value = "/updateCategorie")
    public String updateCategorie(HttpServletRequest request,Model m) throws CustomException{
        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        m.addAttribute("id", id);
        m.addAttribute("nom", nom);
        return "updateCategorie";
    }
    @RequestMapping(value = "/Updateexecute")
    public String Updateexecute(HttpServletRequest request,Model m) throws CustomException{
        String id = request.getParameter("id");
        String valeur = request.getParameter("valeur");
        Categorie categorie = new Categorie();
        categorie.setId(Integer.parseInt(id));
        categorie.setNom(valeur);
        CategorieService.update(categorie);
        Iterable<Categorie> listCategorie = CategorieService.findAll();
        m.addAttribute("listCategorie", listCategorie);
        return "Categorie";
    }
    @RequestMapping(value = "/deleteCategorie")
    public String deleteCategorie(HttpServletRequest request,Model m) throws CustomException{
        String id = request.getParameter("id");
        CategorieService.delete(Integer.parseInt(id));
        Iterable<Categorie> listCategorie = CategorieService.findAll();
        m.addAttribute("listCategorie", listCategorie);
        return "Categorie";
    }
    @RequestMapping(value = "/listeEnchere")
    public String listeEnchere(Model m) throws CustomException{
        Iterable<Enchere> listEnchere = EnchereService.findAll();
        m.addAttribute("listEnchere", listEnchere);
        return "ListeEnchere";
    }
    @RequestMapping(value = "/pourcentage")
    public String pourcentage() throws CustomException{
        return "Commision";
    }

    @RequestMapping(value = "/Commission")
    public String Commission(HttpServletRequest request) throws CustomException{
        String pourcentage = request.getParameter("pourcentage");
        Commission commision = new Commission();
        commision.setPourcentage(Double.parseDouble(pourcentage));
        CommissionService.create(commision);
        return "acceuil";
    }

    @RequestMapping(value = "/demandeRecharge")
    public String demadedeRecharge(Model m) throws CustomException{
        List<DemandeRecharge> list = DemandeRechargeRepo.findwhereEtat();
        m.addAttribute("demande", list);
        return "DemandeRecharge";
    }

    @RequestMapping(value = "/statistique")
    public String statistique(Model m) throws Exception{
        List<V_Statistique_prim> list_enchere = EnchereService.statistique();
        String donnee = "";
        for(int i = 0 ; i < list_enchere.size() ; i++){
            donnee+=((V_Statistique_prim) list_enchere.get(i)).getId()+","
            +((V_Statistique_prim) list_enchere.get(i)).getNom()+","+((V_Statistique_prim) list_enchere.get(i)).getIdcategorie()+"/";
        }
        m.addAttribute("list_enchere", donnee);
        return "statistique";
    }

    @RequestMapping(value = "/stat")
    public String stat(Model m) throws Exception{
        List<V_Statistique_sec> list_enchere = EnchereService.statistiqueparUser();
        String donnee = "";
        for(int i = 0 ; i < list_enchere.size() ; i++){
            donnee+=((V_Statistique_sec) list_enchere.get(i)).getId()+","
            +((V_Statistique_sec) list_enchere.get(i)).getNom()+","+((V_Statistique_sec) list_enchere.get(i)).getIdutilisateur()+"/";
        }
        m.addAttribute("list_enchere", donnee);
        return "statistique_sec";
    }

    @RequestMapping(value = "/statistiqueparUser")
    public String statistiqueparUser(Model m) throws Exception{
        List<V_Statistique_prim> list_enchere = EnchereService.statistique();
        String donnee = "";
        for(int i = 0 ; i < list_enchere.size() ; i++){
            donnee+=((V_Statistique_prim) list_enchere.get(i)).getId()+","
            +((V_Statistique_prim) list_enchere.get(i)).getNom()+","+((V_Statistique_prim) list_enchere.get(i)).getIdcategorie()+"/";
        }
        m.addAttribute("list_enchere", donnee);
        return "statistique";
    }

    @RequestMapping(value = "/AccepterdemandeRecharge")
    public String AccepterdemandeRecharge(HttpServletRequest request,Model m) throws CustomException{
        String idDemande = request.getParameter("idDemande");
        String idutilisateur = request.getParameter("idutilisateur");
        String valeur = request.getParameter("valeur");
        DemandeRecharge demande = new DemandeRecharge();
        demande.setEtat(1);
        demande.setId(Integer.parseInt(idDemande));
        demande.setIdUtilisateur(Integer.parseInt(idutilisateur));
        demande.setValeur(Double.parseDouble(valeur));
        DemandeRechargeService.update(demande);
        Mouvement mouvement = new Mouvement();
        mouvement.setIdUtilisateur(demande.getIdUtilisateur());
        mouvement.setCredit(0);
        mouvement.setDebit(demande.getValeur());
        mouvement.setIdNomMvt(1);
        MouvementService.create(mouvement);
        List<DemandeRecharge> list = DemandeRechargeRepo.findwhereEtat();
        m.addAttribute("demande", list);
        return "DemandeRecharge";
    }
}
