package metier;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

import database.MyConnection;

public class Livre extends Produit {
private String titre;
private String author;
private String releaseDate;
public Livre(String titre, String author, String releaseDate,double reference, String designation, double prixUnitaire, String type) {
	super(reference,designation,prixUnitaire,type);
	this.titre = titre;
	this.author = author;
	this.releaseDate = releaseDate;
}
public Livre(String titre,double reference, String designation, double prixUnitaire, String type) {
	super(reference,designation,prixUnitaire,type);
	this.titre = titre;
}

public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getReleaseDate() {
	return releaseDate;
}
public void setReleaseDate(String releaseDate) {
	this.releaseDate = releaseDate;
}
@Override
public String toString() {
	return super.toString()+"\t le titre \t"+this.titre+"\t la désignation \t" +this.getDesignation()+"\t l'auteur \t"+this.author + "\t date de réalisation \t" + this.releaseDate + "\t le prix unitaire \t" + this.getPrixUnitaire();
}
//Gérer les livres
public void ajouterLivre() {
	String requete;
	requete =  "INSERT INTO product VALUES(" +
		    this.getReference() + ",'" +
		    this.getDesignation() + "'," + this.getPrixUnitaire()  + ",'" + 
		    this.getType() +  "','" + this.getTitre() + "','" + this.getAuthor()
		    + "', '" + this.getReleaseDate() +"')";
	try {
		int n = MyConnection.executerRequeteMiseAJour(requete);
		if (n==0)
			System.out.println("Echec d'ajout.");
		else
			System.out.println("Ajout du livre avec succées.");
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public void modifierLivre(double ref) {
	
	String requete;
	requete =  "UPDATE product SET pddesignation = '"+
		    this.getDesignation() + "', unitprice = " + this.getPrixUnitaire()  + ", title = '" + 
			this.getTitre() + "', author = '" + this.getAuthor()
		    + "', releasedate = '" + this.getReleaseDate() +"' WHERE reference = " + ref  ;
	try {
		int n =MyConnection.executerRequeteMiseAJour(requete);
		if (n==0)
			System.out.println("Echec de modification.");
		else
			System.out.println("Modification du livre avec succées.");
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public static void supprimerLivre(double ref) {
	String requete;
	requete =  "DELETE from product WHERE reference = " + ref;
	try {
		int n =MyConnection.executerRequeteMiseAJour(requete);
		if (n==0)
			System.out.println("Echec de suppression.");
		else
			System.out.println("suppression du livre avec succées.");
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public static Vector<Livre> getLivres() 
{   ResultSet rs;
  Vector<Livre> listeLivres = new Vector<Livre> ();
  
  String requete = "select * from product where type ='livre' ";
  try {
		rs = MyConnection.executerRequeteConsultation(requete);
		 while(rs.next())
       {
           listeLivres.add(new Livre(rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));                
       }
		 for(int i=0 ; i < listeLivres.size() ; i++) {
			 System.out.println(listeLivres.get(i).toString());
		 }
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}       
  return listeLivres;
}
public static Livre getLivre(double reference) 
{   ResultSet rs;
    Livre livre = null;
  
  String requete = "select * from product where reference = " + reference;
  try {
		rs = MyConnection.executerRequeteConsultation(requete);
		 if(rs.next())
       {
           livre = new Livre(rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(1), rs.getString(2), rs.getDouble(3), rs.getString(4));                
       }
		 return livre;
		 
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		return null;
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}       
  
}

}
