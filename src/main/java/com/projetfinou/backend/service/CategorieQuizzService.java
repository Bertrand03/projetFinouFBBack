package com.projetfinou.backend.service;

import com.projetfinou.backend.model.CategorieQuizz;
import com.projetfinou.backend.repository.CategorieQuizzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieQuizzService {
    @Autowired
    private CategorieQuizzRepository categorieQuizzRepository;

    public List<CategorieQuizz> getAllEnglishQuizzService() {
        System.out.println("Lancement getAllEnglishService()");
        List<CategorieQuizz> maListeCategorie = categorieQuizzRepository.findAll();
        return maListeCategorie;
    }

}
