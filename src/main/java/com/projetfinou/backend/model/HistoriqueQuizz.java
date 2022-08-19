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

    @Lob
    @Column (name = "sauvegarde")
    private byte[] blob;

    @Column (name = "joueurId")
    private Integer joueurId;

    @Column (name = "categorieId")
    private Integer categorieId;


    public HistoriqueQuizz(String name, Date date, Integer scoreId, byte[] blob, Integer joueurId, Integer categorieId) {
        this.name = name;
        this.date = date;
        this.scoreId = scoreId;
        this.blob = blob;
        this.joueurId = joueurId;
        this.categorieId = categorieId;
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

    public byte[] getBlob() {
        return blob;
    }

    public void setBlob(byte[] blob) {
        this.blob = blob;
    }

    public Integer getJoueurId() { return joueurId; }

    public void setJoueurId(Integer joueurId) { this.joueurId = joueurId; }

    public Integer getCategorieId() { return categorieId; }

    public void setCategorieId(Integer categorieId) { this.categorieId = categorieId; }
}


