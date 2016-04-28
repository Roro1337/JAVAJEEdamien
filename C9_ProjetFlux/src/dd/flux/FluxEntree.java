package dd.flux;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class FluxEntree {
	public static void main(String[] args) {
		FluxEntree f = new FluxEntree();
		f.init();
	}

	public void init() {
		// System.in (entrée console par défaut) n'envoi qu'un flux binaire
		// on créer une instance caractere de ce flux par le InputStramReader
		// on l'instancie () en tant que paquets de flux de caracter afin de le
		// lire ligne par ligne avec le LineNumberReader
		//
		InputStreamReader entreeStandard = new InputStreamReader(System.in);
		LineNumberReader resLecture = new LineNumberReader(entreeStandard);
		String chemin = null;
		PrintWriter out = null;
		try {
			chemin = resLecture.readLine();

			File file = new File(chemin);
			String nomDuSuffixe = null;
			String nomDuFichierDest = "test.txt";
			File resultat = new File("./" + nomDuFichierDest);
			System.out.println(resultat.getAbsolutePath());
			out = new PrintWriter(resultat);

			if (chemin.startsWith(".")) {
				System.out.println("c'est un chemin relatif");
			} else {
				System.out.println("c'est un chemin absolu");
			}

			if (file.exists()) {
				if (file.isDirectory()) {
					System.out.println(file.getAbsolutePath());
					System.out.println("C'est un repertoire et il exist");
					nomDuSuffixe = resLecture.readLine();
					System.out.println(nomDuSuffixe);
					rechercherLesFichier(chemin, nomDuSuffixe, out);
				} else {
					System.out.println("c'est un fichier je ne peux pas rechercher les fichier txt");
				}

			} else {
				System.err.println("Le fichier ou repertoire spécifié n'existe pas");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();

	}

	private void rechercherLesFichier(String chemin, String nomDuSuffixe, PrintWriter out) {
		File file = new File(chemin);
		File[] tabFichier = file.listFiles();
		for (File f : tabFichier) {
			if (f.isDirectory()) {
				System.out.println("C'est un rep" + f.getAbsolutePath());
				rechercherLesFichier(f.getAbsolutePath(), nomDuSuffixe, out);
			} else {
				if (f.getName().toLowerCase().endsWith(nomDuSuffixe.toLowerCase())) {
					System.out.println("j'ai trouve ce fichier:" + f.getName());
					FileReader reader = null;
					BufferedReader bIn = null;
					try {
						reader = new FileReader(f);
						bIn = new BufferedReader(reader);
						String chaine = bIn.readLine();
						while (chaine != null) {
							mettreLaChaineDanLeFichier(chaine, out);
							chaine = bIn.readLine();
						}

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							reader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}

					}
					out.flush();// permet l'enregistrement automatique sur le
								// disque permanence des donnée
					// flush rejet au toilet
				}
			}
		}
	}

	private void mettreLaChaineDanLeFichier(String readLine, PrintWriter out) {
		// TODO Auto-generated method stub
		out.println(readLine);

	}

	// consigne
	// on va ecrire dans la console le chemin d'un répertoire
	// on récupere les fichier TXT du répertoire et des sous repertoires.
	// on concatene le contenu de tout nosfichiers txt
	// dans le fichier résultat.txt

}
