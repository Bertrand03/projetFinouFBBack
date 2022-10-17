package com.projetfinou.backend.controllers;


import com.projetfinou.backend.model.HistoriqueQuizz;
import com.projetfinou.backend.model.Quizz;
import com.projetfinou.backend.service.HistoQuizzService;
import com.projetfinou.backend.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = "http://localhost:4200")
@RestController

@RequestMapping(value = "/histoquizzs", method = RequestMethod.GET, produces = "application/json")

public class HistoriqueQuizzController {

    @Autowired
    private HistoQuizzService histoQuizzService;


    @GetMapping(value = "/last3Games/{joueurId}/{categoryId}")
    public List<HistoriqueQuizz> last3Games(
            @PathVariable("joueurId") Integer joueurId,
            @PathVariable("categoryId") Integer categoryId

    ) {
        System.out.println("Dans HistoriqueQuizzController, passe dans méthode last3Games()");
        return histoQuizzService.getLast3Games(joueurId, categoryId);
    }

}

