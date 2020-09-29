package com.projetfinou.backend.controllers;


import com.projetfinou.backend.model.Quizz;
import com.projetfinou.backend.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = "http://localhost:4200")
@RestController

@RequestMapping(value = "/quizzs", method = RequestMethod.GET, produces = "application/json")

public class QuizzController {
    @Autowired
    private QuizzService quizzService;

    @RequestMapping(path = "/", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Quizz> getSommaire(){
        System.out.println("Lancement getSommaire()");
        return this.quizzService.getSommaire();
    }

    @GetMapping(
            value = "/{id}")

    public Quizz afficherQuizz(
            @PathVariable("id") Integer animauxId) {
        System.out.println("Lancement afficherQuizz()");
        return this.quizzService.afficherQuizz(animauxId);
    }

    @PutMapping(
            value = "/update/{id}")

    public Quizz miseAJour(
            @PathVariable("id") Integer animauxId,
            @RequestBody Quizz quizz) {
            System.out.println("Passe dans miseAJour");
            System.out.println("animauxId vaut : " + animauxId);
        return quizzService.modifierQuizz(animauxId, quizz);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            params = "name")

    public List<Quizz> afficherQuizz2(
        @RequestParam(value = "name") String motFrancais) {
        System.out.println("Lancement afficherQuizz2()");
        return this.quizzService.afficherQuizz2 (motFrancais);
    }



    @RequestMapping(
            method = RequestMethod.POST,
            value = "")

    public Quizz ajouterAnimal (
            @RequestBody Quizz quizz){
        System.out.println("Lancement ajouterAnimal()");

        return quizzService.ajouterAnimal(quizz);
    }

}

