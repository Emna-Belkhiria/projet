package paracticalexercice;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DocumentAchat {
private int numero=0;
private double prixtotal=0;
private List <Achat>AchatList= new ArrayList<>();

public DocumentAchat() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Veuillez saisir le numéro de document d'achat");
	this.numero=sc.nextInt();
	this.prixtotal = 0;
}
public DocumentAchat(int numero, double prixtotal) {
	this.numero = numero;
	this.prixtotal = prixtotal;
}

public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}

public double getPrixtotal() {
	return prixtotal;
}
public void setPrixtotal(double prixtotal) {
	this.prixtotal = prixtotal;
}
public void ajouterAchat(Achat achat) {
		this.AchatList.add(achat);
	}
public double calculePTotal()
{ 
	for (int i=0;i<this.AchatList.size();i++) {
		prixtotal+=this.AchatList.get(i).calculePTProduit(AchatList.get(i).getProduit().getPrixUnitaire(),AchatList.get(i).getQuantite());
	}
	return prixtotal;
}
public void afficheDocAchat() {
	System.out.println("La commande numéro "+ this.numero + ":");
	for (int i=0;i<this.AchatList.size();i++) {
		AchatList.get(i).toString();
	}
	System.out.println("Le prix total de votre commande est egale :" + calculePTotal());
}

}
