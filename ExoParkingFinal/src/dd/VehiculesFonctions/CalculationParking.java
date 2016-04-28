package dd.VehiculesFonctions;

import dd.Vehicules.Citadine;
import dd.Vehicules.Limousine;
import dd.Vehicules.MonoSpace;
import dd.Vehicules.Moto;
import dd.Vehicules.Vehicules;


public class CalculationParking {

	
	
	private Vehicules[] creerListeVehicule(int nbVehicules) {

		Vehicules[] monTabDeVehicule = new Vehicules[nbVehicules];
		float longueurV = 0f;
		int valeurAleatoireInt = 0;
		
		for (int i = 0; i < nbVehicules; i++) {
			double valeurAleatoire = Math.random();
			valeurAleatoireInt = (int) (valeurAleatoire * 4);

			switch (valeurAleatoireInt) {
			// Moto
			case 0:
				valeurAleatoire = Math.random() + 1;
				monTabDeVehicule[i] = new Moto((float) valeurAleatoire);
				break;
			// Citadine
			case 1:
				valeurAleatoire = Math.random() + 2;
				monTabDeVehicule[i] = new Citadine((float) valeurAleatoire);
				break;
			// Monospace
			case 2:
				valeurAleatoire = Math.random() + 3;
				monTabDeVehicule[i] = new MonoSpace((float) valeurAleatoire);
				break;
			// Limousine
			case 3:
				valeurAleatoire = Math.random() + 4;
				monTabDeVehicule[i] = new Limousine((float) valeurAleatoire);
				break;
			}

		}
		return monTabDeVehicule;

	}

}
