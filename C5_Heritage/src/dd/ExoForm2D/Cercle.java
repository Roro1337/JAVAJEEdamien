package dd.ExoForm2D;

public class Cercle extends Form2D {
	// ici longueur = rayon

	public Cercle() {
		super();
	}

	public Cercle(float longueur, float largeur) {
		super(longueur, longueur);
	}

	@Override
	public float surface() {
		// TODO Auto-generated method stub
		return (float) (Math.PI * getLongueur() * Math.PI * getLongueur());
	}

	@Override
	public float perimetre() {
		// TODO Auto-generated method stub
		return (float) (2 * Math.PI * getLongueur());
	}

	public void Affichage() {
		// TODO

	}

	public String toString() {
		// TODO Auto-generated method stub
		return "Cercle de rayon " + getLongueur();
	}

	public boolean equals(Object obj) {
		boolean bool = super.equals(obj);
		bool &= obj instanceof Cercle;
		return bool;
	}
}
