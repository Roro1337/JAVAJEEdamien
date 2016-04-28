
public class Lego {

	String nomDuLego;
	int longueur;
	int largeur;
	int couleur;

	// cr�ation du constructeur
	// �tape fcultative car cest le construteur compil� par defaut (initialise
	// tout � NULL ou 0)

	Lego() {
		this.nomDuLego = "";
		this.longueur = 10;
		this.largeur = 5;
		couleur = 0;// idem this obsolete car pas de conflit argumen/type de
					// variable.
	}

	// Second constructeur avec parametre
	Lego(String nomDuLego, int longueur, int largeur, int couleur) {
		this.nomDuLego = nomDuLego;
		this.longueur = longueur;
		this.largeur = largeur;
		this.couleur = couleur;
	}

	// M�thodes dela Classe Lego (sous-constructeur en quelque sorte )
	void initialiseMonLego(int longueur, int largeur, int couler) {
		this.longueur = longueur;
		this.largeur = largeur;
		couleur = couler; // ici this s'utilise pour sp�cifier que longueur
							// apartient � l'objet qui apelle la m�thode, car on
							// passe un parametre nommer de la meme maniere
		// this n'est pas utilise pour couleur par ce fait

	}

	void nommerMonLego(String nomDuLego) {
		this.nomDuLego = nomDuLego;

	}
	/*
	 * mm methode sans THIS
	 * 
	 * void nommerMonLego(String nom) { nomDuLego = nom; }
	 */

	void paindreMonLego(int coul) {
		couleur = coul;
	}

	int getCouleur() {
		return this.couleur;
	}

	int getLongueur() {
		return this.longueur;
	}

	int getLargeur() {
		return this.largeur;
	}

	String getNom() {
		return this.nomDuLego;
	}

	void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	// meme methode que paindreMonLego ici this indispensable
	// sinn conflit du type couleur de la classe lego et de l'argument couleur
	// de la m�thode

	void setCouleur(int couleur) {
		this.couleur = couleur;
	}

}