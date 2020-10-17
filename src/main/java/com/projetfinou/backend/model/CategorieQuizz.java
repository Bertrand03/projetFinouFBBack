package com.projetfinou.backend.model;


import javax.persistence.*;

@Entity
@Table(name="CategorieQuizz")
public class CategorieQuizz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categorieId;

    private String nomCategorie;

    public CategorieQuizz(Integer categorieId, String nomCategorie) {
        this.categorieId = categorieId;
        this.nomCategorie = nomCategorie;
    }

    public CategorieQuizz () {

    }

    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
}
