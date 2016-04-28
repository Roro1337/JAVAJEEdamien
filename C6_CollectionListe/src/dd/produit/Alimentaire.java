package dd.produit;

import java.io.Serializable;

public class Alimentaire extends Produit implements Serializable,Comparable<Produit> {
	
	private static final long serialVersionUID=1L;

	private float poids;

	public Alimentaire() {
		super();
	}

	public Alimentaire(String nom, float poids, float prixUnitaire) {
		super(nom, prixUnitaire);
		this.poids = poids;
	}

	public float getPrix() {
		// TODO Auto-generated method stub
		return getPrixUnitaire() * getPoids();
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public boolean rajoute(Produit e) {
		boolean bool = false;
		if (e instanceof Alimentaire && e.getNom().equals(this.getNom())) {
			Alimentaire a = (Alimentaire) e;
			this.setPrixUnitaire((getPrix() + a.getPrix()) / (this.getPoids() + a.getPoids()));
			this.setPoids(this.getPoids() + a.getPoids());
			bool = true;
		}
		return bool;
	}

	@Override
	public boolean equals(Object obj) {
		boolean retour = false;
		if (obj instanceof Alimentaire) {
			Alimentaire e = (Alimentaire) obj;
			retour = this.getNom().equals(e.getNom());
		}
		return retour;
	}

	public int compareTo(Produit p) {
		int retour = 0;
		if (p instanceof Alimentaire) {
			retour = this.getNom().compareTo(p.getNom());
		} else if (p instanceof Consomable) {
			retour = 1;
		}
		return retour;
	}

}
