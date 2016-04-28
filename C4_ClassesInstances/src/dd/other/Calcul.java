package dd.other;

public class Calcul {
	// Methode qui renvoi un float qui calcule une dimension lineaire enfonction
	// du nombre de picots
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
}
