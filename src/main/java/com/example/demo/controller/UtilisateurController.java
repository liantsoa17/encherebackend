package com.example.demo.controller;

import com.example.demo.model.Utilisateur;
import com.example.demo.model.UtilisateurToken;
import com.example.demo.service.UtilisateurService;
import com.example.demo.service.UtilisateurTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
@CrossOrigin
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    UtilisateurTokenService utilisateurTokenService;

    @PostMapping("/login")
    public UtilisateurToken login(@RequestBody Utilisateur utilisateur){
        UtilisateurToken utilisateurToken=new UtilisateurToken();
        Utilisateur user=utilisateurService.login(utilisateur.getEmail(),utilisateur.getMdp());
        if(user!=null){
            utilisateurTokenService.unvalidOldToken(user.getId());
            utilisateurToken.setUtilisateur(user);
            utilisateurToken.setValue(utilisateurToken.generateToken());
            LocalDateTime dateExp=LocalDateTime.now().plusMinutes(60);
            Instant instant=dateExp.toInstant(ZoneOffset.UTC);
            utilisateurToken.setDateExp(Date.from(instant));
            utilisateurTokenService.saveToken(utilisateurToken);
        }
        return utilisateurToken;
    }

    @GetMapping("/checktoken")
    public UtilisateurToken check(@RequestHeader("token") String value){
        UtilisateurToken utilisateurToken=utilisateurTokenService.checkToken(value);
        if(utilisateurToken!=null){
            return utilisateurToken;
        }
        return null;
    }

    @GetMapping("logout")
    public UtilisateurToken logout(@RequestHeader("token") String token){
        UtilisateurToken utilisateurToken=utilisateurTokenService.getValidTokenByToken(token);
        if(utilisateurToken!=null){
            utilisateurTokenService.logout(utilisateurToken);
            return utilisateurToken;
        }
        return null;
    }
}
