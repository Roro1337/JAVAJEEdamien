package dd.ExoForm2D;

class CalculationTab {

	private Form2D[] calcTab;

	public CalculationTab(int nb) {

		this.calcTab = new Form2D[nb];
	}

	public Form2D[] getCalcTab() {
		return calcTab;
	}

	public void setCalcTab(Form2D[] calcTab) {
		this.calcTab = calcTab;
	}

	// tri croissant d'objet form2D par leur surface
	public Form2D[] tri(Form2D[] tableau) {

		for (int i = 0; i < tableau.length; i++) {
			System.out.println(tableau[i].surface() + " , ");
		}
		System.out.println("");
		Form2D tampon;
		boolean permut;

		do {
			// hypothèse : le tableau est trié
			permut = false;
			for (int i = 0; i < tableau.length - 1; i++) {
				// Teste si 2 éléments successifs sont dans le bon ordre ou non
				if (tableau[i].compareTo(tableau[i + 1]) > 0) {
					// s'ils ne le sont pas, on échange leurs positions
					tampon = tableau[i];
					tableau[i] = tableau[i + 1];
					tableau[i + 1] = tampon;
					permut = true;
				}
			}

		} while (permut);
		return tableau;
	}

	// créer un tableau de forme aléatoire
	public Form2D[] creTab(CalculationTab tab) {

		int valeurAleatoire = 0;
		float lng;
		float lrg;
		/*
		 * Pour les case du switch on peu créer desvariable statiques public
		 * static into TYPE_CERCLE=0; ainsi switch(variable a test)
		 * case(TYPE_CERCLE) case(TYPE_triangle) etc.....
		 * 
		 * 
		 */
		for (int i = 0; i < tab.calcTab.length; i++) {

			// 3car 3 formes de Form2D
			valeurAleatoire = (int) (Math.random() * 3);
			lng = (float) (Math.random() * 10);
			lrg = (float) (Math.random() * 10);

			switch (valeurAleatoire) {
			// Rectangle
			case 0:
				tab.calcTab[i] = new Rectangle(lng, lrg);
				break;
			// Triangle
			case 1:
				tab.calcTab[i] = new TriangleIsosele(lng, lrg);
				break;
			// le nbre aléatoire a généré un cercle
			case 2:
				tab.calcTab[i] = new Cercle(lng, lrg);
			}
		}
		return tab.calcTab;
	}

	// somme des surface du tableau de Form2d
	private float sommeTotale() {

		float surfaceTotale = 0;
		for (int j = 0; j < calcTab.length; j++) {
			surfaceTotale += calcTab[j].surface();
		}
		return surfaceTotale;

	}

	public void afficherMonTableau() {
		for (int i = 0; i < calcTab.length; i++) {
			// System.out.println(array.getClass().getName());
			// Object superclasse de java Mere toute classe, et avec methode
			// toString() définie par défault
			// ici array[i].toString apelle la méthode toString redéfinie dans
			// la classe de l'objet i
			// dans sysout (array[i] équivalent a array[i].toString)
			// car sysout attend une chaine de caractere donc
			// il va cherché la méthode dans l'objet (array[i]) qui renvoi un
			// String cad
			// toString()
			// System.out.print(array[i].toString() + ", ");
			System.out.println(" ");
		}

	}

	public Form2D[] ajoutAuBout(Form2D forme) {
		Form2D[] maForme = new Form2D[calcTab.length + 1];

		for (int i = 0; i < calcTab.length; i++) {
			maForme[i] = calcTab[i];
		}
		maForme[maForme.length - 1] = forme;
		return maForme;
	}

	public Object[] ajoutAuMilieu(Object[] array, Form2D forme, int pos) {
		Object[] maForme = new Object[array.length + 1];
		boolean replaced = false;
		for (int i = 0; i < maForme.length; i++) {
			if (i == pos - 1) {
				maForme[i] = forme;
				replaced = true;
			} else {

				if (replaced == true) {
					maForme[i] = array[i - 1];
				} else {
					maForme[i] = array[i];
				}

			}
		}
		return maForme;
	}

	public Form2D[] suppAuBout() {
		calcTab[calcTab.length - 1] = null;
		return calcTab;
	}

	public void suppAuMilieu(int pos) {
		calcTab[pos - 1] = null;
	}

}
