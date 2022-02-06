package com.projetfinou.backend.service;

import com.projetfinou.backend.model.Score;
import com.projetfinou.backend.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getScore() {
        System.out.println("passe dans scoreRepository, getScore()");
        List<Score> score = scoreRepository.findAll();
        return score;
    }

    public Score getScoreJoueurCategorie(Integer joueurId, Integer categorieId) {
        System.out.println("passe dans scoreRepository, getScoreJoueurCategorie()");
        Score scoreJoueurCategorie = scoreRepository.findByJoueurAndCategory(joueurId, categorieId);
        return scoreJoueurCategorie;
    }

    public Score getScoreByCategorieIdAndJoueurId(Integer categorieId, Integer joueurId) {
        System.out.print("passe dans getScoreByCategorieId()");
        Score scoreByCategorieId = scoreRepository.findScoreByCategorieIdAndJoueurId(categorieId, joueurId);
        return scoreByCategorieId;
    }

    public Score modifierScoreCategorie(Score score) {
        System.out.print("passe dans modifierScoreCategorie()");
        return scoreRepository.save(score);
    }

    public Integer getScoreTotalByJoueurId(Integer joueurId) {
        System.out.print("passe dans getScoreTotalByJoueurId()");
        return scoreRepository.getScoreTotalByJoueurIdForAllCategories(joueurId);
    }

}
