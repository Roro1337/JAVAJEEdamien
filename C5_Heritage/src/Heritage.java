import dd.ExoForm2D.Cercle;
import dd.animaux.Animal;
import dd.animaux.Tigre;

public class Heritage {

	public static void main(String[] args) {

		Heritage heritage = new Heritage();
		heritage.init();

	}

	private void init() {

		Tigre tigrel = new Tigre("animal inconnu", 0.7f, 35f);
		Tigre tigre = new Tigre();
		tigre.setNom("Tigrou");
		System.out.println(tigre.getNbPattes());
		System.out.println(tigre.getNbPattes());
		System.out.println("mon mode de déplacement est" + tigre.seDeplacer());
		Animal tigre2;
		tigre2 = new Tigre();
		System.out.println(tigre2.seDeplacer());
		Cercle monCercle = new Cercle();
		monCercle.setLargeur(32);
		monCercle.setLongueur(52);

		// Exercice polymorphisme
		// collecter30 form2Detcalculé la surface totale
		// ajout d'un compteur static danslaclasse Form 2D
		// int nbForm = 30;
		// int valeurAleatoire = 0;
		// float surfaceTotale = 0;
		// float lng;
		// float lrg;
		// Form2D[] formeTotale = new Form2D[nbForm];

		/*
		 * Pour les case du switch on peu créer desvariable statiques public
		 * static into TYPE_CERCLE=0; ainsi switch(variable a test)
		 * case(TYPE_CERCLE) case(TYPE_triangle) etc.....
		 * 
		 * 
		 */
		/*
		 * for (int i = 0; i < nbForm; i++) {
		 * 
		 * // 3car 3 formes de Form2D valeurAleatoire = (int) (Math.random() *
		 * 3); lng = (float) (Math.random() * 10); lrg = (float) (Math.random()
		 * * 10);
		 * 
		 * switch (valeurAleatoire) { // Rectangle case 0: formeTotale[i] = new
		 * Rectangle(lng, lrg); break; // Triangle case 1: formeTotale[i] = new
		 * TriangleIsosele(lng, lrg); break; // le nbre aléatoire a généré un
		 * cercle case 2: formeTotale[i] = new Cercle(lng, lrg); } surfaceTotale
		 * += formeTotale[i].surface(); }
		 */

	}

}
