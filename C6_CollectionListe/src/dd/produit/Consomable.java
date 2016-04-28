package dd.produit;

import java.io.Serializable;

public class Consomable extends Produit implements Serializable, Comparable<Produit> {

	private static final long serialVersionUID = 1L;
	private int qte;

	public Consomable() {
		super();
	}

	public Consomable(String nom, int qte, float prixUnitaire) {
		super(nom, prixUnitaire);
		this.qte = qte;
	}

	@Override
	public float getPrix() {

		return getPrixUnitaire() * getQte();
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		if (qte > 0) {
			this.qte += qte;
		} else {
			this.qte = 0;
		}
	}

	public boolean rajoute(Produit e) {
		boolean bool = false;
		if (e instanceof Consomable && e.getNom().equals(this.getNom())) {
			Consomable a = (Consomable) e;
			this.setPrixUnitaire((getPrix() + a.getPrix()) / (this.getQte() + a.getQte()));
			this.setQte(this.getQte() + a.getQte());
			bool = true;
		}
		return bool;
	}

	@Override
	public boolean equals(Object obj) {
		boolean retour = false;
		if (obj instanceof Consomable) {
			Consomable e = (Consomable) obj;
			retour = this.getNom().equals(e.getNom());
		}
		return retour;
	}

	@Override
	public int hashCode() {
		return this.getNom().hashCode();
	}

	@Override
	public int compareTo(Produit p) {
		int retour = 0;
		if (p instanceof Consomable) {
			retour = this.getNom().compareTo(p.getNom());
		} else if (p instanceof Alimentaire) {
			retour = -1;
		}
		return retour;
	}

}
