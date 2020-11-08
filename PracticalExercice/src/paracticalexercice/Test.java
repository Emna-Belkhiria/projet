package paracticalexercice;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choix;  
	    System.out.println("*************************Menu1**************************");
		System.out.println("Si vous etes un administrateur tapez 1");
		System.out.println("Si vous etes un simple utilisateur tapez 2");
		System.out.println("Si vous voulez quitter quelque soit l'étape tapez 0");
		Scanner sc = new Scanner(System.in);
		 choix = sc.nextInt();
		switch(choix) {
		case 1:
			Administrateur A = new Administrateur(9875461,"admin","admin",50,1234);
			do{System.out.println("veillez saisir votre Identifiant");}
			while(sc.nextInt()!= A.getIdentifiant());
			    System.out.println("*************************Menu2**************************");
				System.out.println("Si Vous voulez gérer les utilisateurs tapez 1 ");
				System.out.println("Si Vous voulez gérer les produits tapez 2 ");
				switch(sc.nextInt()) {
				case 1:
					System.out.println("*************************Menu3**************************");
					System.out.println("Si Vous voulez ajouter un utilisateurs tapez 1 ");
					System.out.println("Si Vous voulez modifier utilisateurs tapez 2 ");
					System.out.println("Si Vous voulez consulter les utilisateurs tapez 3 ");
					System.out.println("Si Vous voulez supprimer les utilisateurs tapez 4 ");
					switch(sc.nextInt()) {
					case 1: 
						Utilisateur u1 = new Utilisateur();
						Utilisateur u2 = new Utilisateur(2587564,"belkhiria","emna",23,1);
						Utilisateur u3 = new Utilisateur(7568423,"belkhiria","emma",22,2);
						A.ajouterUtilisateur(u1);
						A.ajouterUtilisateur(u2);
						A.ajouterUtilisateur(u3);
					case 2: 
						A.modifierUtilisateur();
					case 3: 
						A.consulterUtilisateur();
					case 4: 
						A.supprimerUtilisateur();
					}break;
				case 2:
					System.out.println("*************************Menu3**************************");
					System.out.println("Si Vous voulez ajouter un produit tapez 1 ");
					System.out.println("Si Vous voulez modifier un produit tapez 2 ");
					System.out.println("Si Vous voulez consulter un produit tapez 3 ");
					System.out.println("Si Vous voulez supprimer un produit tapez 4 ");
					switch(sc.nextInt()) {
					case 1: 
						Produit p1 = new Produit();
					    Produit p2 =new Produit(1,"Biscuit","Biscuit Saida",900);
				    	Produit p3 =new Produit(2,"lait","lait demi écrémé",1250);
						A.ajouterProduit(p1);
						A.ajouterProduit(p2);
						A.ajouterProduit(p3);	
					case 2: 
						A.modifierProduit();
					case 3: 
						A.consulterProduit();
					case 4: 
						A.supprimerProduit();
					}
				}
				break;
		case 2:
	        System.out.println("*************************Gérer Commande**************************");
			Utilisateur uti1 = new Utilisateur(2587564,"belkhiria","emna",23,1);
			Utilisateur uti2 = new Utilisateur(7568423,"belkhiria","emma",22,2);
		    Produit pd1 =new Produit(1,"Biscuit","Biscuit Saida",900);
		    Produit pd2 =new Produit(2,"lait","lait demi écrémé",1250);
				
				DocumentAchat dc1 = new DocumentAchat();
				uti1.ajouterDocAchat(dc1);
				Achat a1 =new Achat(250,pd1);
				Achat a2 =new Achat(300,pd2);
				dc1.ajouterAchat(a1);
				dc1.ajouterAchat(a2);
				dc1.afficheDocAchat();
				DocumentAchat dc2 =new DocumentAchat();
				uti2.ajouterDocAchat(dc2);
				Achat a3 =new Achat(500,pd2);
				dc2.ajouterAchat(a3);
				dc2.afficheDocAchat();
				break;
		case 0: System.exit(0);
		break;	
			
		}
	}
	}
