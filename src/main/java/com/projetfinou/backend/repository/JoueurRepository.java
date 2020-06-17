package com.projetfinou.backend.repository;

import com.projetfinou.backend.model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository <Joueur, Integer> {
}
