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

    public Quizz modifierQuizz(Integer animauxId, Quizz quizz) {
       System.out.println("Passe dans modifierQuizz");
        return quizzRepository.save(quizz);
    }

    public Quizz ajouterAnimal(Quizz quizz) {
        System.out.println("Lancement ajouterAnimal()");
        return quizzRepository.save(quizz);
    }

//    @Override
//    public List<CoursDto> findAllByCategorieId(Integer categorieId) {
//        return this.coursMapper.map(this.coursDao.findAllByCategorie_CategorieId(categorieId));
//    }

//    public Quizz ajouterPseudo(Joueur joueur) {
//        return quizzRepository.save(joueur);
//    }

}
