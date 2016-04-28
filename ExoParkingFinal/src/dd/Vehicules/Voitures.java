package dd.Vehicules;

public class Voitures extends Vehicules {

	public Voitures() {
		super();
	}

	public Voitures(float longueur) {

		this.setLongueur(longueur);
		this.setNbRoues(4);

	}

	@Override
	public float getLongueur() {
		// TODO Auto-generated method stub
		return super.getLongueur();
	}

	@Override
	public void setLongueur(float longueur) {
		// TODO Auto-generated method stub
		super.setLongueur(longueur);
	}

	@Override
	public int getNbRoues() {
		// TODO Auto-generated method stub
		return super.getNbRoues();
	}

}
