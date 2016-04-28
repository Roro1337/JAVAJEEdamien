
public class MainType {

	public static void main(String[] args) {
		// byte a = 0x34; // notation Hexadécimale 4 +(3x16)=52
		// valeur max byte [-128;127] byte a=0x7F;
		byte a = 0x7F;
		byte b = 1;
		int c = a + b;
		System.out.println(c);

		int d = 5;
		int e = c + d;
		System.out.println(c + " + " + d + " = " + e);
		int f = 0x7FFFFFFF; // limite entier
		f++; // changement de signe car f++=f+1=80000000 en Hexa 8= [ 1 0 0 0 ]
				// en bianaire poids fort => signe -
		System.out.println(f);
		f++;
		System.out.println(f);

		int g = 100;
		int h = 7;
		float i = 2.4f;
		float j = g / h * i;
		System.out.println(j);
		int l = g / h;
		System.out.println(l);
		float m = l * i;

		System.out.println(m);
		float k = i * g / h;
		System.out.println(k);
		float n = g;
		n = n / h * i;
		System.out.println(n);

		int o = 15;
		int entiere = o / 7;
		int reste = o - entiere * 7;
		System.out.println("partie entière=" + entiere + " reste=" + reste);
		int rest = o % 7;
		System.out.println("rest=" + rest);

		double p = (100l + 12) / 3d;
		System.out.println(p);

		boolean vrai = true;
		boolean faux = false;
		boolean resultat = vrai & faux;
		System.out.println(resultat);
		boolean resultat2 = vrai | faux;
		System.out.println(resultat2);

		int q = 0xF0;
		int r = 0x0F;
		int s = q | r;
		System.out.println(s);

		char t = 'a'; /*
						 * utilisation de quote ' et non double quote " a la
						 * declaration
						 */
		// a a la valeur hexadecimale et entiere 98
		int u = t + 1;
		System.out.println(t + " " + u);
		char v = '\u0061';
		System.out.println(v);

		if (k == j) {
			System.out.println("c'est bon");
		} else {
			System.out.println("c'est pas bon");

		}

		if (5 > 4 && 7 < 12) { // test et entre 2 conditions double et && ou
								// double ou ||
			// !(true)=false inverse bit par bit
			System.err.println("ok");

		}

		float z = ((float) g) / h * i; // cast de g
		System.out.println(z);

	}

}
