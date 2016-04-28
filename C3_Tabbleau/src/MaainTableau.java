
public class MaainTableau {

	public static void main(String[] args) {
		int[] tableau = new int[12];
		int[] tableau2;
		tableau2 = new int[12];
		boolean[] tBoolean = new boolean[5];
		int[] tableau3 = { 1, 2, 3, 4, 5, 6 };
		System.out.println(tableau3[2]);
		System.out.println(tableau3.length);

		System.out.println();
		for (int i = 0; i < tableau.length; i++) {
			System.out.print(tableau[i]);
		}

		int[][] image = new int[4][5];
		System.out.println("premiere dimension nb lignes :" + image.length);
		System.out.println("deuxieme dimension nb colones" + image[0].length);

		int[][] autre = { { 1, 2, 7 }, { 3, 4, 8 }, { 33, 44, 85 }, { 311, 24, 38 } };
		System.out.println(autre.length + " " + autre[0].length);
		System.out.println(autre[1][0]);

		for (int i = 0; i < autre.length; i++) {
			for (int j = 0; j < autre[0].length; j++) {
				System.out.print(autre[i][j] + ", ");
			}
			System.out.println();
		}

		System.out.println("------------------");

		for (int i = 0; i < autre.length; i++) {
			int[] tab = autre[i];
			// System.out.println(tab[0] + ", ");
			// System.out.println(tab[1] + ", ");
			// System.out.println(tab[2] + ", ");
			System.out.print("[");
			for (int j = 0; j < tab.length; j++) {
				System.out.print(tab[j]);
				if (j < tab.length - 1) {
					System.out.print(", ");

				}
			}
			System.out.println("]");
		}

		System.out.println();

		int etage = 0;
		int nbEtage = 9;
		int nbVehicule = 100;
		int nbPlace = 200;
		float pas = 0.5f;
		float valeurMin = 1.5f;
		float valeurMax = 5f;
		float[] tabLongVoit = new float[nbVehicule];
		int[] compteur = new int[nbEtage];
		int[][] parking = new int[nbEtage][nbPlace];

		for (int i = 0; i < tabLongVoit.length; i++) {
			double valeurAleatoire = Math.random();
			tabLongVoit[i] = (float) (valeurAleatoire * 6);

			System.out.println(tabLongVoit[i]);

			if (tabLongVoit[i] < 1) { // TODO voiture < 1metre? ???}
			}
			if (tabLongVoit[i] < 1.5f) {
				System.out.println("refus du véhicule" + i);
			} else if (tabLongVoit[i] > 5.5) {
				parking[0][compteur[0]] = i;
				compteur[0]++;
				System.out.println("Ranger au RDC");

			} else {
				for (float indice = valeurMin; indice < valeurMax + pas; indice += pas) {
					etage = (int) (indice / pas - 2);
					if (tabLongVoit[i] >= indice || tabLongVoit[i] < indice + pas) {
						System.out.println("ranger au " + etage + "etage");
						if (compteur[etage] < 201) {
							compteur[etage]++;
						} else {

						}
					}
					parking[etage][compteur[etage]] = i;
					break;
				}

			}

		}
		System.out.println("rangement:");
		System.out.println();
		for (int i = 0; i < nbEtage; i++) {
			System.out.println("Au" + i + "etage :");
			for (int j = 0; j < compteur[i]; j++) {
				System.out.print(parking[i][j] + ",");
			}
			System.out.println();
		}
	}

}
