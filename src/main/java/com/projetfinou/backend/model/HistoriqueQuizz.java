package com.projetfinou.backend.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="HistoriqueQuizz")
public class HistoriqueQuizz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column (name = "histoQuizzId")
    private Integer histoQuizzId;

    @Column (name = "name")
    private String name;

    @Column (name = "date")
    private Date date;

    @Column (name = "scoreId")
    private Integer scoreId;

    private Integer animauxId;


    public HistoriqueQuizz(Integer histoQuizzId, String name, Date date, Integer scoreId){
        this.histoQuizzId = histoQuizzId;
        this.name = name;
        this.date = date;
        this.scoreId = scoreId;
    }

    public HistoriqueQuizz() {}

    public Integer getHistoQuizzId() {
        return histoQuizzId;
    }

    public void setHistoQuizzId(Integer histoQuizzId) {
        this.histoQuizzId = histoQuizzId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getAnimauxId() {
        return animauxId;
    }

    public void setAnimauxId(Integer animauxId) {
        this.animauxId = animauxId;
    }
}


