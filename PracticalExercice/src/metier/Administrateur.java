package metier;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import database.MyConnection;

public class Administrateur extends Personne {
 private int identifiant;

public Administrateur() {
	super();
	Scanner sc = new Scanner(System.in);
	System.out.println("veuillez saisir l'identifiant de l'administrateur");
	this.identifiant = sc.nextInt();
}

public Administrateur(double CIN, String nom, String prenom, int age,int identifiant) {
	super(CIN,nom,prenom,age);
	this.identifiant = identifiant;
}
@Override
public String toString() {
	return this.getClass()+":\t"+super.toString()+this.identifiant;
}
public int getIdentifiant() {
	return identifiant;
}

public void setIdentifiant(int identifiant) {
	this.identifiant = identifiant;
}
public void ajouterAdmin(Administrateur admin) {
    String requete;
    requete =  "INSERT INTO utilisateur VALUES(" + admin.getIdentifiant() + "," +
		    admin.getCIN() + ",'" +
		    admin.getNom() + "','" + admin.getPrenom()  + "'," + 
		    admin.getAge()  +")";
	try {
		int n = MyConnection.executerRequeteMiseAJour(requete);
		if (n==0)
			System.out.println("Echec d'ajout.");
		else
			System.out.println("Ajout administrateur avec succées.");
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

}
