package metier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import database.MyConnection;

public class Achat {
private int	numLigne=0;
private double quantite;
private Livre livre;
private DocumentAchat docAchat;
private double prixpd;

public Achat(Livre livre,DocumentAchat documentachat) {
	this.numLigne++;
	this.docAchat = documentachat;
	this.livre = livre;
	Scanner sc = new Scanner(System.in);
	System.out.println("Veuillez saisir la quantité du produit");
	this.quantite = sc.nextDouble();	
}

public Achat(int numligne ,double quantite, Livre livre, DocumentAchat docAchat,double prixpd) {
	this.numLigne= numligne;
	this.quantite = quantite;
	this.livre = livre;
	this.docAchat = docAchat;
	this.prixpd = prixpd;
}

public DocumentAchat getDocAchat() {
	return docAchat;
}

public void setDocAchat(DocumentAchat docAchat) {
	this.docAchat = docAchat;
}

public double getQuantite() {
	return quantite;
}
public int getNumLigne() {
	return numLigne;
}

public void setNumLigne(int numLigne) {
	this.numLigne = numLigne;
}

public Livre getProduit() {
	return livre;
}
public void setProduit(Livre livre) {
	this.livre = livre;
}
public void setQuantite(double quantite) {
	this.quantite = quantite;
}
@Override
public String toString() {
	return " \t numéro achat \t"  + this.numLigne + "\t"+ this.livre.toString() + "\t la quantité\t" + this.quantite +"\t le prix total du produit \t" +this.prixpd;
}
public void ajouterAchat() {
	String requete;
	requete =  "INSERT INTO lineorder VALUES(" +
		    this.numLigne + "," +  this.quantite + "," +
		    this.livre.getReference() + "," + this.docAchat.getNumero()  + "," + 
		     (this.livre.getPrixUnitaire()*this.quantite) +")";
	try {
		int n = MyConnection.executerRequeteMiseAJour(requete);
		if (n==0)
			System.out.println("Echec d'ajout.");
		else
			System.out.println("Ajout d' Achat avec succées.");
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public static Vector <Achat> getAchats(int num) 
{ 
	ResultSet rs;
  Vector<Achat> listeAchat = new Vector<Achat> ();
  String requete = "select * from lineorder WHERE numero =  " + num;
  try {
		rs = MyConnection.executerRequeteConsultation(requete);
		 while(rs.next())
       {
			 Livre l = Livre.getLivre(rs.getDouble(3));
			 DocumentAchat da = DocumentAchat.getDocAchat(rs.getInt(4));
			 
			 listeAchat.add(new Achat(rs.getInt(1), rs.getDouble(2),l,da,rs.getDouble(5)));                
       }
		 for(int i=0 ; i < listeAchat.size() ; i++) {
			 System.out.println(listeAchat.get(i).toString());
		 }
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}       
  return listeAchat;
}
public static int getnbAchat(int num) {
	int nombre=0;
	ResultSet rs;
	String requete;
	requete="select count(*) from lineorder WHERE numero = " + num;
	 try {
			rs = MyConnection.executerRequeteConsultation(requete);
			 while(rs.next())
		       {
					nombre = rs.getInt(1); 
		       }
	 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}       
	  return nombre;
	
}
public static double calcultotal(Vector<Achat> listeAchat) {
	double total=0;
	for (int i = 0 ; i<listeAchat.size();i++) {
		total = total + listeAchat.get(i).prixpd;
	}
	return total;
}
}

