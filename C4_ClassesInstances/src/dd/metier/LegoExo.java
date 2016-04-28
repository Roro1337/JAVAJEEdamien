package dd.metier;

public class LegoExo {

	// propriété de l'objet LegoExo
	private String couleur;
	// float longueur;
	// float largeur;
	private float hauteur;
	private int nbPicotsLng;
	private int nbPicotsLrg;

	public LegoExo() {
		this.couleur = "unamed";
		// this.longueur = 3f;
		// this.largeur = 1.5f;
		this.hauteur = 0.8f;
		this.nbPicotsLng = 4;
		this.nbPicotsLrg = 2;
	}

	public LegoExo(float longueur, float largeur, float hauteur, int nbPicotsLng, int nbPicotsLrg, String couleur) {
		// this.longueur = longueur;
		// this.largeur = largeur;
		this.hauteur = hauteur;
		this.nbPicotsLng = nbPicotsLng;
		this.nbPicotsLrg = nbPicotsLrg;
	}

	public LegoExo(float hauteur, int nbPicotsLng, int nbPicotsLrg, String couleur) {
		// this.longueur = calculDim(nbPicotsLng);
		// this.largeur = calculDim(nbPicotsLrg);
		this.nbPicotsLng = nbPicotsLng;
		this.nbPicotsLrg = nbPicotsLrg;
		this.hauteur = hauteur;
		this.couleur = couleur;
	}

	// un constructeur exercice
	public LegoExo(float longueur, float largeur, float hauteur, String couleur) {
		// this.longueur = longueur;
		// this.largeur = largeur;
		// si package other car calcul est une methode de la classe calcul
		// Calcul calcul = new Calcul();
		this.hauteur = hauteur;
		this.nbPicotsLng = calculPic(longueur);
		this.nbPicotsLrg = calculPic(largeur);

	}

	public LegoExo(LegoExo autreLego) {
		this.hauteur = autreLego.getHauteur();
		this.nbPicotsLng = autreLego.getNbPicotsLng();
		this.nbPicotsLrg = autreLego.getNbPicotsLrg();

	}

	public float calculDim(int nbPicots) {
		return (float) (0.75f * nbPicots);
	}

	public int calculPic(float dim) {
		int valeurDeRetour = -1;
		if (dim > 0) {
			float n = dim / 0.75f;
			int nb = (int) n;
			if (n - nb < 0.5f) {
				valeurDeRetour = nb;
			} else {
				valeurDeRetour = nb + 1;
			}
		}
		return valeurDeRetour;
	}

	// getters setters
	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	// modification avec appel de méthode
	public float getLongueur() {
		return calculDim(this.nbPicotsLng);
	}

	/*
	 * public void setLongueur(float longueur) { this.longueur = longueur;
	 * nbPicotsLng=calculPic(longueur); }
	 * 
	 * // modif avec double appel de methode public float getLargeur() { return
	 * calculDim(getNbPicotsLrg()); }
	 * 
	 * public void setLargeur(float largeur) { this.largeur = largeur;
	 * nbPicotsLrg=calculPic(largeur); }
	 */
	public float getHauteur() {
		return hauteur;
	}

	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}

	public int getNbPicotsLng() {
		return nbPicotsLng;
	}

	public void setNbPicotsLng(int nbPicotsLng) {
		this.nbPicotsLng = nbPicotsLng;
	}

	public int getNbPicotsLrg() {
		return nbPicotsLrg;
	}

	public void setNbPicotsLrg(int nbPicotsLrg) {
		this.nbPicotsLrg = nbPicotsLrg;
	}

}
