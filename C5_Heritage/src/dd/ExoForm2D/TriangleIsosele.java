package dd.ExoForm2D;

public class TriangleIsosele extends Triangle {

	public TriangleIsosele() {
		super();
	}

	public TriangleIsosele(float longueur, float largeur) {
		super(longueur, largeur);
	}

	public float perimetre() {
		return (float) (Math.hypot(getLongueur(), getLargeur()) + getLongueur() + getLargeur());
	}

	public float surface() {
		return (float) (getLongueur() * getLargeur() / 2);
	}

	public void Affichage() {
		// TODO

	}

	public boolean equals(Object obj) {
		boolean bool = super.equals(obj);
		bool &= obj instanceof TriangleIsosele;
		return bool;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return "Triangle Isosele";
	}
}
