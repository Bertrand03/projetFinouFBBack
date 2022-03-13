package com.projetfinou.backend.controllers;


import com.projetfinou.backend.model.Quizz;
import com.projetfinou.backend.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // GET
    @GetMapping(
            value = "/wordId/{id}")

    public Quizz getQuizzWord(
            @PathVariable("id") Integer animauxId) {
        System.out.println("Lancement getQuizzWord()");
        return this.quizzService.getQuizzWordService(animauxId);
    }

    @GetMapping(value = "/name/{name}")
    public List<Quizz>listOfWordByName(
        @PathVariable("name") String name) {
        System.out.println("Lancement listOfWordByName()");
        return this.quizzService.findFrenchOrEnglishWordByName(name);
    }


    @GetMapping(
            value = "/categorie/{categorieId}")

    public List<Quizz> displayQuizzFromCategorieId(
            @PathVariable("categorieId") Integer categorieId) {
        System.out.println("Lancement displayQuizzFromCategorieId()");
        return this.quizzService.getQuizzFromCategorieId(categorieId);
    }

    //********** CHERCHE SI LE MOT EST FRANCAIS **********

    @GetMapping(
            value = "/motARetrouver/{motARetrouver}"
    )

    public Quizz motFrancaisARetrouver(
            @PathVariable("motARetrouver") String motARetrouver) {
        System.out.println("Lancement motFrancaisARetrouver()");
        return this.quizzService.getQuizzByMot(motARetrouver);
    }

    @RequestMapping(path = "/trouve-anglais",
            produces = "application/json; charset=UTF-8",
            method = RequestMethod.GET)

    public List<Quizz> displayAllEnglishQuizz() {
        System.out.println("Lancement displayAllEnglishQuizz()");
        return this.quizzService.getSommaire();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "name")

    public List<Quizz> afficherQuizz2(
            @RequestParam(value = "name") String motFrancais) {
        System.out.println("Lancement afficherQuizz2()");
        return this.quizzService.afficherQuizz2 (motFrancais);
    }

    @GetMapping(
            value = "/triesByCategoryId/{categorieId}")

    public Integer displayNumberOfTriesByCategorieId(
            @PathVariable("categorieId") Integer categorieId) {
        System.out.println("Lancement displayNumberOfTriesByCategorieId()");
        return this.quizzService.getNumberOfTriesByCategorieIdcategorieId(categorieId);
    }


    // PUT
    @PutMapping(
            value = "/update/{id}")

    public Quizz miseAJour(
            @PathVariable("id") Integer animauxId,
            @RequestBody Quizz quizz) {
            System.out.println("Passe dans miseAJour");
            System.out.println("animauxId vaut : " + animauxId);
        return quizzService.modifierQuizz(quizz);
    }

    @PutMapping(
            value = "/update/reset")

    public Quizz resetAllMotTrouve(
            @RequestBody Quizz quizz) {
        System.out.println("Passe dans resetAllMotTrouve");
        return quizzService.resetAllMotTrouveService(quizz);
    }

    // POST
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/addWord")

    public Quizz ajouterAnimal (
            @RequestBody Quizz quizz){
        System.out.println("Lancement ajouterAnimal()");

        return quizzService.ajouterAnimal(quizz);
    }

    //DELETE
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/delete/{animauxId}")
    @ResponseStatus (value = HttpStatus.NO_CONTENT)

    public @ResponseBody void supprimerMotQuizz(
            @PathVariable("animauxId") Integer animauxId){
        System.out.println("Passe dans supprimerMotQuizz()");
        quizzService.supprimerMotQuizz(animauxId);
    }

}

