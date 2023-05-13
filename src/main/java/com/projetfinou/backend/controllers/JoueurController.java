package com.projetfinou.backend.controllers;

import com.projetfinou.backend.model.Joueur;
import com.projetfinou.backend.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin (origins = "http://localhost:4200")
@CrossOrigin (origins = "*")
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
        System.out.println("Lancement ajouterJoueur()");

        return joueurService.ajouterJoueur(joueur);
    }

    @PutMapping(
            value = "/update/{id}")

    public Joueur miseAJourJoueur(
            @PathVariable("id") Integer id,
            @RequestBody Joueur joueur) {
            System.out.println("Passe dans miseAJourJoueur");
            System.out.println("joueurId vaut : " + id);
        return joueurService.modifierJoueur(joueur);
    }
}
