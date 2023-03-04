package com.projetfinou.backend.model;


import javax.persistence.*;

@Entity
@Table(name="Joueur", schema = "finoudb")
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column (name = "id")
    private Integer id;

    @Column (name = "pseudo")
    private String pseudo;

    @Column (name = "motDePasse")
    private String motDePasse;

    @Column (name = "score")
    private Integer score;


    public Joueur (Integer id, String pseudo, String motDePasse, Integer score){
        this.id = id;
        this.pseudo = pseudo;
        this.motDePasse = pseudo;
        this.score = score;
    }

    public Joueur() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}


