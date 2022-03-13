package com.projetfinou.backend.model;


import javax.persistence.*;

@Entity
@Table(name="QuizzAnimaux")
public class Quizz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer animauxId;

    private Integer categorieId;

    private String motFrancais;

    private String motAnglais;

    private String motTrouve;

    private Integer tentativeMot;


    public Quizz(Integer animauxId, Integer categorieId, String motFrancais, String motAnglais, String motTrouve, Integer tentativeMot) {
        this.animauxId = animauxId;
        this.categorieId = categorieId;
        this.motFrancais = motFrancais;
        this.motAnglais = motAnglais;
        this.motTrouve = motTrouve;
        this.tentativeMot = tentativeMot;
    }

    public Quizz () {

    }

    public Integer getAnimauxId() {
        return animauxId;
    }

    public void setAnimauxId(Integer animauxId) {
        this.animauxId = animauxId;
    }

    public Integer getCategorieId() { return categorieId; }

    public void setCategorieId(Integer categorieId) { this.categorieId = categorieId; }

    public String getMotFrancais() {
        return motFrancais;
    }

    public void setMotFrancais(String motFrancais) {
        this.motFrancais = motFrancais;
    }

    public String getMotAnglais() {
        return motAnglais;
    }

    public void setMotAnglais(String motAnglais) {
        this.motAnglais = motAnglais;
    }

    public String getMotTrouve() {
        return motTrouve;
    }

    public void setMotTrouve(String motTrouve) {
        this.motTrouve = motTrouve;
    }

    public Integer getTentativeMot() { return tentativeMot; }

    public void setTentativeMot(Integer tentativeMot) { this.tentativeMot = tentativeMot; }
}
