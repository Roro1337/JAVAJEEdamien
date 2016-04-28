package dd.animaux;

public class EtoileDeMer extends Molusque {

	public EtoileDeMer() {
		super();
		super.setNbPattes(0);

	}

	public EtoileDeMer(String nom, float taille, float poids, int nbPattes) {
		super(nom, taille, poids, nbPattes);

	}

	public String seDeplacer() {
		return "nage/rampe";
	}

}
