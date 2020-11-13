package metier;
import java.util.Scanner;
import java.util.Vector;

import database.MyConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentAchat {
private int numero=0;
private String DateA;
private Utilisateur utilisateur;

public DocumentAchat() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Veuillez saisir le numéro de document d'achat");
	this.numero=sc.nextInt();
	this.DateA ="2020-11-12";
}
public DocumentAchat(int numero, Utilisateur utilisateur, String dateA) {
	this.numero = numero;
	this.utilisateur=utilisateur;
	this.DateA = dateA;
}

public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}

public double calculePTotal()
{ 
	return 0;
}
@Override 
public String toString() {
	return "la commande numéro:\t" + this.numero + "\t la date du commande:\t" + this.DateA + "\t numéro utilisateur: \t" + this.utilisateur.getNumero();
}
public void ajouterDocAchat() {
	String requete;
	requete =  "INSERT INTO bookstore.order VALUES (" +
		    this.numero + "," +
		    this.utilisateur.getNumero() + ",'" + this.DateA + "')";
	try {
		int n = MyConnection.executerRequeteMiseAJour(requete);
		if (n==0)
			System.out.println("Echec d'ajout.");
		else
			System.out.println("Ajout de document achat avec succées.");
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public static Vector<DocumentAchat> getDocAchats(int num) 
{ 
	ResultSet rs;
  Vector<DocumentAchat> listeDocAchat = new Vector<DocumentAchat> ();
  
  String requete = "select * from bookstore.order where numerouser = " + num;
  try {
		rs = MyConnection.executerRequeteConsultation(requete);
		 while(rs.next())
       {
			Utilisateur u = Utilisateur.getUtilisateur(rs.getInt(2));
			listeDocAchat.add(new DocumentAchat(rs.getInt(1),u, rs.getString(3)));                
       }
		 for(int i=0 ; i < listeDocAchat.size() ; i++) {
			 System.out.println(listeDocAchat.get(i).toString());
		 }
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}       
  return listeDocAchat;
}
public static DocumentAchat getDocAchat(int numero) 
{  
	ResultSet rs;
    DocumentAchat DocAchat = null;
  
  String requete = "select * from bookstore.order where numero = " + numero;
  try {
		rs = MyConnection.executerRequeteConsultation(requete);
		if(rs.next())
       {
			Utilisateur u = Utilisateur.getUtilisateur(rs.getInt(2));
			DocAchat = new DocumentAchat(rs.getInt(1),u,rs.getString(3));                
       }
		 
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}       
  return DocAchat;
}



}
