package com.projetfinou.backend.controllers;

import com.projetfinou.backend.model.Joueur;
import com.projetfinou.backend.model.Quizz;
import com.projetfinou.backend.service.JoueurService;
import com.projetfinou.backend.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = "http://localhost:4200")
@RestController

@RequestMapping(value = "/joueurs", method = RequestMethod.GET, produces = "application/json")

public class JoueurController {
    @Autowired
    private JoueurService joueurService;

    @RequestMapping(path = "/", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Joueur> getSommaire(){
        System.out.println("Lancement getSommaire de Joueurs()");
        return this.joueurService.getSommaire();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "")

    public Joueur ajouterJoueur (
            @RequestBody Joueur joueur){
        System.out.println("Lancement ajouterAnimal()");

        return joueurService.ajouterJoueur(joueur);
    }
}
