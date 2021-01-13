package com.projetfinou.backend.controllers;

import com.projetfinou.backend.model.Quizz;
import com.projetfinou.backend.model.Score;
import com.projetfinou.backend.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

@RequestMapping(value = "/score", method = RequestMethod.GET, produces = "application/json")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @RequestMapping(path = "/", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Score> getScore(){
        System.out.println("Lancement getSommaire()");
        return this.scoreService.getScore();
    }

    @GetMapping(
            value = "/{joueurId}/{categorieId}")

    public Score getScoreJoueurCategorie(
            @PathVariable("joueurId") Integer joueurId, @PathVariable("categorieId") Integer categorieId){
        System.out.println("Lancement getScoreJoueurCategorie()");
        return this.scoreService.getScoreJoueurCategorie(joueurId, categorieId);
    }

    @GetMapping(
            value = "/scoreByCategorieId/{categorieId}")

        public Score getScoreByCategorieId(
                @PathVariable("categorieId") Integer categorieId) {
        System.out.println("lance getScoreByCategorieId()");
        return this.scoreService.getScoreByCategorieId(categorieId);
    }

    @PutMapping(
            value = "/updateScore/{joueurId}/{categorieId}")

    public Score miseAJourScoreCategorie(
            @PathVariable("joueurId") Integer joueurId,
            @PathVariable("categorieId") Integer categorieId,
            @RequestBody Score score) {
        System.out.println("Passe dans miseAJourScoreCategorie");
        System.out.println("joueurId vaut : " + joueurId);
        System.out.println("categorieId vaut : " + categorieId);
        return scoreService.modifierScoreCategorie(score);
    }
}
