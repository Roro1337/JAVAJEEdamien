package dd.animaux;

public class Perroquet extends Animal {
	
	private int nbPattes;

	public int getNbPattes() {
		return nbPattes;
	}

	public void setNbPattes(int nbPattes) {
		this.nbPattes = nbPattes;
	}

	public Perroquet() {
		
	}

	public Perroquet(String nom, float taille, float poids) {
		super(nom, taille, poids);
		nbPattes=2;
		
	}

	@Override
	public String seDeplacer() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
