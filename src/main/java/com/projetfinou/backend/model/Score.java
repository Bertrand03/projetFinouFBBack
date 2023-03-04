package com.projetfinou.backend.model;


import javax.persistence.*;

@Entity
@Table(name = "Score", schema = "finoudb")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer scoreId;

    private Integer joueurId;

    private Integer categorieId;

    private Integer scoreGlobal;

    private Integer scoreCategorie;

    private Integer nbTentatives;

    public Score (){}

    public Score(Integer joueurId, Integer categorieId, Integer scoreGlobal, Integer scoreCategorie, Integer nbTentatives) {
        this.joueurId = joueurId;
        this.categorieId = categorieId;
        this.scoreGlobal = scoreGlobal;
        this.scoreCategorie = scoreCategorie;
        this.nbTentatives = nbTentatives;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
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

    public Integer getScoreGlobal() {
        return scoreGlobal;
    }

    public void setScoreGlobal(Integer scoreGlobal) {
        this.scoreGlobal = scoreGlobal;
    }

    public Integer getScoreCategorie() {
        return scoreCategorie;
    }

    public void setScoreCategorie(Integer scoreCategorie) {
        this.scoreCategorie = scoreCategorie;
    }

    public Integer getNbTentatives() {
        return nbTentatives;
    }

    public void setNbTentatives(Integer nbTentatives) {
        this.nbTentatives = nbTentatives;
    }

}
