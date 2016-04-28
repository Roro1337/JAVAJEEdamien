package dd.animaux;

public abstract class Animal {

	private String nom;
	private float taille;
	private float poids;

	public Animal() {
		this.nom = "unamed";
		this.taille = 0f;
		this.poids = 0f;
	}

	public Animal(String nom, float taille, float poids) {
		this.nom = nom;
		this.taille = taille;
		this.poids = poids;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getTaille() {
		return taille;
	}

	public void setTaille(float taille) {
		this.taille = taille;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public abstract String seDeplacer();

}
