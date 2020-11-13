package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import metier.Achat;
import metier.Administrateur;
import metier.DocumentAchat;
import metier.Livre;
import metier.Utilisateur;

public class MyConnection {
	private static Connection connection =null;
    
    public MyConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC";
        connection = DriverManager.getConnection(url,"root","root");
    }
    public static int executerRequeteMiseAJour(String requ�te) throws ClassNotFoundException,SQLException {
    	 Statement stmt =null;
    	   
    	    if(connection == null)
    	        {
    	            System.out.println("Probl�me de connexion � la source de donn�es");
    	            return -1;
    	        }
    	        else
    	        {
    	            stmt = connection.createStatement();
    	            return  stmt.executeUpdate(requ�te);
    	        }}
    public static ResultSet executerRequeteConsultation (String requ�te) throws ClassNotFoundException,SQLException{
    	Statement stmt =null;
    	 ResultSet rs;
        if(connection == null)
            {
                System.out.println("Probl�me de connexion � la source de donn�es");
                return null;
            }
            else
            {
                stmt = connection.createStatement();
                rs =  stmt.executeQuery(requ�te);
                
            }
        return rs;
    }
    
   
    }
