package paracticalexercice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produit {
private double reference;
private String nom;
private String designation;
private double prixUnitaire;
public Produit() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Veillez saisir la référence du produit");
	this.reference= sc.nextDouble();
	System.out.println("Veillez saisir le nom du produit");
	this.nom= sc.next();
	System.out.println("Veillez saisir la désignation du produit");
	this.designation=sc.next();
	System.out.println("Veillez saisir le prix du produit");
	this.prixUnitaire=sc.nextDouble();
}
public Produit(double reference, String nom, String designation, double prixUnitaire) {
	this.reference = reference;
	this.nom = nom;
	this.designation = designation;
	this.prixUnitaire = prixUnitaire;
}

public double getReference() {
	return reference;
}

public void setReference(double reference) {
	this.reference = reference;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public double getPrixUnitaire() {
	return prixUnitaire;
}

public void setPrixUnitaire(double prixUnitaire) {
	this.prixUnitaire = prixUnitaire;
}
@Override
public String toString() {
	return this.reference+"\t"+this.nom+"\t"+this.designation+"\t"+this.prixUnitaire;
}

}
