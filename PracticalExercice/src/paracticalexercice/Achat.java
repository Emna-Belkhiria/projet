package paracticalexercice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Achat {
private int	numLigne=0;
private double quantite;
private Produit produit;

public Achat(Produit produit,DocumentAchat documentachat) {
	this.numLigne++;
	Scanner sc = new Scanner(System.in);
	this.produit = produit;
	System.out.println("Veuillez saisir la quantité du produit");
	this.quantite = sc.nextDouble();
}

public Achat(double quantite, Produit produit) {
	this.numLigne++;
	this.quantite = quantite;
	this.produit = produit;
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

public Produit getProduit() {
	return produit;
}
public void setProduit(Produit produit) {
	this.produit = produit;
}
public void setQuantite(double quantite) {
	this.quantite = quantite;
}
public double calculePTProduit(double prix,double qte) {
	return prix*qte;
}

@Override
public String toString() {
	return "l'achat numéro" + this.numLigne + this.produit + this.quantite + this.calculePTProduit(this.produit.getPrixUnitaire(), this.quantite);
}
}

