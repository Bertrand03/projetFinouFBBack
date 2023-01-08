package com.projetfinou.backend;


import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args)throws Exception {

        SpringApplication.run(BackendApplication.class, args);

        // Ce bloc sert à utiliser un script SQL qui va faire des insert en base
        //Getting the connection
//        String mysqlUrl = "jdbc:mysql://localhost:3306/finou?serverTimezone=UTC";
//        Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
//        System.out.println("Connection established......");
//        //Initialize the script runner
//        ScriptRunner sr = new ScriptRunner(con);
//        //Creating a reader object
//        Reader reader = new BufferedReader(new FileReader("C:\\Users\\bertrand.cerot\\IdeaProjects\\projetFinouFB\\script_test.sql"));
//        //Running the script
//        sr.runScript(reader);
    }

}



