package dd.ExoForm2D;

public class Rectangle extends Form2D {

	public Rectangle() {
		super();
	}

	public Rectangle(float longueur, float largeur) {
		setLongueur(longueur);
		setLargeur(largeur);
	}

	public float surface() {
		return (float) (getLongueur() * getLargeur());
	}

	public float perimetre() {
		// super ecriture propre cardéfini dans forme 2D
		return (float) (2 * getLargeur() + 2 * super.getLongueur());
	}

	public void Affichage() {
		// TODO

	}

	public String toString() {
		// TODO Auto-generated method stub
		return "Rectangle";
	}

	// ma methode
	/*
	 * public boolean equals(Form2D obj) { boolean bool = false; if
	 * (Float.valueOf(obj.getLargeur()).equals(this.getLargeur()) &&
	 * this.getLongueur() == obj.getLongueur() && this instanceof Rectangle) {
	 * bool = true; return bool; } else { return false; } }
	 */
	// correction

	public boolean equals(Object obj) {
		// le equals super appelle la méthode deForm2D qui comprare leslongueur
		// etalrgeur
		// ici dans la redéfinition de eqauls il ne reste plus qu' test si
		// l'instance de l'objet en argument est bien un Rectangme
		boolean bool = super.equals(obj);
		bool &= (obj instanceof Rectangle);
		return bool;
	}
}
