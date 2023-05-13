package com.projetfinou.backend.controllers;


import com.projetfinou.backend.model.HistoQuizzObs;
import com.projetfinou.backend.model.HistoriqueQuizz;
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

    @GetMapping(
            value = "/wordsError")

    public Quizz[] getQuizzWordWithErrors() {
        System.out.println("Lancement getQuizzWordWithErrors()");
        return this.quizzService.getQuizzWordWithErrors();
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

    @GetMapping(value = "/deserialize/{nameFileToDeserialize}/{joueurId}")

    public List<Quizz> deserialize(
            @PathVariable("nameFileToDeserialize") String nameFileToDeserialize,
            @PathVariable("joueurId") Integer joueurId) {
        System.out.println("Lancement deserialize()");
        return this.quizzService.deserialize(nameFileToDeserialize, joueurId);
    }

    @GetMapping(value = "/deserializeHistoQuizz/{nameFileToDeserialize}/{joueurId}")

    public List<Quizz> deserializeHistoQuizz(
            @PathVariable("nameFileToDeserialize") String nameFileToDeserialize,
            @PathVariable("joueurId") Integer joueurId){
        System.out.println("Lancement deserializeHistoQuizz()");
        return this.quizzService.retrieveQuizzByHistoriqueQuizz(nameFileToDeserialize, joueurId);
    }

    @GetMapping(value = "/deserializeHistoQuizz/{histoQuizzId}")

    public List<Quizz> deserializeHistoQuizzByHistoQuizzId(
            @PathVariable("histoQuizzId") Integer histoQuizzId) {
        System.out.println("Lancement deserializeHistoQuizzByHistoQuizzId()");
        return this.quizzService.retrieveQuizzByHistoQuizzId(histoQuizzId);
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

    @GetMapping(value = "/allQuizzData/{playerSelected}/{categoryQuizzSelected}")
    public List<Quizz> getAllQuizzData(
            @PathVariable("playerSelected") Integer playerSelected,
            @PathVariable("categoryQuizzSelected") Integer categoryQuizzSelected) {
        System.out.println("Lancement getAllQuizzData()");

        return quizzService.getAllQuizzData(playerSelected, categoryQuizzSelected);
    }

    @GetMapping(value = "/getNewQuizz/{categoryQuizzSelected}")
    public List<Quizz> getANewQuizz(
            @PathVariable("categoryQuizzSelected") Integer categoryQuizzSelected) {
        System.out.println("Lancement getANewQuizz()");
        return quizzService.getANewQuizz(categoryQuizzSelected);
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

    // v2
    @PostMapping(value = "/saveQuizz")
    public void saveQuizzV2 (
            @RequestBody Object hqb) {
        System.out.println("Lancement saveQuizzV2 avec hqb");
        System.out.println(hqb);
        quizzService.saveQuizzV2(hqb);
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

