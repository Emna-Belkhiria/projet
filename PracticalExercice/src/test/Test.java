package test;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import database.MyConnection;
import metier.Achat;
import metier.DocumentAchat;
import metier.Livre;
import metier.Utilisateur;

public class Test {
	
	public static void addUser() {
	    Utilisateur utilisateur = new Utilisateur();
		utilisateur.ajouterUtilisateur();
	}
	public static void updateUser() {
		    Scanner sc = new Scanner(System.in);
		    System.out.println("donner le numéro d'utilisateur à modifier");
		    int num=sc.nextInt();
			System.out.println("Donner le nouveau CIN");
			double cin = sc.nextDouble();
			System.out.println("Donner le nouveau nom");
			String nom = sc.next();
			System.out.println("Donner le nouveau prenom");
			String prenom =sc.next();
			System.out.println("Donner le nouveau age");
			int age = sc.nextInt();
			Utilisateur utilisateur = new Utilisateur(cin,nom,prenom,age,num);
		    utilisateur.modifierUtilisateur(num);
	}
	public static void deleteUser() {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("donner le numéro d'utilisateur à supprimer");
		num=sc.nextInt();
		Utilisateur.supprimerUtilisateur(num);
	}
	public static void addBook() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Donner la référence du livre");
		double ref = sc.nextDouble();
		System.out.println("Donner le titre du livre");
		String titre = sc.next();
		System.out.println("Donner la désignation du livre");
		String designation =sc.next();
		System.out.println("Donner l'auteur du livre");
		String auteur =sc.next();
		System.out.println("Donner la date de réalisation du livre");
		String dateR = sc.next();
		System.out.println("Donner le prix du livre");
		double prix = sc.nextDouble();
	    Livre livre = new Livre(titre,auteur,dateR,ref,designation,prix,"livre");
		livre.ajouterLivre();
	}
	public static void updateBook() {
		double ref;
		Scanner sc = new Scanner(System.in);
		System.out.println("donner la référence du produit à modifier");
		ref=sc.nextDouble();
		System.out.println("Donner le nouveau titre");
		String titre = sc.next();
		System.out.println("Donner la nouvelle désignation");
		String designation = sc.next();
		System.out.println("Donner le nouveau auteur");
		String auteur =sc.next();
		System.out.println("Donner le nouveau date de réalisation ");
		String dateR = sc.next();
		System.out.println("Donner le nouveau prix ");
		double prix = sc.nextDouble();
		Livre livre = new Livre(titre,auteur,dateR,ref,designation,prix,"livre");
		livre.modifierLivre(ref);
}
	public static void deleteBook() {
		double ref;
		Scanner sc = new Scanner(System.in);
		System.out.println("donner la référence du livre à supprimer");
		ref=sc.nextDouble();
		Livre.supprimerLivre(ref);
	}
	public static void addorder() {
		int choix;
		Utilisateur.getUtilisateurs();
		Scanner sc = new Scanner(System.in);
		System.out.println("donner le numéro du commande");
		int num = sc.nextInt();
		System.out.println("donner le numéro d'utilisateur qui va passer cette commande");
		int numutilisateur=sc.nextInt();
		Utilisateur uti1 = Utilisateur.getUtilisateur(numutilisateur);
		System.out.println("donner la date du commande du format yyyy-mm-dd");
		String datecommande =sc.next();
		DocumentAchat docAchat = new DocumentAchat(num,uti1,datecommande);
		docAchat.ajouterDocAchat();
		do {
		Livre.getLivres();
		System.out.println("donner le numéro du livre que vous souhaite commandé");
		double ref=sc.nextDouble();
		Livre livre = Livre.getLivre(ref);
		int numAchat = Achat.getnbAchat(docAchat.getNumero()) + 1;
		System.out.println("donner le nombre du livre que vous souhaite commandé");
		double qt=sc.nextDouble();
		Achat achat = new Achat(numAchat,qt,livre,docAchat,0);
		achat.ajouterAchat();
		System.out.println("si vous voulez finir votre commande saisir 0");
	    choix =sc.nextInt();
		}
		while(choix!=0);
	}
	public static void getorder() {
		Utilisateur.getUtilisateurs();
		Scanner sc = new Scanner(System.in);
		System.out.println("donner le numéro d'utilisateur qui vous voulez afficher ces commandes");
		int numutilisateur = sc.nextInt();
		DocumentAchat.getDocAchats(numutilisateur);
		System.out.println("donner le numéro de commande que vous voulez consulter");
		int numcommande = sc.nextInt();
		DocumentAchat docAchat = DocumentAchat.getDocAchat(numcommande);
		System.out.println(docAchat.toString());
		Vector<Achat> listeAchat = Achat.getAchats(numcommande);
		System.out.println("Le prix total de cette commande est:"+Achat.calcultotal(listeAchat));
		
		
	}
	
	
	
	
	 public static void main(String[] args) {
	        try {
	        	//On se comporte comme etant un administrateur
	        	System.out.println("*** Menu Administrateur ***");
	        	System.out.println("1. Ajouter un utilisateur");
	        	System.out.println("2. Modifier un utilisateur");
	        	System.out.println("3. Supprimer un utilisateur");
	        	System.out.println("4. Afficher l'ensemble des utilisateurs");
	        	System.out.println("5. Ajouter un livre");
	        	System.out.println("6. Modifier un livre");
	        	System.out.println("7. Supprimer un livre");
	        	System.out.println("8. Afficher l'ensemble des livres");
	        	System.out.println("9. Ajouter une commande"); 
	        	System.out.println("10. Afficher les commandes");
	        	Scanner sc = new Scanner(System.in);
	        	System.out.println("Taper votre choix:");
	        	int choix = sc.nextInt();
	        	new MyConnection();
	        	switch(choix) {
	        	case 1:Test.addUser();
	        		break;
	        	case 2:Test.updateUser();
	        		break;
	        	case 3:Test.deleteUser();
	        		break;
	        	case 4:Utilisateur.getUtilisateurs();
	        		break;
	        	case 5:Test.addBook();
	        		break;
	        	case 6:Test.updateBook();
	        		break;
	        	case 7:Test.deleteBook();
	        		break;
	        	case 8:Livre.getLivres();
	        		break;
	        	case 9:Test.addorder();
	        		break;
	        	case 10:Test.getorder();
	        		break;
	        	}	
	            
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
	}
