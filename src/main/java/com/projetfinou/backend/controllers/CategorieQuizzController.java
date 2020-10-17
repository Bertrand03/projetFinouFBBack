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

}
