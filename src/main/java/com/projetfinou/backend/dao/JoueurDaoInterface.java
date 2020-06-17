package com.projetfinou.backend.dao;


import com.projetfinou.backend.model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// C'est ce Repository qui va nous indiquer les méthodes qui permettront de manipuler les données dans la BDD
public interface JoueurDaoInterface extends JpaRepository<Joueur, Integer>{ //JpaRepository permet d'accéder à un certain nombre de méthodes déja prédéfinies
    Joueur findById(int id); //Ici le findBy est une commande déjà connue de JpaRepository, on lui indique qu'ici la colonne concernée est Id.
}
