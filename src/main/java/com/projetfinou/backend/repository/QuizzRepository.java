package com.projetfinou.backend.repository;

import com.projetfinou.backend.model.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QuizzRepository extends JpaRepository<Quizz, Integer> {
    List<Quizz> findByMotFrancais (@Param("motFrancais") String motFrancais);
    Quizz findByAnimauxId (Integer animauxId);
}
