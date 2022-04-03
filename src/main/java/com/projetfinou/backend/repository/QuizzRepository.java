package com.projetfinou.backend.repository;

import com.projetfinou.backend.model.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizzRepository extends JpaRepository<Quizz, Integer> {
    List<Quizz> findByMotFrancais(@Param("motFrancais") String motFrancais);
    List<Quizz> findByMotAnglais(@Param("motAnglais") String motAnglais);


    List<Quizz> findByCategorieId(Integer categorieId);

    Quizz findByAnimauxId(Integer animauxId);

    @Query (value = "select * from quizzanimaux where motFrancais = :motARetrouver or motAnglais = :motARetrouver",
            nativeQuery = true)
    Quizz findQuizzByMot (
            @Param("motARetrouver") String motARetrouver
    );


    @Query (value = "select sum(tentativeMot) from quizzanimaux where quizzanimaux.categorieId = :categoryId ",
            nativeQuery = true)
    Integer getNumberOfTriesByCategoryId (
            @Param("categoryId") Integer categoryId
    );

    @Query (value = "select * from quizzanimaux " +
            "where quizzanimaux.tentativeMot IS NOT NULL " +
            "and quizzanimaux.tentativeMot > 1",
            nativeQuery = true)
    Quizz[] getWordsWithErrors ();

    @Query(value = "select * " +
            "from quizzanimaux q " +
            "join score s on q.categorieId = s.categorieId " +
            "and s.joueurId = :playerSelected " +
            "and q.categorieId = :categoryQuizzSelected",
    nativeQuery = true)
    List<Quizz> findByJoueurIdAndCategoryQuizzId(@Param("playerSelected") Integer playerSelected,
                                                 @Param("categoryQuizzSelected") Integer categoryQuizzSelected);
}
