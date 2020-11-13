package metier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import database.MyConnection;

import java.util.List;
public class Utilisateur extends Personne {
	private int numero;
	
	public Utilisateur(double CIN, String nom, String prenom, int age,int numero) {
		super(CIN,nom,prenom,age);
		this.numero = numero;
	}
	public Utilisateur() {
		super();
		Scanner sc = new Scanner(System.in);
		System.out.println("veuillez saisir le numéro d'utilisateur");
		this.numero = sc.nextInt();
		}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return this.getClass()+":\t"+super.toString()+this.numero;
	}
	//Gérer les Utilisateurs
	public void ajouterUtilisateur() {
		    String requete;
		    requete =  "INSERT INTO utilisateur VALUES(" + this.getNumero() + "," +
				    this.getCIN() + ",'" +
				    this.getNom() + "','" + this.getPrenom()  + "'," + 
				    this.getAge()  +")";
			try {
				int n = MyConnection.executerRequeteMiseAJour(requete);
				if (n==0)
					System.out.println("Echec d'ajout.");
				else
					System.out.println("Ajout d'utilisateur avec succées.");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
	
	public void modifierUtilisateur(int num) {
			String requete;
			requete =  "UPDATE utilisateur SET cin = "+
				    this.getCIN() + ", nom = '" + this.getNom()  + "', prenom = '" + 
					this.getPrenom() + "', age = " + this.getAge()
				    + " WHERE numero = " + num  ;
			try {
				int n =MyConnection.executerRequeteMiseAJour(requete);
				if (n==0)
					System.out.println("Echec de modification.");
				else
					System.out.println("Utilisateur modifié avec succés");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
	}
	public static void supprimerUtilisateur(int num) {
		String requete;
		requete =  "DELETE from utilisateur WHERE numero = " + num;
		try {
			int n =MyConnection.executerRequeteMiseAJour(requete);
			if (n==0)
				System.out.println("Echec de suppression.");
			else
				System.out.println("Utilisateur supprimé avec succés");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Vector<Utilisateur> getUtilisateurs()  {
		 ResultSet rs;
		  Vector<Utilisateur> listeUtilisateurs = new Vector<Utilisateur> ();
		  
		  String requete = "select * from utilisateur ";
		  try {
				rs = MyConnection.executerRequeteConsultation(requete);
				 while(rs.next())
		       {
					 listeUtilisateurs.add(new Utilisateur(rs.getDouble(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(1)));                
		       }
				 for(int i=0 ; i < listeUtilisateurs.size() ; i++) {
					 System.out.println(listeUtilisateurs.get(i).toString());
				 }
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}       
		  return listeUtilisateurs;
	}
	public static Utilisateur getUtilisateur(int numero)  {
		 ResultSet rs;
		  Utilisateur utilisateur = null;
		  
		  String requete = "select * from utilisateur where numero = " + numero ;
		  try {
				rs = MyConnection.executerRequeteConsultation(requete);
				if(rs.next())
		       {
					 utilisateur = new Utilisateur(rs.getDouble(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(1));                
		       }
				 
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}       
		  return utilisateur;
	}
}

