package com.projetfinou.backend.service;


import com.projetfinou.backend.model.CategorieQuizz;
import com.projetfinou.backend.model.Quizz;
import com.projetfinou.backend.repository.CategorieQuizzRepository;
import com.projetfinou.backend.repository.QuizzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizzService extends IOException {
    @Autowired
    private QuizzRepository quizzRepository;

    //********** AFFICHE TOUTES LES VALEURS **********

    public List<Quizz> getSommaire() {
        List<Quizz> maListe = quizzRepository.findAll();
        return maListe;
    }

    //********** AFFICHE TOUS LES QUIZZ TEMPOREL **********

    public List<Quizz> getQuizzFromCategorieId(Integer categorieId) {
        System.out.println("Back-end - QuizzSservice - Passe dans getQuizzFromCategorieId");
        List<Quizz> listQuizz = quizzRepository.findByCategorieId(categorieId);
        return listQuizz;
    }

    //********** AFFICHE LE NOMBRE TOTAL DE TENTATIVES PAR CATEGORIE **********

    public Integer getNumberOfTriesByCategorieIdcategorieId(Integer categorieId) {
        System.out.println("Back-end - QuizzSservice - Passe dans getNumberOfTriesByCategorieIdcategorieId");
        Integer numberOrTriesByCategoryId = quizzRepository.getNumberOfTriesByCategoryId(categorieId);
        return numberOrTriesByCategoryId;
    }

    //********** AFFICHE EN FONCTION DE L'ID **********

    public Quizz getQuizzWordService(Integer animauxId) {
        Quizz a = quizzRepository.findByAnimauxId(animauxId);
        if (a == null) {
            throw new EntityNotFoundException("Le Quizz avec l'id numéro " + animauxId + " n'existe pas");
        }
        return a;
    }

    //********** AFFICHE LES MOTS EN ERREURS **********

    public Quizz[] getQuizzWordWithErrors() {
        Quizz[] a = quizzRepository.getWordsWithErrors();
        if (a == null) {
            throw new EntityNotFoundException("Problème dans la requête de la méthode getWordsWithErrors()");
        }
        return a;
    }

    //********** AFFICHE EN FONCTION DU MOT FRANCAIS **********

    public List<Quizz> afficherQuizz2(String motFrancais) {
        System.out.println("Passe dans afficheQuizz2");
        List<Quizz> a = quizzRepository.findByMotFrancais(motFrancais);
        {
            if (a == null) {
                throw new EntityNotFoundException("L'artiste avec le nom " + motFrancais + " n'existe pas");
            }
            return a;
        }
    }

    //********** RECUPERE TOUTES LES DONNEES D'UN QUIZZ **********

    public List<Quizz> getAllQuizzData(Integer playerSelected, Integer categoryQuizzSelected) {
        System.out.println("Passe dans getAllQuizzData()");
        List<Quizz> a = quizzRepository.findByJoueurIdAndCategoryQuizzId(playerSelected, categoryQuizzSelected);
        {
//            if (a == null) {
//                throw new EntityNotFoundException("L'artiste avec le nom " + motFrancais + " n'existe pas");
//            }
            return a;
        }
    }

    //********** AFFICHE EN FONCTION DU MOT FRANCAIS OU ANGLAIS **********

    public List<Quizz> findFrenchOrEnglishWordByName(String word) {
        System.out.println("Passe dans findFrenchOrEnglishWordByName()");
        List<Quizz> a = quizzRepository.findByMotFrancais(word);
        List<Quizz> b = quizzRepository.findByMotAnglais(word);

        if (a == null && b == null) {
            throw new EntityNotFoundException("L'artiste avec le nom " + word + " n'existe pas");
        }

        for (Quizz quizz: b) {
            // Contrôle si un mot en Anglais est le même qu'en Français, si oui on ne fait rien
            if (!quizz.getMotAnglais().equals(quizz.getMotFrancais())) {
                a.add(quizz);
                System.out.println("Ajoute " + quizz + " du tableau b dans mon tableau a");
            }
        }
        System.out.println("a vaut " + a);

        return a;
    }

    //********** CHERCHE SI LE MOT EST FRANCAIS **********

    public Quizz getQuizzByMot(String motARetrouver) {
        System.out.println("Passe dans getQuizzByMotFrancais");
        Quizz q = quizzRepository.findQuizzByMot(motARetrouver);
        {
            if (q == null) {
                throw new EntityNotFoundException("Le mot avec le nom " + motARetrouver + " n'existe pas");
            }
            return q;
        }
    }

    public Quizz modifierQuizz(Quizz quizz) {
       System.out.println("Passe dans modifierQuizz");
        return quizzRepository.save(quizz);
    }

    public Quizz resetAllMotTrouveService(Quizz quizz) {
        System.out.println("Passe dans resetAllMotTrouveService");
        return quizzRepository.save(quizz);
    }

    public List<Quizz> saveQuizz(List<Quizz> listQuizz, String quizzName) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("nom du fichier : " + quizzName);
        try {
//            FileOutputStream fos = new FileOutputStream(dtf.format(now) + ".ser");
            FileOutputStream fos = new FileOutputStream(quizzName + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listQuizz);
            System.out.println("Ecriture de ma liste de quizz ok");
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Quizz> deserialize( String nameFileToDeserialize) {
        System.out.print("passe dans deserialize()");
        List<Quizz> listQuizz = new ArrayList<Quizz>();
        try {
//            FileInputStream fis = new FileInputStream("monFichier.ser");
            FileInputStream fis = new FileInputStream(nameFileToDeserialize +".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listQuizz = (List<Quizz>) ois.readObject();
            System.out.println(listQuizz);
            ois.close();
            fis.close();
//            return listQuizz;
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listQuizz;
    }

    public Quizz ajouterAnimal(Quizz quizz) {
        System.out.println("Lancement ajouterAnimal()");
        Quizz q1 = new Quizz(500, 0, "tata", "tata", "non", 0 );
        Quizz q2 = new Quizz(501, 0, "tutu", "tutu", "oui", 2 );
        // TODO Refaire une méthode pour simplement ajouter un mot quizz en base. Et refaire une autre méthode pour alimenter le fichier sérialisé avec plusieurs quizz
//        List<Quizz> maListe = new ArrayList<Quizz>();
//        maListe.add(q1);
//        maListe.add(q2);

            try {
                FileOutputStream fos = new FileOutputStream("monFichier.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(q1);
                System.out.println("Ecriture ok");
                System.out.println(q1.toString());
                oos.writeObject(q2);
                System.out.println("Ecriture ok");
                System.out.println(q2.toString());
//                    return quizzRepository.save(quizz);

                oos.close();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
        }



    public void supprimerMotQuizz(Integer animauxId) {
        System.out.print("passe dans supprimerMotQuizz()");
        quizzRepository.deleteById(animauxId);
    }



}
