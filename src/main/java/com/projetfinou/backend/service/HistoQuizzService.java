package com.projetfinou.backend.service;

import com.projetfinou.backend.model.HistoriqueQuizz;
import com.projetfinou.backend.repository.HistoriqueQuizzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoQuizzService {
    @Autowired HistoriqueQuizzRepository historiqueQuizzRepository;

    //********** RECUPERE LES 3 DERNIERES PARTIES SAUVEGARDEES PAR LE JOUEUR PAR CATEGORIE **********
    public List<HistoriqueQuizz> getLast3Games(Integer joueurId, Integer categoryId) {
        List<HistoriqueQuizz> listHistoQ = historiqueQuizzRepository.getLast3Games(joueurId, categoryId);
        System.out.println("listHistoQ vaut : ");
        for (HistoriqueQuizz hq : listHistoQ) {
            System.out.println(hq.getName() + " - " + hq.getCategorieId());
        }
        return listHistoQ;
    }
}
