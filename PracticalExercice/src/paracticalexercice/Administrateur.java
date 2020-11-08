package paracticalexercice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrateur extends Personne {
 private int identifiant;
 private List <Produit>produitList= new ArrayList<>();
 private List <Utilisateur>utilisateurList= new ArrayList<>();
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

//G�rer les Utilisateurs
public void ajouterUtilisateur(Utilisateur utilisateur) {
		this.utilisateurList.add(utilisateur);
		System.out.println("Utilisateur ajout� avec succ�s");
}
public int rechercherExist(int num) {
	int p=-1;
	for (int i=0;i<this.utilisateurList.size();i++) {
		if(utilisateurList.get(i).getNumero()==num) {
			p=i;
		}
	}
	return p;
}
public void modifierUtilisateur() {
	int num;
	int p;
	Scanner sc = new Scanner(System.in);
	System.out.println("donner le num�ro d'utilisateur � modifier");
	num=sc.nextInt();
	p=rechercherExist(num);
	if(p==-1) {
		System.out.println("Utilisateur introuvable");
	}
	else
	{
		sc=new Scanner(System.in);
		System.out.println("Donner le nouveau CIN");
		utilisateurList.get(p).setCIN(sc.nextInt());
		System.out.println("Donner le nouveau nom");
		utilisateurList.get(p).setNom(sc.next());
		System.out.println("Donner le nouveau prenom");
		utilisateurList.get(p).setPrenom(sc.next());
		System.out.println("Donner le nouveau age");
		utilisateurList.get(p).setAge(sc.nextInt());
		System.out.println("Utilisateur modifi� avec succ�s");
	}
}
public void supprimerUtilisateur() {
	int num;
	int p;
	Scanner sc = new Scanner(System.in);
	System.out.println("donner le num�ro d'utilisateur � supprimer");
	num=sc.nextInt();
	p=rechercherExist(num);
	if(p==-1) {
		System.out.println("Utilisateur introuvable");
	}
	else {
		utilisateurList.remove(p);
		System.out.println("Utilisateur supprim� avec succ�s");
	}
}
public void consulterUtilisateur() {
	if(utilisateurList.size()==0) {System.out.println("il ya aucun utilisateur � afficher");}
	else {
	for (int i=0;i<this.utilisateurList.size();i++) {
		System.out.println(this.utilisateurList.get(i).toString());
	}}
}

//G�rer les Produits

public int rechercherExistproduct(int ref) {
	int p=-1;
	for (int i=0;i<this.produitList.size();i++) {
		if(produitList.get(i).getReference()==ref) {
			p=i;
		}
	}
	return p;
}
public void ajouterProduit(Produit produit) {
	
		this.produitList.add(produit);
		System.out.println("Produit ajout� avec succ�s");
		
}
public void modifierProduit() {
	int ref;
	int p;
	Scanner sc = new Scanner(System.in);
	System.out.println("donner la r�f�rence du produit � modifier");
	ref=sc.nextInt();
	p=rechercherExistproduct(ref);
	if(p==-1) {
		System.out.println("Produit introuvable");
	}
	else
	{
		sc=new Scanner(System.in);
		System.out.println("Donner le nouveau nom du produit");
		produitList.get(p).setNom(sc.next());
		System.out.println("Donner la nouvelle d�signation du produit");
		produitList.get(p).setDesignation(sc.next());
		System.out.println("Donner le nouveau prix du produit");
		produitList.get(p).setPrixUnitaire(sc.nextDouble());
		System.out.println("Produit modifi� avec succ�s");
	}
}

public void supprimerProduit() {
	int ref;
	int p;
	Scanner sc = new Scanner(System.in);
	System.out.println("donner la r�f�rence du produit � supprimer");
	ref=sc.nextInt();
	p=rechercherExistproduct(ref);
	if(p==-1) {
		System.out.println("Produit introuvable");
	}
	else {
		produitList.remove(p);
		System.out.println("Produit supprim� avec succ�s");
	}
}
public void consulterProduit() {
	if(produitList.size()==0) {System.out.println("il ya aucun produit � afficher");}
	else {
	for (int i=0;i<this.produitList.size();i++) {
		System.out.println(this.produitList.get(i).toString());
	}}
}

 
}
