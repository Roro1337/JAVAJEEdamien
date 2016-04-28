package dd.metier;

public class Tour {

	private String nom;
	// encapsulage objeta l'interieur d'un objet (lego dans tour) car
	// tour=plusieur lego
	private LegoExo[] maTour;
	private LegoExo legoType;

	public Tour() {

	}

	public Tour(String nom, LegoExo legoType){
		this.nom=nom;
		this.legoType=legoType;
		this.maTour=new LegoExo[1000];
		for (int i = 0; i < maTour.length; i++) {
			
			//équivalent
			//LegoExo leLego = new LegoExo(legoType.getHauteur(),legoType.getNbPicotsLng(),legoType.getNbPicotsLrg(),legoType.getCouleur());
			LegoExo leLego=new LegoExo(legoType);
			
			maTour[i]=leLego;
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LegoExo[] getMaTour() {
		return maTour;
	}

	public void setMaTour(LegoExo[] maTour) {
		this.maTour = maTour;
	}
}
