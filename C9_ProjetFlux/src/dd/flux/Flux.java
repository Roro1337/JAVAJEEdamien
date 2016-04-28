package dd.flux;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Flux {

	public static void main(String[] args) {
		Flux flux = new Flux();
		flux.init();

	}

	public void init() {
		File rep = new File("C://DevFormation/Workspace/ProjetFlux/donnees");
		System.out.println(rep.getAbsolutePath());
		File repCourant = new File("./");
		System.out.println(repCourant.getAbsolutePath());
		File re = new File("./donnees/");
		System.out.println(re.getAbsolutePath() + " " + re.exists());
		if (re.isDirectory()) {
			System.out.println("--------------------------------------------------");
			aff1(re);
		}
	}

	public void aff1(File f) {
		File[] lf = f.listFiles();
		for (int i = 0; i < lf.length; i++) {
			if (lf[i].isFile()) {
				// affiche que les fichiers textes
				if (lf[i].getAbsolutePath().toLowerCase().endsWith("txt")) {
					System.out.println(lf[i].getAbsolutePath());
					// FileInputStream fi=new FileInputStream(lf[i]);
					FileReader fr = null;
					BufferedReader bIn = null;
					try {
						fr = new FileReader(lf[i]);
						bIn = new BufferedReader(fr);
						String chaine = bIn.readLine();
						while (chaine != null) {
							System.out.println(chaine);
							chaine = bIn.readLine();
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						try {
							fr.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} else {
				aff1(lf[i]);
			}

		}

	}

}
