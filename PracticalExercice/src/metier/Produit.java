package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produit {
private double reference;
private String designation;
private double prixUnitaire;
private String type;


public Produit() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Veillez saisir la r�f�rence du produit");
	this.reference= sc.nextDouble();
	System.out.println("Veillez saisir la d�signation du produit");
	this.designation=sc.next();
	System.out.println("Veillez saisir le prix du produit");
	this.prixUnitaire=sc.nextDouble();
	System.out.println("Veillez saisir le type du produit");
	this.type=sc.next();
}
public Produit(double reference, String designation, double prixUnitaire,String type) {
	this.reference = reference;
	this.designation = designation;
	this.prixUnitaire = prixUnitaire;
	this.type = type;
}


public double getReference() {
	return reference;
}


public void setReference(double reference) {
	this.reference = reference;
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
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
@Override
public String toString() {
	return "La r�f�rence \t" + this.reference;
}
//G�rer les Produits

//public int rechercherExistproduct(int ref) {
//	int p=-1;
//	for (int i=0;i<this.produitList.size();i++) {
//		if(produitList.get(i).getReference()==ref) {
//			p=i;
//		}
//	}
//	return p;
//}
//public void ajouterProduit(Produit produit) {
//	
//		this.produitList.add(produit);
//		System.out.println("Produit ajout� avec succ�s");
//		
//}
//public void modifierProduit() {
//	int ref;
//	int p;
//	Scanner sc = new Scanner(System.in);
//	System.out.println("donner la r�f�rence du produit � modifier");
//	ref=sc.nextInt();
//	p=rechercherExistproduct(ref);
//	if(p==-1) {
//		System.out.println("Produit introuvable");
//	}
//	else
//	{
//		sc=new Scanner(System.in);
//		System.out.println("Donner la nouvelle d�signation du produit");
//		produitList.get(p).setDesignation(sc.next());
//		System.out.println("Donner le nouveau prix du produit");
//		produitList.get(p).setPrixUnitaire(sc.nextDouble());
//		System.out.println("Produit modifi� avec succ�s");
//	}
//}
//
//public void supprimerProduit() {
//	int ref;
//	int p;
//	Scanner sc = new Scanner(System.in);
//	System.out.println("donner la r�f�rence du produit � supprimer");
//	ref=sc.nextInt();
//	p=rechercherExistproduct(ref);
//	if(p==-1) {
//		System.out.println("Produit introuvable");
//	}
//	else {
//		produitList.remove(p);
//		System.out.println("Produit supprim� avec succ�s");
//	}
//}
//public void consulterProduit() {
//	if(produitList.size()==0) {System.out.println("il ya aucun produit � afficher");}
//	else {
//	for (int i=0;i<this.produitList.size();i++) {
//		System.out.println(this.produitList.get(i).toString());
//	}}
//}



}
