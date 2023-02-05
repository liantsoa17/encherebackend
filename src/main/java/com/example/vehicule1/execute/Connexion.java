package com.example.vehicule1.execute;


import java.sql.Connection;
import java.sql.DriverManager;
public class Connexion {
    private Connection connection;
    public Connexion(){}
    public Connection getconnect()
    {
        try{
            Class.forName("org.postgresql.Driver");
            connection=DriverManager.getConnection("jdbc:postgresql://containers-us-west-133.railway.app:7816/railway","postgres","ZzrqsXOVSYprINJwIDYL");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
