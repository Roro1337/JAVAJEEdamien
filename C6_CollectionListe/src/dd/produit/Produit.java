package dd.produit;

import java.io.Serializable;

public abstract class Produit implements Serializable, Comparable<Produit> {

	public static int CPT = 0;

	private int id;
	private String nom;
	private float prixUnitaire;

	public Produit() {
		// Produit.CPT equivalent CPTcar on est dans la classe
		// CPT variable static vissible dans tout le programme n'est pas une
		// propriété de la classe.
		id = Produit.CPT;
		CPT++;
	}

	public Produit(String nom, float prixUnitaire) {
		this.nom = nom;
		this.prixUnitaire = prixUnitaire;
		id = Produit.CPT;
		CPT++;

	}

	public abstract float getPrix();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNom() + ",id: " + this.getId() + ", prix: " + this.getPrix();
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public abstract boolean rajoute(Produit e);

	// @Override
	// public int compareTo(Produit p) {
	// int retour = 0;
	// if (p instanceof Consomable) {
	// if (this instanceof Alimentaire) {
	// retour = 1;
	// } else if (this instanceof Consomable) {
	// retour = this.getNom().compareTo(p.getNom());
	// }
	//
	// } else if (p instanceof Alimentaire) {
	// if (this instanceof Alimentaire) {
	// retour = this.getNom().compareTo(p.getNom());
	// } else if (this instanceof Consomable) {
	// retour = -1;
	// }
	// }
	//
	// return 0;
	// }

}
