package dd.animaux;

public abstract class Vertebre extends Animal {

	private int nbPattes;

	public Vertebre() {
		super();

	}

	public Vertebre(String nom, float taille, float poids) {
		super(nom, taille, poids);

	}

	public int getNbPattes() {
		return nbPattes;
	}

	public void setNbPattes(int nbPattes) {
		this.nbPattes = nbPattes;
	}

}
