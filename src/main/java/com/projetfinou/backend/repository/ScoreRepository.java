package com.projetfinou.backend.repository;

import com.projetfinou.backend.model.HistoriqueQuizz;
import com.projetfinou.backend.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ScoreRepository extends JpaRepository<Score, Integer> {

    @Query(
            value = "SELECT * FROM Score s WHERE s.joueurId = :joueurId AND s.categorieId = :categorieId",
            nativeQuery = true)
    Score findByJoueurAndCategory(
            @Param("joueurId") Integer joueurId,
            @Param("categorieId") Integer categorieId);

    @Query(
            value = "SELECT sum(scoreCategorie) FROM Score s WHERE s.joueurId = :joueurId",
            nativeQuery = true)
    Integer getScoreTotalByJoueurIdForAllCategories(
            @Param("joueurId") Integer joueurId);

    Score findScoreByCategorieIdAndJoueurId(Integer categorieId, Integer joueurId);

    @Query(
            value = "SELECT * FROM HistoriqueQuizz hq WHERE hq.histoQuizzId = (SELECT MAX(histoQuizzId) FROM HistoriqueQuizz)",
            nativeQuery = true)
    Object[] findHistoriqueQuizz();
}
