package com.projetfinou.backend.repository;

import com.projetfinou.backend.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ScoreRepository extends JpaRepository<Score, Integer> {

    @Query(
            value = "SELECT * FROM Score s WHERE s.joueurId = :joueurId AND s.categorieId = :categorieId",
            nativeQuery = true)
    Score findByJoueurAndCategory(
            @Param("joueurId") Integer joueurId,
            @Param("categorieId") Integer categorieId);

    Score findScoreByCategorieId(Integer categorieId);
}
