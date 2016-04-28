
public class MainBoucle2 {

	public static void main(String[] args) {
		int lng = 5;
		if (lng == 2) {
			System.out.println("ranger etage 1");

		} else if (lng == 3) {
			System.out.println("ranger etage 2");
		} else if (lng == 4) {
			System.out.println("ranger etage 3");
		} else if (lng == 5) {
			System.out.println("ranger etage 4");
		} else if (lng == 6) {
			System.out.println("ranger etage 5");
		} else if (lng == 7) {
			System.out.println("ranger etage 6");
		}
		// la boucle for fait la meme chose que le if
		for (int indice = 2; indice < 6; indice++) {
			if (lng == indice) {
				int etage = indice - 1;
				System.out.println("ranger etage " + etage);
			}
		}

		int etage = 1;
		float longueur = 3.4f;
		float pas = 0.5f;
		float valeurMin = 2;
		float valeurMax = 5;
		if (longueur < 1.5f) {
			System.out.println("ranger dans mon garage à vélo");
		} else if (longueur > 5) {
			System.out.println("ranger AU RDC");

		} else {
			for (float indice = valeurMin; indice < valeurMax + pas; indice += pas) {
				etage = (int) (indice / pas - 2);
				if (longueur >= 2 || longueur < indice + pas) {
					System.out.println("ranger au " + etage + "etage");
					break;
				}

			}

		}
	}
}
