package com.projetfinou.backend.service;


import com.projetfinou.backend.model.CategorieQuizz;
import com.projetfinou.backend.model.Quizz;
import com.projetfinou.backend.repository.CategorieQuizzRepository;
import com.projetfinou.backend.repository.QuizzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class QuizzService {
    @Autowired
    private QuizzRepository quizzRepository;

    //********** AFFICHE TOUTES LES VALEURS **********

    public List<Quizz> getSommaire() {
        List<Quizz> maListe = quizzRepository.findAll();
        return maListe;
    }

    //********** AFFICHE TOUS LES QUIZZ TEMPOREL **********

    public List<Quizz> getQuizzFromCategorieId(Integer categorieId) {
        System.out.println("Back-end - QuizzSservice - Passe dans getQuizzFromCategorieId");
        List<Quizz> listQuizz = quizzRepository.findByCategorieId(categorieId);
        return listQuizz;
    }

    //********** AFFICHE EN FONCTION DE L'ID **********

    public Quizz afficherQuizz(Integer animauxId) {
        Quizz a = quizzRepository.findByAnimauxId(animauxId);
        if (a == null) {
            throw new EntityNotFoundException("Le Quizz avec l'id numéro " + animauxId + " n'existe pas");
        }
        return a;
    }

    //********** AFFICHE EN FONCTION DU MOT FRANCAIS **********

    public List<Quizz> afficherQuizz2(String motFrancais) {
        System.out.println("Passe dans afficheQuizz2");
        List<Quizz> a = quizzRepository.findByMotFrancais(motFrancais);
        {
            if (a == null) {
                throw new EntityNotFoundException("L'artiste avec le nom " + motFrancais + " n'existe pas");
            }
            return a;
        }
    }

    //********** CHERCHE SI LE MOT EST FRANCAIS **********

    public Quizz getQuizzByMot(String motARetrouver) {
        System.out.println("Passe dans getQuizzByMotFrancais");
        Quizz q = quizzRepository.findQuizzByMot(motARetrouver);
        {
            if (q == null) {
                throw new EntityNotFoundException("Le mot avec le nom " + motARetrouver + " n'existe pas");
            }
            return q;
        }
    }

    public Quizz modifierQuizz(Quizz quizz) {
       System.out.println("Passe dans modifierQuizz");
        return quizzRepository.save(quizz);
    }

    public Quizz resetAllMotTrouveService(Quizz quizz) {
        System.out.println("Passe dans resetAllMotTrouveService");
        return quizzRepository.save(quizz);
    }

    public Quizz ajouterAnimal(Quizz quizz) {
        System.out.println("Lancement ajouterAnimal()");
        return quizzRepository.save(quizz);
    }

    public void supprimerMotQuizz(Integer animauxId) {
        System.out.print("passe dans supprimerMotQuizz()");
        quizzRepository.deleteById(animauxId);
    }

}
