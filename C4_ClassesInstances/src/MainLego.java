import dd.metier.LegoExo;

public class MainLego {

	public static void main(String[] args) {

		MainLego mainLego = new MainLego();
		mainLego.init();
	}

	private void init() {
		Lego monPremierLego = null;
		int u = 0;
		monPremierLego = new Lego();
		monPremierLego.nommerMonLego("mon premier lego");
		Lego monSecondLego = new Lego();
		monSecondLego.nommerMonLego("mon secondlego");
		monPremierLego.largeur = 5;
		int color = 2;
		int long1 = 12;
		int larg1 = 5;
		int coul = 3;
		monSecondLego.couleur = color;
		monSecondLego.longueur = monPremierLego.largeur;
		monPremierLego.initialiseMonLego(long1, larg1, coul);
		monSecondLego.initialiseMonLego(13, 24, 3);
		monSecondLego.paindreMonLego(7);
		System.out.println("couleur de mon premier lego" + monPremierLego.couleur);
		System.out.println("couleur de mon second lego" + monSecondLego.getCouleur());
		int val = 0;
		// System.out.println("nb : ");

		// EXERCICE LEGO
		// CLASS LegoExo
		float dim;
		LegoExo monExoLego = new LegoExo(3f, 1.5f, 0.8f, 4, 2, "random");
		dim = monExoLego.calculDim(monExoLego.getNbPicotsLng());
		System.out.println("longueur de mon lego : " + dim);
		dim = monExoLego.calculDim(monExoLego.getNbPicotsLrg());
		System.out.println("largeur de mon lego : " + dim);

		// tour
		LegoExo[] tour = new LegoExo[100];

		for (int i = 0; i < tour.length; i++) {
			tour[i] = new LegoExo(0.8f, 4, 2, "blanc");
		}

		LegoExo[] tour2 = tour;
		tour2[1].setNbPicotsLng(8);

		// peindre les legos de la tour de facon aleatoire
		// Compter le nombrede lego dechaque couleur

		String[] colorList = { "blanc", "bleu", "rouge", "gris", "noir" };
		int[] compteurColor = new int[colorList.length];
		for (int i = 0; i < tour2.length; i++) {

			int indiceColor = (int) (Math.random() * 5);
			tour2[i].setCouleur(colorList[indiceColor]);
			compteurColor[indiceColor]++;

			System.out.println(tour2[i].getCouleur());
			// System.out.println(indiceColor);
		}

		// optimisé en boucle équivalente
		for (int i = 0; i < tour2.length; i++) {
			tour2[i].setCouleur(colorList[(int) (Math.random() * colorList.length)]);
			System.out.println(tour2[i].getCouleur());
		}

		for (int i = 0; i < compteurColor.length; i++) {

			System.out.println();
			System.out.print(colorList[i] + ":" + compteurColor[i] + "  ");
		}

		// Faire 5 tours de couleur unique avec la tour2
		// Déterminer le compteur max pour créer
		int compteurMax = compteurColor[0];
		for (int i = 1; i < colorList.length; i++) {

			if (compteurMax < compteurColor[i]) {
				compteurMax = compteurColor[i];
			}
		}

		LegoExo[][] tourCouleur = new LegoExo[colorList.length][compteurMax];
		for (int i = 0; i < tour2.length; i++) {

			LegoExo lego = tour2[i];
			String couleurDuLego = lego.getCouleur();
			int indiceCouleur = -1;
			for (int j = 0; j < colorList.length; j++) {
				// appel de la méthode .equal() afin decomparé 2chaine de
				// caractere ( 2objets, 2classes
				if (couleurDuLego.equals(colorList[i])) {
					indiceCouleur = j;
					break;
				}
			}
			for (int j = 0; j < compteurMax; j++) {
				LegoExo legotest = tourCouleur[indiceCouleur][j];
				if (legotest == null) {

					tourCouleur[indiceCouleur][j] = lego;
				}
			}
		}
		for (int j = 0; j < tourCouleur.length; j++) {
			for (int j2 = 0; j2 < tourCouleur.length; j2++) {
				LegoExo legoX = tourCouleur[j][j2];
				if (legoX != null) {
					System.out.println(legoX.getCouleur().substring(0, 1));

				} else {
					break;
				}
			}
			System.out.println("");
		}

	}

}
