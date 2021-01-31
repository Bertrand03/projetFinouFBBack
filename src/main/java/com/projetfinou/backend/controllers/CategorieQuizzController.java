package com.projetfinou.backend.controllers;

import com.projetfinou.backend.model.CategorieQuizz;
import com.projetfinou.backend.service.CategorieQuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController

@RequestMapping(value = "/trouve-anglais", method = RequestMethod.GET, produces = "application/json")

public class CategorieQuizzController {
    @Autowired
    private CategorieQuizzService categorieQuizzService;

    @RequestMapping(path = "/", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategorieQuizz> getAllEnglishQuizz(){
        System.out.println("Lancement getAllEnglishQuizz()");
        return this.categorieQuizzService.getAllEnglishQuizzService();
    }

    @RequestMapping(path = "/categories-quizzs",
            produces = "application/json; charset=UTF-8",
            method = RequestMethod.GET)
    public List<CategorieQuizz> getAllCategoriesQuizzs() {
        System.out.println("Lance getAllCategorieQuizz");
        return categorieQuizzService.getAllCategoriesQuizzsService();
    }

    @RequestMapping(path = "/categorie-quizz/{categorieId}",
                    produces = "application/json; charset=UTF-8",
                    method = RequestMethod.GET)

    public CategorieQuizz getCategorieQuizzById(
            @PathVariable(value = "categorieId") Integer categorieId) {
                System.out.println("Lance getCategorieQuizzById()");
                return this.categorieQuizzService.getCategorieQuizzByIdService(categorieId);
    }
}
