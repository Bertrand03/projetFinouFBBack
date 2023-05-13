package com.projetfinou.backend.service;

import com.projetfinou.backend.model.Joueur;
import com.projetfinou.backend.model.Quizz;
import com.projetfinou.backend.repository.JoueurRepository;
import com.projetfinou.backend.repository.QuizzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
public class JoueurService {
    @Autowired
    private JoueurRepository joueurRepository;

    //********** AFFICHE TOUTES LES VALEURS **********

    public List<Joueur> getSommaire() {
        //List<Joueur> maListe = joueurRepository.findAll();
//        return maListe;
        Joueur a = new Joueur(98, "toto", "mdp1", 10) ;
        Joueur b = new Joueur(99, "tata", "mdp2", 20) ;
        Joueur c = new Joueur(1, "p1", "p1", 8) ;
        List<Joueur> listeJoueurs = new ArrayList<Joueur>();
        listeJoueurs.add(a);
        listeJoueurs.add(b);
        listeJoueurs.add(c);
        return listeJoueurs ;
    }


    public Joueur ajouterJoueur(Joueur joueur) {
        System.out.println("Lancement ajouterAnimal()");
        return joueurRepository.save(joueur);
    }

    public Joueur modifierJoueur(Joueur joueur) {
        System.out.println("Lancement modifierJoueur");
        return joueurRepository.save(joueur);
    }

}


