package dd.animaux;

public abstract class Molusque extends Invertebre {

	private int nbPattes;

	public Molusque() {
		super();
		nbPattes = 0;

	}

	public Molusque(String nom, float taille, float poids, int nbPattes) {
		super(nom, taille, poids);
		nbPattes = 0;
	}

	public int getNbPattes() {
		return nbPattes;
	}

	public void setNbPattes(int nbPattes) {
		this.nbPattes = nbPattes;
	}

}
