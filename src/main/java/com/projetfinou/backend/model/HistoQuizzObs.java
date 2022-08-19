package com.projetfinou.backend.model;


import java.io.Serializable;

public class HistoQuizzObs implements Serializable {

    private String quizzName;
    private Integer joueurId;
    private Integer categorieId;

    public HistoQuizzObs(String quizzName, Integer joueurId, Integer categorieId) {
        this.quizzName = quizzName;
        this.joueurId = joueurId;
        this.categorieId = categorieId;
    }

    public HistoQuizzObs() {

    }

    public String getQuizzName() {
        return quizzName;
    }

    public void setQuizzName(String quizzName) {
        this.quizzName = quizzName;
    }

    public Integer getJoueurId() {
        return joueurId;
    }

    public void setJoueurId(Integer joueurId) {
        this.joueurId = joueurId;
    }

    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }
}
