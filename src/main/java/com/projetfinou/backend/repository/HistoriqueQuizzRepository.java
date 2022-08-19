package com.projetfinou.backend.repository;

import com.projetfinou.backend.model.HistoriqueQuizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HistoriqueQuizzRepository extends JpaRepository<HistoriqueQuizz, Integer> {

    HistoriqueQuizz findByName(String name);

    HistoriqueQuizz findByNameAndJoueurId(String name, Integer joueurId);

    @Query (value = " select * from historiquequizz where name = :nom and joueurId = :joueurId", nativeQuery = true)
    HistoriqueQuizz findTest (
            @Param("nom") String nom,
            @Param("joueurId") Integer joueurId
    );
}
