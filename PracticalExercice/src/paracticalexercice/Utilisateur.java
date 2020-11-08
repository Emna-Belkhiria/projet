package paracticalexercice;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Utilisateur extends Personne {
	private int numero;
	private List <DocumentAchat>docAchatList= new ArrayList<>();
	
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
	public void ajouterDocAchat(DocumentAchat docAchat) {
		this.docAchatList.add(docAchat);
		System.out.println("Document achat ajouté avec succés");

	}
}

