package dd.Vehicules;

public abstract class Vehicules {

	private float longueur;
	private int nbRoues;

	public void Vehicules() {

		this.longueur = 0f;

	}

	public float getLongueur() {
		return longueur;
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	public int getNbRoues() {
		return nbRoues;
	}

	public void setNbRoues(int nbRoues) {
		this.nbRoues = nbRoues;
	}

}
