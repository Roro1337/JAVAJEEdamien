import javax.swing.JPanel;

import dd.ExoForm2D.Cercle;
import dd.ExoForm2D.Form2D;
import dd.ExoForm2D.Rectangle;
import dd.ExoForm2D.TriangleIsosele;

public class SurfaceGlobale extends JPanel {

	float surfaceTotale = 0;
	int nbForm = 30;
	Form2D[] formeTotale = new Form2D[nbForm];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SurfaceGlobale masurf = new SurfaceGlobale();
		masurf.init();
	}

	private void init() {

		creTab();
		float somme = sommeTotale();
		System.out.println(somme);
		afficherMonTableau(formeTotale);

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

	public void creTab() {

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
		for (int i = 0; i < nbForm; i++) {

			// 3car 3 formes de Form2D
			valeurAleatoire = (int) (Math.random() * 3);
			lng = (float) (Math.random() * 10);
			lrg = (float) (Math.random() * 10);

			switch (valeurAleatoire) {
			// Rectangle
			case 0:
				formeTotale[i] = new Rectangle(lng, lrg);
				break;
			// Triangle
			case 1:
				formeTotale[i] = new TriangleIsosele(lng, lrg);
				break;
			// le nbre aléatoire a généré un cercle
			case 2:
				formeTotale[i] = new Cercle(lng, lrg);
			}

		}
	}

	private float sommeTotale() {
		float surfaceTotale = 0;
		for (int j = 0; j < formeTotale.length; j++) {
			surfaceTotale += formeTotale[j].surface();
		}
		return surfaceTotale;

	}

	public void afficherMonTableau(Object[] array) {
		for (int i = 0; i < array.length; i++) {
			// System.out.println(array.getClass().getName());
			// Object superclasse de java Mere toute classe, et avec methode
			// toString() définie par défault
			// ici array[i].toString apelle la méthode toString redéfinie dans
			// la classe de l'objet i
			// dans sysout (array[i] équivalent a array[i].toString)
			// car sysout attend une chaine de caractere donc
			// il va cherché la méthode dans l'objet (array[i]) qui renvoi un String cad
			// toString()
			System.out.print(array[i].toString() + ", ");
			System.out.println(" ");
		}

	}

	public Object[] ajoutAuBout(Object[] array, Form2D forme) {
		Object[] maForme = new Object[array.length + 1];

		for (int i = 0; i < array.length; i++) {
			maForme[i] = array[i];
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

	public Object suppAuBout(Object[] array) {
		array[array.length - 1] = null;
		return array;
	}

	public void suppAuMilieu(Object[] array, int pos) {
		array[pos - 1] = null;
	}

}
