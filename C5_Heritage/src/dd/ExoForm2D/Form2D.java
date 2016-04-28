package dd.ExoForm2D;

public abstract class Form2D implements Comparable<Form2D> {

	private static int compteur;
	private int posx, posy;
	private float longueur;
	private float largeur;
	private static int NBX = 10;
	private static int NBY = 3;
	private static int PAS = 1;
	private static int IND = 1;

	public Form2D() {
		compteur++;
		// var static pour l'affichage placer les dessin
		posx = 10 + (IND % NBX) * PAS;
		longueur = 0;
		largeur = 0;
	}

	public Form2D(float longueur, float largeur) {
		compteur++;
		this.longueur = longueur;
		this.largeur = largeur;
	}

	public float getLongueur() {
		return longueur;
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	public float getLargeur() {
		return largeur;
	}

	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	public abstract float surface();

	public abstract float perimetre();

	public abstract void Affichage();

	public int compareTo(Form2D autreForme) {

		int result = 0;
		if (this.surface() < autreForme.surface()) {
			result = -1;
		} else if (this.surface() > autreForme.surface()) {
			result = 1;
		}
		return result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ma forme 2D est: " + this.getClass().getName() + " de surface : " + surface();
	}

	private boolean contain(Form2D forme, Form2D[] tab) {

		boolean bool = false;
		for (int i = 0; i < tab.length; i++) {

			if (forme.equals(tab[i])) {
				bool = true;
				break;
			}

		}
		return bool;
	}

	public boolean equals(Object obj) {

		boolean bool = false;
		Form2D maForme = (Form2D) obj;
		if (maForme.getLongueur() == this.getLongueur() || maForme.getLongueur() == this.getLongueur()) {
			bool = true;
		}
		return bool;
	}

}