package com.projetfinou.backend;


import com.projetfinou.backend.controllers.JoueurController;
import com.projetfinou.backend.model.Joueur;
import com.projetfinou.backend.service.JoueurService;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args)throws Exception {

        SpringApplication.run(BackendApplication.class, args);

        // Ce bloc sert à utiliser un script SQL qui va faire des insert en base
        //Getting the connection
//        String mysqlUrl = "jdbc:mysql://localhost:3306/finou?serverTimezone=UTC";
////        Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
//        Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
//        System.out.println("Connection established......");
//        //Initialize the script runner
//        ScriptRunner sr = new ScriptRunner(con);
//        //Creating a reader object
//        Reader reader = new BufferedReader(new FileReader("C:\\Users\\Utilisateur\\IdeaProjects\\script_test.sql"));
//        //Running the script
//        sr.runScript(reader);

    }

}



