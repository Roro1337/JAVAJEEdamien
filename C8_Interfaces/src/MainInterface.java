
public class MainInterface {

	public static void main(String[] args) {
		MainInterface m = new MainInterface();
		m.init();

	}

	public void init() {
		StationService total = new StationService(1000);
		GrandeSurface auchan = new GrandeSurface(1000);
		Voiture v1 = new Voiture(40);
		v1.prendreEssence(total);
		Voiture v2 = new Voiture(60);
		v2.prendreEssence(auchan);
	}
}
