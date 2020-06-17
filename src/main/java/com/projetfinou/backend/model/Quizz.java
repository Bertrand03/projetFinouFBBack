package com.projetfinou.backend.model;


import javax.persistence.*;

@Entity
@Table(name="QuizzAnimaux")
public class Quizz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column (name = "AnimauxId")
    private Integer animauxId;

    @Column (name = "motFrancais")
    private String motFrancais;

    @Column (name = "motAnglais")
    private String motAnglais;

    @Column (name = "motTrouve")
    private String motTrouve;


    public Quizz(Integer animauxId, String motFrancais, String motAnglais, String motTrouve) {
        this.animauxId = animauxId;
        this.motFrancais = motFrancais;
        this.motAnglais = motAnglais;
        this.motTrouve = motTrouve;
    }

    public Quizz () {

    }

    public Integer getAnimauxId() {
        return animauxId;
    }

    public void setAnimauxId(Integer animauxId) {
        this.animauxId = animauxId;
    }

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
}
