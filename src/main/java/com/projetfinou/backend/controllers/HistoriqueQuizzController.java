package com.projetfinou.backend.controllers;


import com.projetfinou.backend.model.Quizz;
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
    private QuizzService quizzService;



}

