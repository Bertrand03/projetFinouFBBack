package com.projetfinou.backend.repository;

import com.projetfinou.backend.model.HistoriqueQuizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoriqueQuizzRepository extends JpaRepository<HistoriqueQuizz, Integer> {

    HistoriqueQuizz findByName(String name);

    HistoriqueQuizz findByNameAndJoueurId(String name, Integer joueurId);

    @Query (value = " select * from historiquequizz where name = :nom and joueurId = :joueurId", nativeQuery = true)
    HistoriqueQuizz findTest (
            @Param("nom") String nom,
            @Param("joueurId") Integer joueurId
    );

    @Query (value = " select * from historiquequizz where histoQuizzId = :histoQuizzId", nativeQuery = true)
    HistoriqueQuizz findHistoQuizzByHistoQuizzId (
            @Param("histoQuizzId") Integer histoQuizzId
    );

    @Query(value = " SELECT * FROM historiquequizz WHERE joueurId = :joueurId and categorieId = :categoryId" , nativeQuery = true)
    List<HistoriqueQuizz> getLast3Games(
            @Param("joueurId") Integer joueurId,
            @Param("categoryId") Integer categoryId);
}
