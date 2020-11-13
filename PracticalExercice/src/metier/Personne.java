package metier;

import java.util.Scanner;

public class Personne {
private double CIN;
private String nom;
private String prenom;
private int age;
public Personne() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Veuillez saisir le CIN ");
	this.CIN=sc.nextDouble();
	System.out.println("Veuillez saisir le nom ");
	this.nom=sc.next();
	System.out.println("Veuillez saisir le prénom ");
	this.prenom=sc.next();
	System.out.println("Veuillez saisir l'age ");
	this.age=sc.nextInt();
	
}
public Personne(double CIN, String nom, String prenom, int age) {
	this.CIN = CIN;
	this.nom = nom;
	this.prenom = prenom;
	this.age = age;
}
@Override
public String toString() {
	return this.CIN+"\t"+this.nom+"\t"+this.prenom+"\t"+this.age+"\t"; 
}
public double getCIN() {
	return CIN;
}
public void setCIN(double CIN) {
	this.CIN = CIN;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

}
